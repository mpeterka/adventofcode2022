package cz.peterka.adventofcode2022.day02

import cz.peterka.ResourceUtils.readResource
import org.junit.Test
import kotlin.test.assertEquals

internal class RockPaperScissorsTest {
    @Test
    fun example1() {
        val rps = RockPaperScissors(readResource("/2022/day02/example1.txt"))
        assertEquals(15, rps.score())
        assertEquals(12, rps.part2())
    }

    @Test
    fun puzzle() {
        val rps = RockPaperScissors(readResource("/2022/day02/puzzle.txt"))
        assertEquals(12679, rps.score())
        assertEquals(14470, rps.part2())
    }
}