package cz.peterka.adventofcode2022.day05

import java.util.Stack

class SupplyStack(
    private val input: String,
) {

    private val crates: MutableList<Crate> = mutableListOf()

    private val moves: List<Move> = parseMoves()

    init {
        parseCrates()
    }

    fun run() {
        moves.forEach {
            val from = getCrate(it.from)
            val to = getCrate(it.to)
            val load = from.load(it.count)
            println("Move: $it, current: $crates, load: $load")
            to.add(load)
            println("... then $crates")
            println()
        }
    }

    fun run9001() {
        moves.forEach {
            val from = getCrate(it.from)
            val to = getCrate(it.to)
            val load = from.load9001(it.count)
            to.add9001(load)
        }
    }

    fun message(): String = crates.map {
        it.top()
    }.joinToString("")

    private fun getCrate(index: Int): Crate = crates[index - 1]

    private fun parseCrates() {
        val cratesCount = input.lines().first {
            it.contains("1")
        }.split(" ").last().trim().toInt()
        println("Crates: $cratesCount")
        repeat(cratesCount) {
            crates.add(Crate())
        }
        input
            .substringBefore("\n\n")
            .lines()
            .filter {
                !it.contains("1")
            }
            .map {
                it.padEnd(cratesCount * 4)
            }
            .forEach { line ->
                repeat(cratesCount) {
                    println("Parsing crate $it on $line")
                    crates[it].add(line.substring(0 + it * 4, 3 + it * 4))
                }
            }
    }

    private fun parseMoves(): List<Move> = input
        .substringAfter("\n\n")
        .lines()
        .map {
            val r = Regex("move (.*) from (.*) to (.*)")
            val found = r.findAll(it)
            val groups = found.first().groups
            Move(
                groups[1]!!.value.toInt(),
                groups[2]!!.value.toInt(),
                groups[3]!!.value.toInt()
            )
        }


    class Crate(
        val content: Stack<String> = Stack(),
    ) {

        fun add(supply: String) {
            val element = supply
                .replace("[", "")
                .replace("]", "")
            if (element.isNotBlank()) {
                content.add(element)
            }
        }


        fun add(supply: List<String>) = supply.forEach {
            content.add(0, it)
        }

        fun add9001(supply: List<String>) {
            println("Adding $supply to $content")
            content.addAll(0, supply)
            println("... then $content")
        }

        fun top(): String? = content.firstElement()

        fun load(count: Int): List<String> {
            println("load $count from $content")
            val result = mutableListOf<String>()
            repeat(count) {
                println("loading $it from $content: $result")
                result.add(content[0])
                content.removeAt(0)
                println("loaded $it from $content: $result")
            }
            return result
        }

        fun load9001(count: Int): List<String> {
            println("load $count from $content")
            val result = mutableListOf<String>()
            val load = content.subList(0, count)
            result.addAll(load)
            load.clear()
            println("loaded $result, leaving $content")
            return result
        }

        override fun toString(): String = content.toString()
    }

    data class Move(
        val count: Int,
        val from: Int,
        val to: Int,
    )
}