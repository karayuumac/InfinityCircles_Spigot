package listener

import listener.component.EventHandlerList
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent

/**
 * @author karayuu
 */
object PlayerInteractListener : Listener {
    val behaviorList = EventHandlerList<PlayerInteractEvent>()

    @EventHandler
    fun onEvent(event: PlayerInteractEvent) = behaviorList(event)
}