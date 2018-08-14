package data.extension

import data.*
import data.exception.NoDataContainerFoundException
import data.exception.NoDataKeyFoundException
import data.exception.NoDataSolverFoundException
import data.exception.NoDataStackFoundException
import org.bukkit.entity.Player
import java.util.*

/**
 * @author karayuu
 */
fun <E> Player.offer(dataKey: Key<E>, data: E) {
    val uuid = player.uniqueId
    uuid.offer(dataKey, data)
}

fun <E> Player.getData(dataKey: Key<E>) : E {
    val uuid = player.uniqueId
    return uuid.getData(dataKey)
}

private fun <E> Player.getDataContainer(dataKey: Key<E>) : DataContainer<E> {
    val serverDataMap = DataController.dataMap
    val uuid = this.uniqueId
    val store = serverDataMap[uuid] ?:
    throw NoDataStackFoundException("No DataStore can be found in this server.[UUID:$uuid, PlayerName:${this.name}]")
    val solver = store.getSolver(dataKey) ?:
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
    val store = serverDataMap[uuid] ?:
    throw NoDataStackFoundException("No DataStore can be found in this server.[UUID:$uuid]")
    val solver = store.getSolver(dataKey) ?:
    throw NoDataSolverFoundException("No DataSolver can be found in this server.[UUID:$uuid, DataType:${dataKey.dataType.name}")
    val container = solver.dataMap[dataKey] ?:
    throw NoDataKeyFoundException("No DataKey can be found in this server.[UUID:$uuid, DataKey:$dataKey]")

    @Suppress("UNCHECKED_CAST")
    val eContainer = container as DataContainer<E>?

    val c =  eContainer ?:
    throw NoDataContainerFoundException("No DataContainer can be found in this server.[UUID:$uuid]")

    return c
}

private fun DataStore.getSolver(key: Key<*>): DataSolver? {
    for (solver in this.dataSolvers) {
        if (solver.dataMap.containsKey(key)) {
            return solver
        }
    }
    return null
}

fun <E> UUID.offer(dataKey: Key<E>, data: E) {
    val c = this.getDataContainer(dataKey)
    c.data = data
}

fun <E> UUID.getData(dataKey: Key<E>) : E {
    val container = this.getDataContainer(dataKey)
    return container.data
}

fun <E> UUID.create(dataKey: Key<E>) {
    this.offer(dataKey, dataKey.dataContainer.data)
    DataController.keyList.add(dataKey)
}

fun <E> Player.create(dataKey: Key<E>) {
    val uuid = this.uniqueId
    uuid.create(dataKey)
}
