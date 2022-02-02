package io.github.yandhi.client.event

/**
 * Runs events for us!
 */
class EventBus {
    /**
     * The listeners for the bus.
     */
    private val listeners = arrayListOf<EventListener<*>>()

    /**
     * Publishes listeners based on the event.
     *
     * @param event The event being fired.
     */
    fun <E : Event> publish(event: E) {
        for (listener in listeners) {
            if (listener.eventClass == event::class) {
                listener as EventListener<E>
                listener.publish(event)
            }
        }
    }

    /**
     * Subscribes the listener.
     *
     * @param listener The listener being subscribed.
     */
    fun subscribe(listener: EventListener<*>) {
        listeners.add(listener)
    }

    /**
     * Un subscribes the listener.
     *
     * @param listener The listener being subscribed.
     */
    fun unsubscribe(listener: EventListener<*>) {
        listeners.remove(listener)
    }
}

/**
 * creates a listener using kotlin's lambda system.
 *
 * <p>
 * a friend named dan showed me how to do this a while ago, thanks.
 * </p>
 */
inline fun <reified E : Event> listener(crossinline handler: (E) -> Unit): EventListener<E> {
    return object : EventListener<E>(E::class) {
        override fun publish(event: E) {
            handler(event)
        }
    }
}