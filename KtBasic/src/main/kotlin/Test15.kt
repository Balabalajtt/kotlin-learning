import kotlin.reflect.KProperty

/**
 * 属性代理
 * Created by 江婷婷 on 2018/1/24.
 */
class Delegates{
    //属性代理
    val hello by lazy {
        "Hello World"
    }
    //代理之后get set都是Dl的
    val h by Dl()//val需要getValue()
    var hh by Dl()//var需要getValue() setValue()
}

class Dl {
    private var realValue: String? = null
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String{
        return realValue?:""
    }
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        this.realValue = value
    }
}