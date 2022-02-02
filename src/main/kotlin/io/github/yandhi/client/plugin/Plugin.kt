package io.github.yandhi.client.plugin

import io.github.yandhi.client.Client

/**
 * A "part" of a client.
 *
 * <p>
 * normally held in a collection.
 * </p>
 */
open class Plugin(val label: String)

/**
 * implementation of [Plugin] that can be toggled.
 */
open class TogglePlugin(label: String) : Plugin(label) {
    /**
     * State of the plugin.
     */
    var running = false

    /**
     * Toggles the running state of the plugin.
     */
    fun toggle() {
        this.running = !running

        if (running) {
            enable()
        } else {
            disable()
        }
    }

    fun enable() {

    }

    fun disable() {

    }
}

/**
 * creates a plugin.
 */
fun plugin(label: String, client: Client, lambda: (Plugin) -> Unit) {
    client.plugins.add(Plugin(label).apply(lambda))
}

/**
 * Creates a toggle plugin.
 */
fun toggle(label: String, client: Client, lambda: (TogglePlugin) -> Unit) {
    client.plugins.add(TogglePlugin(label).apply(lambda))
}