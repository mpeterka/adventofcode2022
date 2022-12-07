package cz.peterka.adventofcode2022.day04

class CampCleanup(
    private val data: String,
) {

    private fun parse(): List<Sections> {
        return data.lines().map {
            val pair = it.split(",")
            val first = pair[0].split("-")
            val second = pair[1].split("-")
            Sections(
                IntRange(first[0].toInt(), first[1].toInt()),
                IntRange(second[0].toInt(), second[1].toInt())
            )
        }
    }

    fun fullyOverlapCount(): Int = parse().count {
        it.fullyOverlap
    }

    fun overlapCount(): Int = parse().count {
        it.overlap
    }

    class Sections(
        private val first: IntRange,
        private val second: IntRange,
    ) {

        private val firstExpanded by lazy {
            first.expand()
        }

        private val secondExpanded by lazy {
            second.expand()
        }

        val fullyOverlap: Boolean
            get() = firstExpanded.containsAll(secondExpanded) ||
                    secondExpanded.containsAll(firstExpanded)
        val overlap: Boolean
            get() = firstExpanded.intersect(secondExpanded.toSet()).isNotEmpty()

        private fun IntRange.expand(): List<Int> = map { it }
    }
}