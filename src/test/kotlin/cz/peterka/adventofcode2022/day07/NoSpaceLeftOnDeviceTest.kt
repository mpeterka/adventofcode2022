package cz.peterka.adventofcode2022.day07

import cz.peterka.ResourceUtils.readResource
import org.junit.Test

internal class NoSpaceLeftOnDeviceTest {

    @Test
    fun example() {
        val noSpaceLeftOnDevice = NoSpaceLeftOnDevice(readResource("/2022/day07/example.txt"))

        val tree = noSpaceLeftOnDevice.makeTree()
        tree.printTree(0)
    }

    @Test
    fun puzzle() {
        val noSpaceLeftOnDevice = NoSpaceLeftOnDevice(readResource("/2022/day07/puzzle.txt"))

        val tree = noSpaceLeftOnDevice.makeTree()
        tree.printTree(0)
    }
}