/**
 * 异常 各种参数
 * Created by 江婷婷 on 2018/1/23.
 */
fun main(args: Array<String>) {
    try {
        if (args.isEmpty()) {
            throw IllegalArgumentException()
        }
        val arg1 = args[0].toInt()
        println(arg1)
    } catch (e: IllegalArgumentException) {
        println("参数个数不对")
    } catch (e: NumberFormatException) {
        println("请输入整数")
    } catch (e: Exception) {
        println("其他异常")
    } finally {
        println("都会执行final语句")
    }

    val result = try{//抛异常时为0 否则是args[0].toInt()
        args[0].toInt()
    } catch (e: Exception) {
        0
    }
    println(result)

    //具名参数使用变长参数函数
    hello(4.0, 1, 2, 3, string = "Hello")
    val ints = intArrayOf(1, 2, 3)
    hello(4.0, *ints, string = "Hello")//*spread operator 不能重载 只能展开数组
    hello(ints = *ints, string = "Hello World")
}

//kotlin变长参数可以放任意地方
//double默认参数
fun hello(double: Double = 1.0, vararg ints: Int, string: String) {
    ints.forEach(::println)
}