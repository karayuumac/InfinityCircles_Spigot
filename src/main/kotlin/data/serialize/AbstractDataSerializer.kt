package data.serialize

/**
 * @author karayuu
 */

abstract class AbstractDataSerializer : Serializer {
    //abstract val serializeType: SerializeType

    abstract fun create() : String
}
