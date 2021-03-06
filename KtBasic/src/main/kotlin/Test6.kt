/**
 * lambda表达式
 * Created by 江婷婷 on 2018/1/22.
 */
val add = {a: Int, b: Int ->//参数
    println("$a + $b = ${a + b}")
    a + b //最后一行为lambda表达式的类型
}//(Int, Int) -> Int

val printHello = {
    println("Hello")
}

fun main(args: Array<String>) {
    println(add(1, 2))
    println(add.invoke(1, 2))//等价

    args.forEach ({it->println(it)})//如果最后一个参数是lambda表达式 就可以把{}移到外面
    args.forEach (){it->println(it)}//如果小括号没有东西 就可以省略
    args.forEach {it->println(it)}//lambda唯一参数默认为it
    args.forEach {println(it)}//一系列省略 接受参数和lambda表达式类型一致
    args.forEach(::println)

    //标签
    args.forEach ForEach@ {
        if (it == "q") {
//            return//return main函数
          return@ForEach//跳的一个foreach语句
        }
        print("$it ")
    }
    println("End")
    println(add)//Function2<java.lang.Integer, java.lang.Integer, java.lang.Integer>
    println(printHello)//Function0<kotlin.Unit>
    println(::sum)//拿不到
    println(::sum is (Int, Int) -> Int)//true

    val input = readLine()
    if (input != null) {
        val split = input.split(" ")
        val arg1 = split[0].toDouble()
        val op = split[1]
        val arg2 = split[2].toDouble()
        println("$arg1 $op $arg2 = ${Operator(op).apply(arg1, arg2)}")
    }

}

class Operator(op: String) {
    //定义了一个lambda表达式
    val opFun: (left: Double, right: Double) -> Double
    //初始lambda表达式
    init {
        opFun = when(op) {
            "+" -> {l, r -> l + r}
            "-" -> {l, r -> l - r}
            "*" -> {l, r -> l * r}
            "/" -> {l, r -> l / r}
            "%" -> {l, r -> l % r}
            else -> {
                throw UnsupportedOperationException(op)
            }
        }
    }
    fun apply(left: Double, right: Double): Double {
        return opFun(left, right)
    }
}