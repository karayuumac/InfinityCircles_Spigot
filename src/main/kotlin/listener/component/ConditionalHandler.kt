package listener.component

import org.bukkit.event.Event

/**
 * @author karayuu
 */
class ConditionalHandler<E: Event>(
        private val predicate: (E) -> Boolean,
        private val handler: EventHandler<E>
): EventHandler<E> {
    override operator fun invoke(event: E) {
        if (predicate(event)) handler(event)
    }
}