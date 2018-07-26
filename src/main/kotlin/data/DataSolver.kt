package data

import org.bukkit.entity.Player
import java.util.*

import data.exception.*

/**
 * Created by karayuu on 2018/07/11
 */
class DataSolver {
    val dataMap = mutableMapOf<Key<*>, DataContainer<*>>()
}

fun <E> Player.offer(dataKey: Key<E>, data: E) {
    val container = this.getDataContainer(dataKey)
    container.data = data
}

fun <E> Player.getData(dataKey: Key<E>) : E {
    val container = this.getDataContainer(dataKey)
    return container.data
}

private fun <E> Player.getDataContainer(dataKey: Key<E>) : DataContainer<E> {
    val serverDataMap = DataController.dataMap
    val uuid = this.uniqueId
    val stack = serverDataMap[uuid] ?:
            throw NoDataStackFoundException("No DataStack can be found in this server.[UUID:$uuid, PlayerName:${this.name}]")
    val solver = stack.dataSolvers[dataKey.dataType] ?:
            throw NoDataSolverFoundException("No DataSolver can be found in this server.[UUID:$uuid, DataType:${dataKey.dataType.name}")
    val container = solver.dataMap[dataKey] ?:
            throw NoDataKeyFoundException("No DataKey can be found in this server.[UUID:$uuid, PlayerName:${this.name}, DataKey:$dataKey]")

    @Suppress("UNCHECKED_CAST")
    val eContainer = container as DataContainer<E>?

    return eContainer ?:
            throw NoDataContainerFoundException("No DataContainer can be found in this server.[UUID:${this.uniqueId}, PlayerName:${this.name}]")
}

private fun <E> UUID.getDataContainer(dataKey: Key<E>) : DataContainer<E> {
    val serverDataMap = DataController.dataMap
    val uuid = this
    val stack = serverDataMap[uuid] ?:
            throw NoDataStackFoundException("No DataStack can be found in this server.[UUID:$uuid]")
    val solver = stack.dataSolvers[dataKey.dataType] ?:
        throw NoDataSolverFoundException("No DataSolver can be found in this server.[UUID:$uuid, DataType:${dataKey.dataType.name}")
    val container = solver.dataMap[dataKey] ?:
            throw NoDataKeyFoundException("No DataKey can be found in this server.[UUID:$uuid, DataKey:$dataKey]")

    @Suppress("UNCHECKED_CAST")
    val eContainer = container as DataContainer<E>?

    val c =  eContainer ?:
            throw NoDataContainerFoundException("No DataContainer can be found in this server.[UUID:$uuid]")

    return c
}

fun <E> UUID.offer(dataKey: Key<E>, data: E) {
    val c = this.getDataContainer(dataKey)
    c.data = data
}

fun <E> UUID.getData(dataKey: Key<E>) : E {
    val container = this.getDataContainer(dataKey)
    return container.data
}
