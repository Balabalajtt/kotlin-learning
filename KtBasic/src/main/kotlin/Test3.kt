/**
 * 非空和类型转换
 * Created by 江婷婷 on 2018/1/22.
 */

fun getName(): String? {
    return "Hello"
}

open class Parent
class Child: Parent() {
    fun getName(): String {
        return "Child"
    }
}

fun main(args: Array<String>) {
    val name = getName()
//    if (name != null) {
//        println(name.length)
//    } else {
//        println(null)
//    }
    //相当于
    println(name?.length)

    //如果getName返回空则直接返回，否则将返回值赋给类型不为空的String
    val string: String = getName() ?: return
    //这里string一定不为空
    println(string.length)

    val ss: String? = "HelloHello"
    //可空类型想要输出可以加 !!
    println(ss!!.length)

    val parent: Parent = Child()
    if (parent is Child) {
        println(parent.getName())//判断过后不需要强转 编译器推到
    }

    val p: Parent = Parent()
    //类型转换的写法
//    val c: Child? = p as Child//强制转换 转换失败是抛异常
    val ch: Child? = p as? Child//转换失败时返回null
    println(ch)

//    val notNull: String = null//错误 不能为空
    val notNull: String = "HelloWorld"
    val nullable: String? = null
    notNull.length//正确 不为空可以直接引用
//    nullable.length//错误 可能为空不能直接引用
//    nullable!!.length//正确 强制认定nullable不可空 为空时抛异常
    nullable?.length//正确 若nullable为空 返回空

}

