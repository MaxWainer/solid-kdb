package maxwainer.kdb.util

class TResult<T> private constructor(val exception: Throwable? = null, val obj: T? = null) {
    val isFail = exception != null
    val isSuccess = obj != null
    val isBi = isFail && isSuccess

    companion object {
        fun <V> fail(exception: Throwable) = TResult<V>(exception, null)
        fun <V> success(obj: V) = TResult(null, obj)
        fun <V> bi(exception: Throwable, obj: V) = TResult(null, obj)
    }
}