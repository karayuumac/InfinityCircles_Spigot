package listener

import org.bukkit.Material
import org.bukkit.block.Sign
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent

/**
 * @author karayuu
 */
class PlayerInteractListener : Listener {
    @EventHandler
    fun onPlayerClickLandSign(event: PlayerInteractEvent) {
        val player = event.player
        if (event.material == Material.SIGN) return
        val block = event.clickedBlock
        val sign = block.state as? Sign ?: return

        if (sign.getLine(0) == "[Build]") {
            player.sendMessage("クリック！！")
        }
    }
}