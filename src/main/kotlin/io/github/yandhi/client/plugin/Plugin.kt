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
     * Runs on enable.
     */
    val enablers = arrayListOf<() -> Unit>()

    /**
     * Runs on disable.
     */
    val disablers = arrayListOf<() -> Unit>()

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
        enablers.forEach { it.invoke() }
    }

    fun disable() {
        disablers.forEach { it.invoke() }
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

/**
 * Adds an enabler.
 */
fun enable(plugin: TogglePlugin, lambda: () -> Unit) {
    plugin.enablers.add(lambda)
}

/**
 * Adds a disabler.
 */
fun disable(plugin: TogglePlugin, lambda: () -> Unit) {
    plugin.disablers.add(lambda)
}