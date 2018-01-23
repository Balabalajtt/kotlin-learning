/**
 * 类成员
 * Created by 江婷婷 on 2018/1/23.
 */
open class A {
    protected var b = 0//默认public
    protected get() {
        //加其他
        println("get")
        return field
    }
//    private set(value) {
//        field = value
//    }
    private set//简写 加访问控制
}

class X
class Y {
    //需要初始化 但是尽量放在构造方法中我弄成初始化
    var a = 0
    lateinit var b: String//之后初始化
    lateinit var d: X
    val e: X by lazy { //val用by lazy
        println("init X")
        X()
    }
}

fun main(args: Array<String>) {
    val a = Y()
    println("init Y")
    println(a.a)
    println(a.e)
    a.b = "Hello"
    println(a.b)
//    println(a.d)//crash未初始化
}

//类的属性有aField anotherField, notAField不是类的属性 只是构造方法的一个参数
class Hello(val aField: Int, notAField: Int) {
    var anotherField: Float = 3F
}
