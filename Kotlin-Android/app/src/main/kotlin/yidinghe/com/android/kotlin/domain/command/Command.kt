package yidinghe.com.android.kotlin.domain.command

/**
 * Created by yiding on 10/31/2016.
 */

interface Command<T> {
    fun execute(): T
}