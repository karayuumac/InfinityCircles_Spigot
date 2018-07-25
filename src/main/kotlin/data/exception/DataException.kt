package data.exception

/**
 * Created by karayuu on 2018/07/22
 */

class NoDataContainerFoundException(override val message: String?) : Exception()

class NoDataFoundException(override val message: String?) : Exception()

class NoDataKeyFoundException(override val message: String?) : Exception()
