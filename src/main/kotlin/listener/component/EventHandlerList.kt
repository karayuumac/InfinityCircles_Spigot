package listener.component

import org.bukkit.event.Event

/**
 * @author karayuu
 */
typealias EventHandler<E> = (E) -> Unit

class EventHandlerList<E: Event>: EventHandler<E>, MutableList<EventHandler<E>> by ArrayList<EventHandler<E>>() {
    override fun invoke(event: E) {
        forEach { it(event) }
    }
}