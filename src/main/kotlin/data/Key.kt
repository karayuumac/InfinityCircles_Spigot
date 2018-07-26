package data

import data.datatype.DataType

/**
 * Created by karayuu on 2018/07/11
 */
class Key<E>(val dataContainer: DataContainer<E>) {
    val dataType: DataType
        get() = dataContainer.dataType

    override fun toString(): String {
        return "[Name:${this.javaClass.name}]"
    }
}

fun <E> createKey(default: E, dataType: DataType) = Key(DataContainer(default, dataType))
