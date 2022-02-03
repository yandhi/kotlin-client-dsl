import io.github.yandhi.client.Client
import io.github.yandhi.client.client
import io.github.yandhi.client.plugin.*
import org.junit.jupiter.api.Test
import kotlin.reflect.cast

class ClientDSLExampleTest {

    /**
     * Our tester client.
     */
    lateinit var client: Client

    @Test
    fun testDSL() {
        client = client("test", "1.0.0") { client ->
            plugin("testplugin", client) {

            }
            toggle("testtoggle", client) {
                enable(it) {
                    println("enabling...")
                }
                disable(it) {
                    println("disabling...")
                }
            }
        }

        client.plugins.getPlugins().values.stream()
            .filter { it is TogglePlugin }
            .map(TogglePlugin::class::cast)
            .forEach {
                println(it.label)
                it.toggle()
            }
    }
}