package io.github.yandhi.client.plugin

import java.util.*

/**
 * Holds a collection of plugins.
 *
 * <p>
 * a client will have these.
 * </p>
 */
class Plugins {
    /**
     * the collection that we are encapsulating.
     */
    private val plugins = hashMapOf<String, Plugin>()

    /**
     * Adds a plugin to the collection.
     */
    fun add(plugin: Plugin) {
        plugins[plugin.label.lowercase()] = plugin
    }

    /**
     * Gets a plugin by just the string.
     */
    fun get(plugin: String) = Optional.ofNullable(plugins[plugin.lowercase()])

    /**
     * Gets the plugins.
     */
    fun getPlugins() = plugins
}