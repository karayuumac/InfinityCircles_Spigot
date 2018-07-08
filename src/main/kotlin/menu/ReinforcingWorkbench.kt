package menu

import display.blue
import display.set
import display.setName
import display.toRange
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

/**
 * @author karayuu
 */
object ReinforcingWorkbench {
    fun getMenu() : Inventory {
        val inventory = Bukkit.createInventory(null, 9*6, "強化テーブル".blue())
        val emptyGlass = ItemStack(Material.STAINED_GLASS_PANE, 1, 7).setName("")

        inventory.set(0..11, 13.toRange(), 15..21, 23..39, 41..53, item = emptyGlass)

        return inventory
    }
}