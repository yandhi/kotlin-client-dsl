package io.github.yandhi.client.plugin

import io.github.yandhi.client.Client

/**
 * Holds a collection of plugins.
 *
 * <p>
 * a client will have these.
 * </p>
 */
class Plugins(val client: Client) {
    /**
     * the collection that we are encapsulating.
     */
    val plugins = mutableListOf<Plugin>()
}