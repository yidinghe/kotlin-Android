package yidinghe.com.android.kotlin.util

import android.util.Log

/**
 * Created by yidinghe on 11/4/16.
 */

class ListOperations {

    val list = listOf<Int>(1, 2, 3, 4, 5, 6)

    private fun aggregateOperations() {

        list.any { it % 2 == 0 }
        list.any { it > 10 }

        list.all { it < 10 }
        list.all { it % 2 == 0 }

        list.count { it % 2 == 0 }

        list.fold(4) { total, next -> total + next }
        list.foldRight(4) { total, next -> total + next }

        list.forEach { println(it) }
        list.forEachIndexed { index, value -> println("position : $index, + value: $value") }

        list.max()
        list.maxBy { -it }
        list.min()
        list.minBy { -it }

        list.none { it % 7 == 0 }

        list.reduce { total, next -> total + next }
        list.reduceRight { total, next -> total + next }

        list.sumBy { it % 2 }

    }

    private fun filterOperations() {

        listOf(5, 6).drop(4)
        listOf(3, 4, 5, 6).dropLast(2)
        listOf(3, 4, 5, 6).dropWhile { it < 3 }
        listOf(1, 2, 3, 4).dropLastWhile { it > 4 }

        listOf(2, 4, 6).filter { it % 2 == 0 }
        listOf(1, 3, 5).filterNot { it % 2 == 0 }
        listOf(1, 2, 3, 5).filterNotNull()

        list.slice(listOf(1, 3, 5))

        list.take(2)
        list.takeLast(2)
        list.takeWhile { it < 3 }

    }

    private fun mappingOperations() {
        list.flatMap { listOf(it, it + 1) }

        list.groupBy { if (it % 2 == 0) "even" else "odd" }

        list.map { it * 2 }
        list.mapIndexed { index, it -> index * it }
        list.mapNotNull { it * 2 }

    }

    private fun elementsOperations() {

        list.contains(2)

        list.elementAt(2)
        list.elementAtOrElse(10, { 2 * it })
        list.elementAtOrNull(10)

        list.first { it % 2 == 0 }
        list.firstOrNull { it % 2 == 0 }

        list.indexOf(4)
        list.indexOfFirst { it % 2 == 0 }
        list.indexOfLast { it % 2 == 0 }
        list.last { it % 2 == 0 }
        list.lastIndexOf(5)
        list.lastOrNull { it % 7 == 0 }

        list.single { it % 5 == 0 }
        list.singleOrNull { it % 7 == 0 }

    }

    private fun generationOperations() {

        list.partition { it % 2 == 0 }

        list + listOf(7, 8)

        list.zip(listOf(7, 8))

        listOf(5 to 7, 6 to 8).unzip()
    }

    private fun orderingOperations() {

        val unsortedList = listOf(3, 2, 7, 5)

        unsortedList.reversed()

        unsortedList.sorted()
        unsortedList.sortedBy { it % 3 }

        unsortedList.sortedDescending()
        unsortedList.sortedByDescending { it % 3 }
    }

}

