package data.savetype.sql

import data.DataSolver
import data.savetype.DataSaveType
import org.bukkit.entity.Player
import java.util.*

/**
 * Created by karayuu on 2018/07/22
 */
object SQLDataSaveType : DataSaveType {
    override fun onPlayerJoin(player: Player) {
        val uuid = player.uniqueId

    }

    override fun onPlayerLeft(player: Player) {

    }

    override fun save(dataMap: Map<UUID, DataSolver>) {

    }

    override fun load(): Map<UUID, DataSolver> {

    }

    override fun create() {

    }
}

private fun connect() {
    //val conn = Connection()
}
