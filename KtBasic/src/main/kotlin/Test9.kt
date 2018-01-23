/**
 * 异常
 * Created by 江婷婷 on 2018/1/23.
 */
fun main(args: Array<String>) {
    try {
        val arg1 = args[0].toInt()
        println(arg1)
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

}