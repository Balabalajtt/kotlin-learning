/**
 * data class 内部类
 * Created by 江婷婷 on 2018/1/26.
 */
data class Country(val id: Int, val name: String)//初始赋值 没有无参构造方法

class ComponentX{
    operator fun component1(): String{
        return "1"
    }
    operator fun component2(): String{
        return "2"
    }
    operator fun component3(): String{
        return "3"
    }
    operator fun component4(): Int{
        return 4
    }
}

fun main(args: Array<String>) {
    val china = Country(0, "中国")
    println(china)//默认实现toString()
    val (id, name) = china
    println(id)
    println(name)

    for ((index, value) in args.withIndex()) {//withIndex()返回一个data class集合
        println(index)
        println(value)
    }

    val componentX = ComponentX()
    val (a, b, c, d) = componentX
    println("$a $b $c $d")

    //data class不同于java bean 没有无参构造方法同时是final修饰

    val staticInner = Outter.StaticInner()//kotlin默认内部类是静态内部类
    val inner = Outter().Inner()

}

class Outter{
    val a: Int = 5
    class StaticInner//静态内部类
    inner class Inner {//非静态内部类
        val a = 2
        fun hello() {
            val a = 0
            println(a)
            println(this.a)
            println(this@Outter.a)
        }
    }
}



