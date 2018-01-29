/**
 * 函数复合
 * Created by 江婷婷 on 2018/1/29.
 */
val add5 = { i : Int -> i + 5 } //g(x)
val multiply2 = { i : Int -> i * 2 } //f(x)

fun main(args: Array<String>) {
    println(multiply2(add5(8)))// (5+8)*2

    val add5AndMultiplyBy2 = add5 andThen multiply2 // m(x)=f(g(x))
    val add5ComposeMultiplyBy2 = add5 compose multiply2 // m(a)=g(f(x)) multiply2 andThen add5
    println(add5AndMultiplyBy2(8))
    println(add5ComposeMultiplyBy2(8))

}


//        <P1, P2, R> andThen类型 两个参数P1P2 一个返回R
//                             <P1, P2> andThen前面函数类型 一个参数P1 一个返回P2 P1相当于8 P2相当于5+8
//                                                                 <P2, R> andThen后面函数的类型 一个参数P2 一个返回R P2是前面函数传的 R相当于(5+8)*2
//                                                                                    <P1, R> andThen复合后的函数类型 一个参数P1 返回R
//                        g(x)                     f(x)
infix fun <P1, P2, R> Function1<P1, P2>.andThen(function: Function1<P2, R>): Function1<P1, R> {
    return fun(p1: P1): R {//复合后函数签名 一个参数P1 一个返回值R
        return function.invoke(this.invoke(p1)) // f(g(x))
    }
}

//反过来的
infix fun <P1, P2, R> Function1<P2, R>.compose(function: Function1<P1, P2>): Function1<P1, R> {
    return fun(p1: P1): R {
        return this.invoke(function.invoke(p1))
    }
}