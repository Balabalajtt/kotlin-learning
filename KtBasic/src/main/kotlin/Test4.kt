/**
 * 区间和数组
 * Created by 江婷婷 on 2018/1/22.
 */

val range1: IntRange = 0..1024//[0, 1024]
val range2: IntRange = 0 until 1024//[0, 1024)
val empty: IntRange = 0..-1

val intArray: IntArray = intArrayOf(1, 3, 5, 7)
val charArray: CharArray = charArrayOf('H', 'e', 'l', 'l', 'o')
val stringArray: Array<String> = arrayOf("H", "E", "L", "L", "O", "WORLD")
val classArray: Array<人> = arrayOf(人("a", "a"), 人("b", "b"), 人("c", "c"))

fun main(args: Array<String>) {
    println(empty.isEmpty())
    println(range1.contains(50))
    println(50 in range1)
    for(i in range1) {
        print("$i ")
    }

    println(classArray.size)
    for(ren in classArray) {
        println(ren)
    }
    intArray[0] = 2
    println(intArray[0])
    println(charArray.joinToString(""))
    println(stringArray.slice(1..3))

}