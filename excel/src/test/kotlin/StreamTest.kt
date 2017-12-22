import com.sun.xml.internal.messaging.saaj.util.ByteInputStream
import java.io.*

/**
 * Created by yinjun on 13/11/2017
 */
class StreamTest {

    fun tst(){
        val path = ""
        val input = FileInputStream(path)
        val bOutStream = ByteArrayOutputStream()
        val bInStream = ByteInputStream()
        val pipOutStream = input as PipedOutputStream
        val pipInputStream = PipedInputStream(pipOutStream)
    }
}