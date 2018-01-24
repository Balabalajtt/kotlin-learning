/**
 * 接口 抽象类
 * Created by 江婷婷 on 2018/1/24.
 */
interface InputDevice {
    fun input(event: Any)
}

interface USBInputDevice: InputDevice
interface BLEInputDevice: InputDevice

abstract class USBMouse(val name: String): USBInputDevice {
    override fun input(event: Any) {
    }
    override fun toString(): String {
        return name
    }
}

//继承抽象类
class LogitechMouse: USBMouse("罗技鼠标") {

}

class Computer{
    fun addUSBInputDevice(inputDevice: USBInputDevice) {
        println("add usb input device: $inputDevice")
    }
    fun addBLEInputDevice(inputDevice: BLEInputDevice) {
        println("add ble input device: $inputDevice")
    }
    fun addInputDevice(inputDevice: InputDevice) {
        when(inputDevice) {
            is BLEInputDevice -> addBLEInputDevice(inputDevice)
            is USBInputDevice -> addUSBInputDevice(inputDevice)
            else -> throw IllegalArgumentException("不支持")
        }
    }

}


abstract class B {
    var i = 0
    open fun hello() {
        println(i)
    }
    abstract fun hhh()
}

interface C {
//    var j = 1//可以定义但是不能初始化
    var j: Int//相当于定义了setJ和getJ接口方法
    fun hello() {//有默认实现的接口方法 实现时不强制要求实现此方法 因为有默认实现
        println(j)
    }
}

//实现接口C必须实现j
class D(override var j: Int) : C {

}

interface F

//实现抽象类B
class E: B(), F {
    override fun hhh() {

    }

    override fun hello() {
        super.hello()
    }
}

fun main(args: Array<String>) {
    val computer = Computer()
    val mouse = LogitechMouse()
    computer.addInputDevice(mouse)

    val e = E()
    println(e is B)
    println(e is F)
    //可以赋值
    val b: B = E()
    val f: F = E()


}