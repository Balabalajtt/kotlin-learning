/**
 * 扩展成员
 * Created by 江婷婷 on 2018/1/24.
 */
//定义扩展函数
fun String.muliply(int: Int): String {
    val stringBuilder = StringBuilder()
    for (i in 0 until int) {
        stringBuilder.append(this)
    }
    return stringBuilder.toString()
}
operator fun String.times(int: Int): String {
    val stringBuilder = StringBuilder()
    for (i in 0 until int) {
        stringBuilder.append(this)
    }
    return stringBuilder.toString()
}
//扩展属性
val String.a: String
    get() {return "aaa"}
var String.b: Int
    set(value) {}
    get() {return this.length}


fun main(args: Array<String>) {
    println("a".muliply(10))
    println("a" * 10)
    println("a".a)
    "a".b = 5
    println("a".b)
}