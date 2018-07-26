package data.savetype

import data.DataSolver
import org.bukkit.entity.Player
import java.util.*

/**
 * Created by karayuu on 2018/07/22
 */
interface DataSaveType {
    fun save(dataMap: Map<UUID, DataSolver>)
    fun load() : Map<UUID, DataSolver>
    fun onPlayerJoin(player: Player)
    fun onPlayerLeft(player: Player)
    fun create()
}
