/**
 * 访问权限 Object
 * Created by 江婷婷 on 2018/1/24.
 */
class CCC {
    private val pri: Int = 1
    val pub: Int = 2//成员默认public
    internal val inter: Int = 3//module内可见 和java不共存
    protected val pro: Int = 4//子类
}


//独一无二的 只有一个对象存在 简单的单例实现 class的特殊
//不能自定义构造方法 可以实现接口、继承抽象类
object MusicPlayer: III, AAA() {
    val state: Int = 0
    fun play(url: String) {

    }

    fun stop() {

    }
}
interface III
abstract class AAA

fun main(args: Array<String>) {
    MusicPlayer.play("...")
}