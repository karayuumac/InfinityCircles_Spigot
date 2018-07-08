package listener

import menu.ReinforcingWorkbench
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.PlayerInteractEvent

/**
 * @author karayuu
 */
class MenuListener : Listener {
    @EventHandler
    fun onPlayerClickWithStick(event: PlayerInteractEvent) {
        if (event.material != Material.STICK) {
            return
        }
        event.player.openInventory(ReinforcingWorkbench.getMenu())
    }

    @EventHandler
    fun onPlayerClickItemEvent(event: InventoryClickEvent) {
        if (!event.inventory.name.contains("メニュー")) {
            return
        }
        event.isCancelled = true
    }
}