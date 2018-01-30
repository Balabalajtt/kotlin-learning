import com.sun.net.httpserver.HttpServer
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.event.ActionEvent
import javax.swing.*
import kotlin.coroutines.experimental.*

/**
 * Coroutine简化请求写法
 * Created by 江婷婷 on 2018/1/30.
 */
const val IMAGE_URL = "https://avatars2.githubusercontent.com/u/26753169?s=400&u=b8c93cb92c333a0a9c77414a230a1a7dacd332e6&v=4"

fun main(args: Array<String>) {
    val frame = MainWindow()
    frame.init()
    frame.setSize(200, 250)
    frame.isVisible = true
    frame.onButtonClick {
        startCoroutine {//同步操作 协程不能自己切换线程
            val imageData = startLoadImage()
            frame.setImage(imageData)
        }
    }

//    frame.onButtonClick {
//        //原始写法
//        Service.service.getImage()
//                .enqueue(object : Callback<ResponseBody> {
//                    override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {}
//                    override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
//                        if (response!!.isSuccessful) {
//                            val imageData = response.body()?.byteStream()?.readBytes()
//                            if (imageData != null) {
//                                SwingUtilities.invokeLater {//切换线程
//                                    frame.setImage(imageData)
//                                }
//                            }
//                        }
//                    }
//
//                })
//    }

}


//coroutine
fun startCoroutine(block: suspend ()->Unit) {
    block.startCoroutine(BaseContinuation())
}

suspend fun startLoadImage() = suspendCoroutine<ByteArray> {
    continuation ->
    try {
        val responseBody = Service.service.getImage().execute()
        if (responseBody.isSuccessful) {
            responseBody.body()?.byteStream()?.readBytes()?.let(continuation::resume)
        } else {
            continuation.resumeWithException(Exception())
        }
    } catch (e: Exception) {
        continuation.resumeWithException(e)
    }
}

class BaseContinuation: Continuation<Unit>{
    override val context: CoroutineContext = EmptyCoroutineContext

    override fun resume(value: Unit) {}

    override fun resumeWithException(exception: Throwable) {}

}

//retrofit
interface HttpService {
    @GET("/u/26753169?s=400&u=b8c93cb92c333a0a9c77414a230a1a7dacd332e6&v=4")
    fun getImage(): Call<ResponseBody>
}

object Service{
    val service:HttpService by lazy {
        Retrofit.Builder().baseUrl("https://avatars2.githubusercontent.com").build().create(HttpService::class.java)
    }
}

//ui
class MainWindow: JFrame() {
    private lateinit var button: JButton
    private lateinit var image: JLabel
    fun init() {
        button = JButton("点击获取图片")
        image = JLabel()
        image.size = Dimension(200, 80)
        contentPane.add(button, BorderLayout.NORTH)
        contentPane.add(image, BorderLayout.CENTER)
    }

    fun onButtonClick(lisener: (ActionEvent)->Unit) {
        button.addActionListener(lisener)
    }

    fun setImage(imageData: ByteArray) {
        image.icon = ImageIcon(imageData)
    }

}
