package io.github.yandhi.client

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
    private val plugins = Plugins(this)

    /**
     * the actual collection of plugins.
     */
    fun getPlugins() = plugins.plugins
}

/**
 * makes a client object.
 */
fun client(label: String, version: String, lambda: (Client) -> Unit) = Client(label, version).apply(lambda)