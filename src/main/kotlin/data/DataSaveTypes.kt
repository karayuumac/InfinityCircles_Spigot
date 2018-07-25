package data

import data.saveType.DataSaveType
import data.saveType.SQLDataSaveType

/**
 * Created by karayuu on 2018/07/22
 */
enum class DataSaveTypes(val type: DataSaveType) {
    SQL(SQLDataSaveType);
}
