import java.util.concurrent.Executors
import javax.swing.SwingUtilities
import kotlin.coroutines.experimental.*

/**
 * 异步
 * Created by 江婷婷 on 2018/1/30.
 */
fun main(args: Array<String>) {
    val frame = MainWindow()
    frame.init()
    frame.setSize(200, 250)
    frame.isVisible = true
    frame.onButtonClick {
        beginCoroutine {
            val imageData = loadImage()
            frame.setImage(imageData)
        }
    }
}

private val pool by lazy {
    Executors.newCachedThreadPool()
}

class AsyncTask(val block:()->Unit) {
    fun execute() = pool.execute(block)
}

fun beginCoroutine(block: suspend ()->Unit) {
    block.startCoroutine(BaseContinuation())
}

suspend fun loadImage() = suspendCoroutine<ByteArray> {
    continuation ->
    AsyncTask {
        try {
            val responseBody = Service.service.getImage().execute()
            if (responseBody.isSuccessful) {
                responseBody.body()?.byteStream()?.readBytes()?.let{
                    SwingUtilities.invokeLater {//切线程
                        continuation.resume(it)
                    }
                }
            } else {
                continuation.resumeWithException(Exception())
            }
        } catch (e: Exception) {
            continuation.resumeWithException(e)
        }
    }.execute()
}
