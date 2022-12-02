package cz.peterka.adventofcode2022.day01

class CalorieCounting(
    private val list: String,
) {
    fun mostCarryingElfCalories(): Int = elves().maxOf { it.sum }

    fun topElves(count: Int = 3): Int =
        elves()
            .sortedByDescending { it.sum }
            .subList(0, count)
            .sumOf { it.sum }

    private fun elves(): MutableList<Elf> {
        val elves = mutableListOf<Elf>()
        var elf = Elf()
        for (item in list.lines()) {
            if (item.isEmpty()) {
                elves.add(elf)
                elf = Elf()
            } else {
                elf.add(item)
            }
        }
        return elves
    }

    class Elf(
        private val items: MutableList<String> = mutableListOf(),
    ) {
        val sum: Int
            get() = items.sumOf { it.toInt() }

        fun add(item: String) {
            items.add(item)
        }
    }
}