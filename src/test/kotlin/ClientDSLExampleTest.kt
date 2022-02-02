import io.github.yandhi.client.client
import io.github.yandhi.client.plugin.plugin
import org.junit.jupiter.api.Test

class ClientDSLExampleTest {

    @Test
    fun testDSL() {
        client("test", "1.0.0") {
            plugin("testplugin", it) {

            }

            println(it.getPlugins().size)
        }
    }
}