package com.videoplayer.domain.extension

import kotlin.coroutines.cancellation.CancellationException

suspend fun <T> safeCall(block: suspend () -> T): Result<T> {
    return try {
        Result.success(block())
    } catch (cancellationException: CancellationException) {
        throw cancellationException
    } catch (exception: Throwable) {
        Result.failure(exception)
    }
}
