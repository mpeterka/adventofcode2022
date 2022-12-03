package cz.peterka.adventofcode2022.day03

import cz.peterka.ResourceUtils.readFile
import org.junit.Test
import kotlin.test.assertEquals

internal class RucksacksTest {
    @Test
    fun example() {
        val rucksacks = Rucksacks(readFile("/2022/day03/example.txt"))
        assertEquals(157, rucksacks.priority())
        assertEquals(70, rucksacks.groupBadgePriority())
    }

    @Test
    fun puzzle() {
        val rucksacks = Rucksacks(readFile("/2022/day03/puzzle.txt"))
        assertEquals(7674, rucksacks.priority())
        assertEquals(2805, rucksacks.groupBadgePriority())
    }
}