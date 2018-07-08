package display

import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

/**
 * @author karayuu
 */

fun Inventory.set(vararg ranges: IntRange, item: ItemStack) {
    for (range in ranges) {
        for (i in range) {
            this.setItem(i, item)
        }
    }
}