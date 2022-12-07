package cz.peterka.adventofcode2022.day05

import cz.peterka.ResourceUtils
import org.junit.Test
import kotlin.test.assertEquals

class SupplyStackTest {
    @Test
    fun example() {
        val supplyStack = SupplyStack(ResourceUtils.readResource("/2022/day05/example.txt"))
        supplyStack.run()
        assertEquals("CMZ", supplyStack.message())
    }

    @Test
    fun example2() {
        val supplyStack = SupplyStack(ResourceUtils.readResource("/2022/day05/example.txt"))
        supplyStack.run9001()
        assertEquals("MCD", supplyStack.message())
    }

    @Test
    fun puzzle() {
        val supplyStack = SupplyStack(ResourceUtils.readResource("/2022/day05/puzzle.txt"))
        supplyStack.run()
        assertEquals("QNNTGTPFN", supplyStack.message())
    }

    @Test
    fun puzzle9001() {
        val supplyStack = SupplyStack(ResourceUtils.readResource("/2022/day05/puzzle.txt"))
        supplyStack.run9001()
        assertEquals("GGNPJBTTR", supplyStack.message())
    }
}