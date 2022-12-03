package cz.peterka.adventofcode2022.day03


val priorities = ('a'..'z').toList().plus('A'..'Z')
        .mapIndexed { index, c ->
            c to index + 1
        }.toMap()


class Rucksacks(
        private val input: String,
) {
    fun priority(): Int = rucksacks()
            .sumOf {
                it.priority()
            }

    private fun rucksacks() = input
            .lines()
            .filter {
                it.isNotBlank()
            }
            .map { Rucksack(it) }

    private fun groups(): List<List<Rucksack>> = rucksacks().chunked(3)

    fun groupBadgePriority(): Int = groups().sumOf {
        val badge = badge(it)
        priorities[badge]!!
    }

    private fun badge(rucksack: List<Rucksack>): Char {
        val items: List<List<Char>> = rucksack.map {
            it.items()
        }
        return items[0].filter {
            items[1].contains(it)
        }.first {
            items[2].contains(it)
        }
    }
}

class Rucksack(
        private val items: String,
) {

    private fun priority(item: Char): Int = priorities[item]!!

    fun priority(): Int = duplicates().sumOf {
        priority(it)
    }

    private fun duplicates(): Set<Char> {
        val compartments = items()
                .chunked(items.length / 2)
        val compartment1: List<Char> = compartments[0]
        val compartment2: List<Char> = compartments[1]
        return compartment1.toSet().intersect(compartment2.toSet())
    }

    fun items() = items
            .toCharArray()
            .toList()
}