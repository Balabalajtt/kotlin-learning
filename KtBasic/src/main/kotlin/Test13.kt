/**
 * 伴生对象 静态成员 方法重载
 * Created by 江婷婷 on 2018/1/24.
 */
//定义静态成员尽量考虑使用包级函数、变量
class Latitude private constructor(val value:Double) {
    //类的伴生对象 相当于静态方法
    //伴生对象成员相对于类来说只有一份
    companion object{
        @JvmStatic //加注释后和kotlin一样的写法 像是静态方法
        fun ofDouble(double: Double): Latitude{
            return Latitude(double)
        }
        fun ofLatitude(latitude: Latitude): Latitude{
            return Latitude(latitude.value)
        }

        @JvmField //java调用时像是静态变量
        val TAG: String = "aaa"//
    }
}

fun main(args: Array<String>) {
    val l1 = Latitude.ofDouble(37.5)//无注释时 java用的时候Latitude.Companion.of(...)
    val l2 = Latitude.ofLatitude(l1)
    println(Latitude.TAG)

    val o = Overloads()
    o.b()

}

//方法重载 方法名相同 参数列表不同 与返回值无关
class Overloads{
    fun a(): Int{
        return 0
    }
    fun a(int: Int): Int{
        return int
    }

    //方法重载可以转换为默认参数来实现
    //上面两个可以合并为
    fun b(int: Int = 0): Int{
        return int
    }
}