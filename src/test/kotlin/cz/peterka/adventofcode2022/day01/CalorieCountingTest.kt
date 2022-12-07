package cz.peterka.adventofcode2022.day01

import cz.peterka.ResourceUtils
import cz.peterka.ResourceUtils.readResource
import org.junit.Test
import kotlin.test.assertEquals


internal class CalorieCountingTest {

    @Test
    fun example1() {
        val cc = CalorieCounting(readResource("/2022/day01/example1.txt"))
        assertEquals(24_000, cc.mostCarryingElfCalories())
        assertEquals(41_000, cc.topElves())
    }

    @Test
    fun puzzle() {
        val cc = CalorieCounting(readResource("/2022/day01/puzzle.txt"))
        assertEquals(70_509, cc.mostCarryingElfCalories())
        assertEquals(20_8567, cc.topElves())
    }
}