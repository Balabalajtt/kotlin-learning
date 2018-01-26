/**
 * 密封类 枚举
 * Created by 江婷婷 on 2018/1/26.
 */
//密封类 子类有限 可以定义在类里面 1.1之后也可以定义在同一个文件中
sealed class PlayerCmd {
    class Play(val url: String, val position: Long = 0) : PlayerCmd()
    class Seek(val position: Long) : PlayerCmd()
    object Pause : PlayerCmd()
    object Resume : PlayerCmd()
    object Stop : PlayerCmd()
}

//枚举 实例有限
enum class LogLevel(val id: Int){
    VERBOSE(10), DEBUG(11), INFO(12), WARN(13), ERROR(14), ASSERT(15);
    fun getTag(): String{
        return "$id $name"
    }
}

fun main(args: Array<String>) {
    println(LogLevel.DEBUG.getTag())
    println(LogLevel.DEBUG.ordinal)//第几个
    LogLevel.values().map(::println)
    println(LogLevel.valueOf("ERROR"))//对应toString()
}