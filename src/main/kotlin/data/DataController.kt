package data

import org.bukkit.entity.Player
import java.util.*

/**
 * @author karayuu
 */
object DataController {
    val dataMap = mutableMapOf<UUID, DataSolver>()
/*
    fun onPlayerJoin(player: Player) {
        val data = if (isFirstJoin(player)) {
            player.create()
        } else {
            player.load()
        }
        dataMap[player.uniqueId] = data
    }

    fun onPlayerLeft(player: Player) {
        player.save()
        dataMap.remove(player.uniqueId)
    }

    fun saveToSQL() {
        dataMap.forEach { _, data ->
            data.save()
        }
    }
*/
}