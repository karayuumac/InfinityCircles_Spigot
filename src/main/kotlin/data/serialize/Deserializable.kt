package data.serialize

/**
 * @author karayuu
 */
interface Deserializable {
    fun <E, V> deserialize(input: V) : E
}