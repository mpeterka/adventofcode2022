package cz.peterka.adventofcode2022.day02

import cz.peterka.ResourceUtils.readFile
import org.junit.Test
import kotlin.test.assertEquals

internal class RockPaperScissorsTest {
    @Test
    fun example1() {
        val rps = RockPaperScissors(readFile("/2022/02/example1.txt"))
        assertEquals(15, rps.score())
        assertEquals(12, rps.part2())
    }

    @Test
    fun puzzle() {
        val rps = RockPaperScissors(readFile("/2022/02/puzzle.txt"))
        assertEquals(12679, rps.score())
        assertEquals(14470, rps.part2())
    }
}