import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.util.ArrayList

/**
 * 高阶函数
 * Created by 江婷婷 on 2018/1/29.
 */
fun main(args: Array<String>) {
    //引用包级方法
    // <T> Array<out T>.forEach(action: (T) -> Unit): Unit
    // println(message: Any?)
    args.forEach(::println)

    //拿到成员方法的引用
    val helloWorld = HelloClass::world

    // <T> Array<out T>.filter(predicate: (T) -> Boolean): List<T>
    //CharSequence.isNotEmpty(): Boolean
    //CharSequence调用isNotEmpty 相当于传了一个参数 所以可以作为filter参数
    //扩展方法默认的第一个参数就是调用它的实例
    args.filter(String::isNotEmpty)

    //PdfPrinter的println第一个参数是HelloClass实例 第二个是any 和forEach参数类型不匹配
//    args.forEach(PdfPrinter::println)
    //需要创建实例 用实例调用 此时只有一个参数any kotlin1.1开始
    val pdfPrinter = PdfPrinter()
    args.forEach(pdfPrinter::println)

//    commonUse()

    //统计文件字符个数输出
    File("build.gradle").readText().toCharArray().filterNot(Char::isWhitespace)
            .groupBy { it }.map { it.key to it.value.size }.forEach(::print)

}

class HelloClass {
    fun world(){
        println("Hello World")
    }
}

class PdfPrinter{
    fun println(any: Any) {
        kotlin.io.println(any)
    }
}

//常用高阶函数
fun commonUse() {
    val list = listOf(1, 3, 4, 5, 10, 8, 2)

//    val newList = ArrayList<Int>()
//    list.forEach{
//        newList.add(it * 2 + 3)
//    }
    //用map()简化
    val newList = list.map {
        it * 2 + 3//lambda表达式返回值传给一个新的arrayList
    }
    newList.forEach(::println)
    val newList2 = list.map(Int::toDouble)
    newList2.map(::println)//可以迭代但是有新list会影响性能 这里应该用forEach

    //flatMap
    val list2 = listOf(1..20, 2..5, 100..322)
    // <T, R> Iterable<T>.flatMap(transform: (T) -> Iterable<R>): List<R>
    val daping = list2.flatMap { it }//把集合打平
    val flatList = list2.flatMap {
        it.map {
            "No.$it"//这里的it才是单个数字 外层如果写it其实是intRange
        }
    }
    flatList.forEach(::println)

    //reduce
    println(list.reduce { acc, s -> acc + s })//求和
    println((1..4).reduce { acc, s -> acc * s })//阶乘
    (1..4).map(::jiecheng).forEach(::println)//1到4每个数的阶乘并输出
    println((1..4).map(::jiecheng).reduce { acc, i -> acc + i })//阶乘的和

    //fold
    println((1..4).map(::jiecheng).fold(5) { acc, i -> acc + i })//阶乘的和 (5)是初始值
    println((0..6).map(::jiecheng).fold(StringBuilder()){
        acc, i -> acc.append(i).append(" ")
    })
    println((0..6).map(::jiecheng).foldRight(StringBuilder()){
        i, acc -> acc.append(i).append(" ")//参数换位置了 输出倒着
    })

    //filter
    println((1..4).map(::jiecheng).filter { it % 2 == 1 })//lambda返回true时保留
    println((1..4).map(::jiecheng).filterIndexed{ index, i -> index % 2 == 1 })
    println((1..4).map(::jiecheng).takeWhile { it % 2 == 1 })//终止条件


    //joinToString
    println((1..6).joinToString(","))

    //let
    val aa = findAA()
    println(aa?.name)
    println(aa?.age)
    //不为空时输出 可省略问号
    findAA()?.let { (name, age) ->
        println(name)
        println(age)
    }

    //apply 调用者传参数
    findAA()?.apply {
        fff()
        println(age)
    }

    //with
    val br = BufferedReader(FileReader("hello.txt"))
    with(br){//br的作用域 可以直接写
        var line: String?
        while (true) {
            line = readLine()?:break//这里不需要br.readLine()
            println(line)
        }
        close()
    }
    //简化 封装了很多方法
//    val br = BufferedReader(FileReader("hello.txt")).readText()

    //use Closeable 可以省略close()
    BufferedReader(FileReader("hello.txt")).use {
        var line: String?
        while (true) {
            line = it.readLine()?:break//要加it 要不然是stdin.readLine()
            println(line)
        }
    }

}

fun jiecheng(n: Int): Int {
    if (n == 0) {
        return 1
    } else {
        return (1..n).reduce { acc, s -> acc * s }
    }
}

data class AA(val name: String, val age: Int) {
    fun fff() {
        println("fff")
    }
}
fun findAA(): AA?{
    return null
}