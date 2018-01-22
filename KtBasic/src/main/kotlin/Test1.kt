/**
 * 基本类型 常量变量
 * Created by 江婷婷 on 2018/1/22.
 */

val aString: String = "Hello"
val bString: String = String(charArrayOf('H', 'e', 'l', 'l', 'o'))

val aInt: Int = 5
val bInt: Int = 2
val aLong: Long = aInt.toLong()

val FINAL_STRING: String = "Hello"//常量 value不可重复赋值
var string: String = "Hello"//变量
val FINAL_S = "HelloWorld"//编译器类型推倒

val x = 2//运行时常量
const val y = 2//编译期常量

fun main(args: Array<String>) {
    println(Float.NaN == 0.0F/0.0F)
    println(aString == bString)//equals
    println(aString === bString)//==

    println("$aInt + $bInt = ${aInt + bInt}")
    val ss: String = """
    fwa\t\$\\\\
    """//不转义 原样输出
    println(ss)
    println(ss.length)

}