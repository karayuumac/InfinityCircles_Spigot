package data

import java.util.*

/**
 * @author karayuu
 */

fun main(args: Array<String>) {
    val key = Key(DataContainer(1))
    val uuid = UUID.randomUUID()
    val solver = DataSolver(uuid).also {
        it.dataMap[key] = key.dataContainer
    }
    DataController.dataMap[uuid] = solver

    uuid.offer(key, 5)
    print(uuid.getData(key))
}