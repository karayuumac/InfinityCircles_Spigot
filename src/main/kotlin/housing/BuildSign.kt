package housing

import extension.fill
import extension.minus
import extension.plus
import extension.toTriple
import listener.PlayerInteractListener
import listener.component.ConditionalHandler
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.block.Sign

/**
 * @author karayuu
 */
object BuildSign {
    fun eventRegister() {
        val createHouseOnPlayerClickBuildSign = ConditionalHandler<PlayerInteractEvent>(
                { event -> isBuildingSign(event.clickedBlock) },
                { event -> createBuilding(event.player.location) }
        )
        PlayerInteractListener.behaviorList += createHouseOnPlayerClickBuildSign
    }

    private fun isBuildingSign(block: Block?): Boolean {
        if (block == null) return false
        if (block.type != Material.SIGN_POST) {
            return false
        }
        val sign = block.state as Sign
        if (sign.getLine(0) != "[Build]") {
            return false
        }
        Bukkit.getLogger().info("HH")
        return true
    }

    private fun createBuilding(playerLoc: Location) {
        val world = playerLoc.world
        val startLoc = playerLoc.toTriple() - Triple(5, 0, 5)
        val endLoc = playerLoc.toTriple() + Triple(5, 0, 5)

        world.fill(startLoc, endLoc, Material.DIAMOND_BLOCK)
    }
}