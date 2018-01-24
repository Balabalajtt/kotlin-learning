/**
 * 继承
 * Created by 江婷婷 on 2018/1/24.
 */
//abstract抽象类可以继承 普通类默认final必须加open才能继承
abstract class Person(open val age: Int) {
    //重写必须open
    open fun work() {}
}

//Person(age)调用的时Programmer主构造方法
//class Programmer(override val age: Int): Person(age) {
class Programmer(age: Int): Person(age) {
    //重写属性
    override val age: Int
        get() = 0

    override fun work() {
        super.work()
        println("我是程序员")
    }
}

class Doctor(age: Int): Person(age) {
    override fun work() {
        super.work()
        println("我是医生")
    }
}

fun main(args: Array<String>) {
    val person: Person = Programmer(19)
    person.work()
    println(person.age)

}

class Manager: Driver, Writer {
    override fun write() {

    }
    override fun drive() {

    }
}

//class SuperManager(val driver: Driver, val writer: Writer): Driver, Writer {
//    override fun write() {
//        writer.write()
//    }
//    override fun drive() {
//        driver.drive()
//    }
//}
//可以写成 接口代理
class SuperManager(val driver: Driver, val writer: Writer): Driver by driver, Writer by writer

interface Driver{
    fun drive()
}
interface Writer {
    fun write()
}


interface I{
    fun f(): Int = 1
}
interface J{
    fun f(): Int = 2
}
abstract class Z{
    open fun f(): Int = 3
}
//解决方法名冲突 能解决必须要方法签名一样 如果方法名一样但是返回类型不同是解决不了的
class K(var judge: Int = 5): I, J, Z(){

    override fun f(): Int {
        if (judge < 0) {
            return super<I>.f()
        } else if (judge < 10){
            return super<J>.f()
        } else {
            return super<Z>.f()
        }
    }
}

