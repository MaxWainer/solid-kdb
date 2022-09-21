package maxwainer.kdb.q

import maxwainer.kdb.ExecutionContext
import maxwainer.kdb.util.TResult
import java.lang.Exception

class Lexer(inputQuery: String, private val context: ExecutionContext) {

    private val rawData = inputQuery.split(" ")
    private var currentPos = 0
    private val tokenQueue = rawData.map {

    }

    fun execute(): TResult<ResultCode> {
        TODO()
    }

    fun popToken() = tokenQueue.getOrNull(currentPos++)
        ?: throw NoSuchElementException("No any element at position: $currentPos")

    enum class ResultCode {
        ERROR, INVALID_QUERY, OK
    }

}