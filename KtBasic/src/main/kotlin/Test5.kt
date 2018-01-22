/**
 * function
 * Created by 江婷婷 on 2018/1/22.
 */

//返回值Unit同void 可省略不写
fun main(args: Array<String>): Unit{
    checkArgs(args)
    val a = args[0].toInt()
    val b = args[1].toInt()
    println(sum(a, b))

    int2Long(2)
}

fun checkArgs(args: Array<String>) {
    if (args.size != 2) {
        println("输入两个参数")
        System.exit(0)
    }
}

//fun sum(a: Int, b: Int): Int {
//    return a + b
//}
//可以写成 返回值=
fun sum (a: Int, b: Int) = a + b

//匿名函数 函数也是个类型 可以赋值
val int2Long = fun(x: Int): Long {
    return x.toLong()
}