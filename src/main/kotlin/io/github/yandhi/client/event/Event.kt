package io.github.yandhi.client.event

/**
 * A class to be implemented by various events.
 */
open class Event {
    /**
     * Whether the event is currently cancelled.
     */
    var cancelled = false
}