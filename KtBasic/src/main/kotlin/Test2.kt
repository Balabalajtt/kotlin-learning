/**
 * 类对象
 * Created by 江婷婷 on 2018/1/22.
 */
class 男生(名字:String, 长相:String): 人(名字, 长相)
class 女生(名字:String, 长相:String): 人(名字, 长相)

open class 人(var 名字:String, var 长相:String) {
    init {
        println("new了一个人，叫$名字，长得$长相。")
    }

    override fun toString(): String {
        return 名字
    }
}

fun main(args: Array<String>) {
    val 我喜欢的男生: 男生 = 男生("曾帅智", "好看")
    val 我: 女生 = 女生("江婷婷", "好看")
    println(我 is 人)
    println(我喜欢的男生 is 人)

}
