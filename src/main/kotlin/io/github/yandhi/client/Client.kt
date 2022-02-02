package io.github.yandhi.client

import io.github.yandhi.client.event.EventBus
import io.github.yandhi.client.plugin.Plugins

/**
 * data class to "hold a client"
 *
 * @author yandhi
 * @since 2/2/22 *angel numbers*
 */
class Client(val label: String, val version: String) {
    /**
     * the encapsulation of the plugins.
     */
    val plugins = Plugins()

    /**
     * The event bus that the client has.
     */
    val eventBus = EventBus()
}

/**
 * makes a client object.
 */
fun client(label: String, version: String, lambda: (Client) -> Unit) = Client(label, version).apply(lambda)