package data.serialize

/**
 * @author karayuu
 */
interface Serializable {
    fun <E, V> serialize(data: E) : V
}