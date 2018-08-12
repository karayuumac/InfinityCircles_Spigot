package listener

import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

/**
 * @author karayuu
 */
class LimitedEventListener<E: Event>(
        val condition: (E) -> Boolean,
        val handle: (E) -> Unit
) : Listener {

    @EventHandler
    inline fun onFire(event: E) {
        if (condition(event)) {
            handle(event)
        }
    }
}