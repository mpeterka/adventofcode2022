package cz.peterka.adventofcode2022.day06

class TuningTrouble(private val input: String) {
    companion object {
        const val MARKER_SIZE_PART_1 = 4
        const val MARKER_SIZE_PART_2 = 14
    }

    fun marker1(): Int = marker(MARKER_SIZE_PART_1)
    fun marker2(): Int = marker(MARKER_SIZE_PART_2)

    private fun marker(markerSize: Int): Int {
        val chars = input.toCharArray().toList()
        for (i in chars.indices) {
            println("Index: $i")
            val buffer = chars.subList(i, i + markerSize)
            println("Checking $buffer")
            if (buffer.size == markerSize && buffer.isSame()) {
                return i + markerSize
            }
        }
        error("Marker not found in $input")
    }

    private fun List<Char>.isSame(): Boolean {
        println(toSet().toString() + " == " + this + " --> (" + (toSet().size == size) + ")")
        return toSet().size == size
    }
}