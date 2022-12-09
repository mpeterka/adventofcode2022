package cz.peterka.adventofcode2022.day07

// TODO
class NoSpaceLeftOnDevice(private val input: String) {

    fun makeTree(): Dir {
        val root = Dir("/", null)
        var current: Dir = root
        input.lines().forEach {
//            println("Line: $it")
            if (it.startsWith("$ cd ..")) {
                current = current.parent ?: error("Major Tom?")
            } else if (it.startsWith("$ cd")) {
                val dir = Dir(it.substringAfter("$ cd "), current)
                current.subNodes.add(dir)
                current = dir
            } else if (it.startsWith("dir ")) {
                current.subNodes.add(Dir(it.substringAfter("dir "), current))
            } else if (it.startsWith("$ ls")) {
                // noop
            } else {
                // file
                val parts = it.split(" ")
                current.subNodes.add(File(parts[1], parts[0].toInt()))
            }
        }
        println(root)
        return root
    }


    abstract class Node(val name: String, val subNodes: MutableList<Node> = mutableListOf()) {
        fun printTree(indent: Int = 0) {
            println(" ".repeat(indent) + this)
            subNodes.forEach {
                it.printTree(indent.inc())
            }
        }

        abstract fun size(): Int
    }

    class File(name: String, val size: Int) : Node(name) {
        override fun toString(): String = " - $name ($size)"

        override fun size(): Int = size
    }

    class Dir(name: String, val parent: Dir?) : Node(name) {
        override fun toString(): String = "/$name (total ${size()})"

        override fun size(): Int = subNodes.sumOf {
            it.size()
        }
    }
}