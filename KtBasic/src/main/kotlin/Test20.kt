/**
 * 闭包
 * Created by 江婷婷 on 2018/1/29.
 */
fun makeFun(): ()->Unit {
    var count = 0
    return fun() {
        println(++count)
    }
}

fun fibonacci(): ()->Long {
    //值一直存在 作用域没有释放
    var first = 0L
    var second = 1L
    return fun():Long {
        val result = second
        second += first
        first = second - first
        return result
    }
}

fun fibonacci2(): Iterable<Long> {
    //值一直存在 作用域没有释放
    var first = 0L
    var second = 1L
    return Iterable {
        object : LongIterator() {
            override fun nextLong(): Long {
                val result = second
                second += first
                first = second - first
                return result
            }

            override fun hasNext(): Boolean = true

        }
    }
}

fun add(x: Int) = fun(y: Int) = x + y
//相当于
//fun add(x: Int): (Int) -> Int {
//    return fun(y: Int): Int {
//        return x + y
//    }
//}


fun main(args: Array<String>) {
    val x = makeFun()
    x()
    x()
    x()
    x()

    val f = fibonacci()
    println(f())
    println(f())
    println(f())
    println(f())

    fibonacci2().takeWhile { it <= 100 }.forEach { println(it) }

    val add5 = add(5)
    println(add5(2))

}