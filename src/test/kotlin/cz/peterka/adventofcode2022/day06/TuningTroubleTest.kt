package cz.peterka.adventofcode2022.day06

import cz.peterka.ResourceUtils
import org.junit.Test
import kotlin.test.assertEquals

internal class TuningTroubleTest {

    @Test
    fun example() {
        val tuningTrouble = TuningTrouble("mjqjpqmgbljsphdztnvjfqwrcgsmlb")
        assertEquals(7, tuningTrouble.marker1())
        assertEquals(19, tuningTrouble.marker2())
    }

    @Test
    fun example1() {
        val tuningTrouble = TuningTrouble("bvwbjplbgvbhsrlpgdmjqwftvncz")
        assertEquals(5, tuningTrouble.marker1())
        assertEquals(23, tuningTrouble.marker2())
    }

    @Test
    fun example2() {
        val tuningTrouble = TuningTrouble("nppdvjthqldpwncqszvftbrmjlhg")
        assertEquals(6, tuningTrouble.marker1())
        assertEquals(23, tuningTrouble.marker2())
    }

    @Test
    fun example3() {
        val tuningTrouble = TuningTrouble("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg")
        assertEquals(10, tuningTrouble.marker1())
        assertEquals(29, tuningTrouble.marker2())
    }

    @Test
    fun example4() {
        val tuningTrouble = TuningTrouble("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw")
        assertEquals(11, tuningTrouble.marker1())
        assertEquals(26, tuningTrouble.marker2())
    }

    @Test
    fun puzzle() {
        val tuningTrouble = TuningTrouble(ResourceUtils.readResource("/2022/day06/puzzle.txt"))
        assertEquals(1794, tuningTrouble.marker1())
        assertEquals(2851, tuningTrouble.marker2())

    }
}