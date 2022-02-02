package io.github.yandhi.client.event

import kotlin.reflect.KClass

/**
 * an anon class to hold an event.
 */
abstract class EventListener<E : Event>(
    /**
     * The class for the event that this listener handles.
     */
    val eventClass: KClass<E>
) {

    /**
     * The function that runs the event.
     */
    abstract fun publish(event: E)
}