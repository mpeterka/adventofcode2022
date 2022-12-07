package cz.peterka.adventofcode2022.day04

import cz.peterka.ResourceUtils.readResource
import org.junit.Test
import kotlin.test.assertEquals

class CampCleanupTest {
    @Test
    fun example() {
        val cleanup = CampCleanup(readResource("/2022/day04/example.txt"))
        assertEquals(
            2,
            cleanup.fullyOverlapCount()
        )
        assertEquals(
            4,
            cleanup.overlapCount()
        )
    }

    @Test
    fun puzzle() {
        val cleanup = CampCleanup(readResource("/2022/day04/puzzle.txt"))
        assertEquals(
            424,
            cleanup.fullyOverlapCount()
        )
        assertEquals(
            804,
            cleanup.overlapCount()
        )
    }
}