/**
 * 运算符 分支语句 循环语句
 * Created by 江婷婷 on 2018/1/23.
 */
class Complex(var real: Double, var imaginary: Double) {
    //operator fun 运算符函数名 随便的参数列表 随便的返回值
    //定义了+运算符
    operator fun plus(other: Complex): Complex {
        return Complex(real + other.real, imaginary + other.imaginary)
    }
    operator fun plus(other: Int): Complex {
        return Complex(real + other, imaginary)
    }
    operator fun invoke(): Double {
        return Math.hypot(real, imaginary)
    }

    override fun toString(): String {
        return "$real + ${imaginary}i"
    }
}

class Book {
    //中缀表达式
    //如果函数只有一个参数 可以定义中缀表达式 简化.()调用
    infix fun on(any: Any): Boolean {
        return false
    }
}

private const val USERNAME = "kotlin"
private const val PASSWORD = "jetbrains"

fun main(args: Array<String>) {
    val c1 = Complex(3.0, 4.0)//3 + 4i
    val c2 = Complex(2.0, 3.5)//2 + 3.5i
    println(c1 + c2)
    println(c1 + 5)
    println(c1())//c1取模

    if (Book() on "My Desk") {}//dsl

    println("用户名：")
    val username = readLine()
    println("密码：")
    val password = readLine()
    //if表达式 分支必须完整
    val ans = if (username == USERNAME && password == PASSWORD) "success" else "fail"
    println(ans)

    val x = 105
    //when 第一个成立就不会执行后面了
    when(x) {
        in 1..100 -> println("$x is in 1..100")
        !in 1..100 -> println("$x is not in 1..100")
        is Int -> println("Hello $x")
        args[0].toInt() -> println("x == args[0]")
        else -> println("default")
    }
    val w = when {
        args.isNotEmpty() && args[0] == "1" -> 1
        else -> 0
    }
    println("w = $w")

    for((index, value) in args.withIndex()) {
        println("$index -> $value")
    }

    val list = MyIntList()
    list.add(1)
    list.add(2)
    list.add(3)
    //会调用next和hasNext 迭代的list必须有operator fun iterator()  iterator必须有next() hasNext()
    for (i in list) {
        println(i)
    }
}

class MyIterator(val iterator: Iterator<Int>) {
    operator fun next(): Int{
        return iterator.next()
    }
    operator fun hasNext(): Boolean{
        return iterator.hasNext()
    }
}

class MyIntList{
    private val list = ArrayList<Int>()
    fun add(int: Int) {
        list.add(int)
    }
    fun remove(int:Int) {
        list.remove(int)
    }
    operator fun iterator(): MyIterator{
        return MyIterator(list.iterator())
    }
}