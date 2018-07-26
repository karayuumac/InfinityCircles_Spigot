package data.exception

/**
 * Created by karayuu on 2018/07/22
 */

class NoDataContainerFoundException(override val message: String?) : Exception()

class NoDataStackFoundException(override val message: String?) : Exception()

class NoDataKeyFoundException(override val message: String?) : Exception()

class NoDataSolverFoundException(override val message: String?) : Exception()