package menu.component.button

import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack

/**
 * @author karayuu
 */
interface BaseButton {
    fun getItemStack() : ItemStack
    fun execute(event: InventoryClickEvent)
}
