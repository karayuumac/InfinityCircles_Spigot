package data.savetype

import data.savetype.sql.SQLDataSaveType

/**
 * Created by karayuu on 2018/07/22
 */
enum class DataSaveTypes(val type: DataSaveType) {
    SQL(SQLDataSaveType);
}
