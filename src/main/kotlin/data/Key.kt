package data

/**
 * Created by karayuu on 2018/07/11
 */
class Key<E>(val dataContainer: DataContainer<E>) {
    override fun toString(): String {
        return "[Name:${this.javaClass.name}]"
    }
}

fun <E> createKey(default: E) = Key(DataContainer(default))
