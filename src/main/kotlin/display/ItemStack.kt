package display

import org.bukkit.inventory.ItemStack

/**
 * @author karayuu
 */

fun ItemStack.setName(name: String) : ItemStack {
    this.itemMeta.displayName = name
    return this
}