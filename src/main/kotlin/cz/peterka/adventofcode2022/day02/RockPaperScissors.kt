package cz.peterka.adventofcode2022.day02

class RockPaperScissors(
    private val guide: String,
) {
    fun score(): Int = guide.lines().map {
        val match = it.split(" ")
        Pair(
            Shape.find(match[1]),
            Shape.find(match[0])
        )
    }.sumOf {
        it.first.totalScore(it.second)
    }

    fun part2(): Int = guide.lines().sumOf { line ->
        val match = line.split(" ")

        val opponent = Shape.find(match[0])
        val my = when (Shape.find(match[1])) {
            Shape.ROCK -> Shape.values().maxBy {
                opponent.matchScore(it)
            }

            Shape.PAPER -> opponent
            Shape.SCISSORS -> Shape.values().minBy {
                opponent.matchScore(it)
            }
        }
        my.totalScore(opponent)
    }
}

const val SCORE_WON = 6
const val SCORE_DRAW = 3
const val SCORE_LOST = 0

enum class Shape(
    private val opponentSymbol: Char,
    private val yourSymbol: Char,
    private val shapeScore: Int,
) {
    ROCK('A', 'X', 1) {
        override fun matchScore(opponent: Shape): Int =
            when (opponent) {
                ROCK -> SCORE_DRAW
                PAPER -> SCORE_LOST
                SCISSORS -> SCORE_WON
            }
    },
    PAPER('B', 'Y', 2) {
        override fun matchScore(opponent: Shape): Int =
            when (opponent) {
                ROCK -> SCORE_WON
                PAPER -> SCORE_DRAW
                SCISSORS -> SCORE_LOST
            }

    },
    SCISSORS('C', 'Z', 3) {
        override fun matchScore(opponent: Shape): Int =
            when (opponent) {
                ROCK -> SCORE_LOST
                PAPER -> SCORE_WON
                SCISSORS -> SCORE_DRAW
            }
    },
    ;

    abstract fun matchScore(opponent: Shape): Int

    fun totalScore(opponent: Shape): Int = matchScore(opponent) + shapeScore

    companion object {
        fun find(symbol: String): Shape = values().first {
            it.yourSymbol == symbol[0] || it.opponentSymbol == symbol[0]
        }
    }
}