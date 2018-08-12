package data

import java.util.*

/**
 * @author karayuu
 */
object DataController {
    val dataMap = mutableMapOf<UUID, DataStore>()
    /** This variable holds the data key that everyone has. */
    val keyList = mutableListOf<Key<*>>()
    //val saveType = DataSaveTypes.SQL.type
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
