package data

import org.bukkit.entity.Player

/**
 * Created by karayuu on 2018/07/11
 */
class Key<E>(val dataContainer: DataContainer<E>) {
    override fun toString(): String {
        return "[Name:${this.javaClass.name}]"
    }
}
