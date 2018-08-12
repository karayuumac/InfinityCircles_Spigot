package data

import data.datatype.DataType
import data.extension.getData
import data.extension.offer
import java.util.*

/**
 * @author karayuu
 */

fun main(args: Array<String>) {
    val key = createKey(1, DataType.TEST)
    val uuid = UUID.randomUUID()
    val solver = DataSolver().also {
        it.dataMap[key] = key.dataContainer
    }
    val stack = DataStore().also {
        it.dataSolvers[key.dataType] = solver
    }
    DataController.dataMap[uuid] = stack

    println(uuid.getData(key))

    uuid.offer(key, 5)
    println(uuid.getData(key))
}