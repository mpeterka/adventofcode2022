package cz.peterka.adventofcode2022.day08

import cz.peterka.ResourceUtils.readResource
import org.junit.Test
import kotlin.test.assertEquals

internal class TreeHouseTest {

    @Test
    fun example() {
        val treeHouse = TreeHouse(readResource("/2022/day08/example.txt"))
        assertEquals(21, treeHouse.visible())
        assertEquals(8, treeHouse.scenic())
    }

    @Test
    fun puzzle() {
        val treeHouse = TreeHouse(readResource("/2022/day08/puzzle.txt"))
        assertEquals(1854, treeHouse.visible())
//        assertEquals(8, treeHouse.scenic())
    }
}