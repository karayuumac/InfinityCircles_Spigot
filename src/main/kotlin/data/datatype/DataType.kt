package data.datatype

import data.serialize.AbstractDataSerializer

enum class DataType(val SQLTypeName: String?) {
    Nothing(null),
    TEST(null),
    INT("int"),

    ;

    open fun <E : AbstractDataSerializer> getSerializer() : E? = null
}
