/**
 * Currying 偏函数
 * Created by 江婷婷 on 2018/1/29.
 */
fun hello2(x: String, y: Int, z: Double): Boolean {
    return true
}

//一个多参数函数 变成一串单参数函数
//fun curriedHello(x: String): (y: Int) -> (z: Double) -> Boolean {}
fun curriedHello(x: String)
        = fun(y: Int)
        = fun(z: Double)
        = true

//定义扩展方法
fun <P1, P2, P3, R> Function3<P1, P2, P3, R>.curried()
    = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = this(p1, p2, p3)

fun main(args: Array<String>) {
    println(curriedHello("a")(1)(1.0))
    ::hello2.curried()("a")(1)(1.0)


}

val hello3 = fun (x: String, y: Int, z: Double): Boolean {
    return true
}

val ph = hello3.partial("固定参数")

//偏函数实现
fun <P1, P2, P3, R> Function3<P1, P2, P3, R>.partial(p1: P1)
        = fun(p2: P2, p3: P3) = this(p1, p2, p3)
