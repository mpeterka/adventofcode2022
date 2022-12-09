package cz.peterka.adventofcode2022.day08

class TreeHouse(input: String) {

    private val matrix: Matrix = Matrix(input.lines().mapIndexed { y, line ->
        line.toCharArray().mapIndexed { x, height ->
            Tree(height.toString().toInt(), x, y)
        }
    })


    fun visible(): Int {
        println(matrix)
        left()
        right()
        bottom()
        top()
        println(matrix)
        return matrix.visible()
    }

    fun scenic(): Int {
        println(matrix.toStringScenic())
        return matrix.all().maxOf {
            matrix.scenic(it)
        }
    }

    // 💩
    private fun left() {
        repeat(matrix.size()) {
            val row = matrix.row(it)
            var max = -1
            row.forEach { tree ->
                if (tree.height > max) {
                    max = tree.height
                    tree.visible = true
                } else {
                    return@forEach
                }
            }
        }
    }

    private fun right() {
        repeat(matrix.size()) {
            val row = matrix.row(it)
            var max = -1
            row.forEachIndexed { index, _ ->
                val tree = row[row.size - (index + 1)]
                if (tree.height > max) {
                    max = tree.height
                    tree.visible = true
                } else {
                    return@forEachIndexed
                }
            }
        }
    }

    private fun bottom() {
        repeat(matrix.size()) {
            val column = matrix.column(it)
            var max = -1
            column.forEachIndexed { index, _ ->
                val tree = column[column.size - (index + 1)]
                if (tree.height > max) {
                    max = tree.height
                    tree.visible = true
                } else {
                    return@forEachIndexed
                }
            }
        }
    }

    private fun top() {
        repeat(matrix.size()) {
            val column = matrix.column(it)
            var max = -1
            column.forEachIndexed { index, _ ->
                val tree = column[index]
                if (tree.height > max) {
                    max = tree.height
                    tree.visible = true
                } else {
                    return@forEachIndexed
                }
            }
        }
    }

    data class Tree(
        val height: Int,
        val x: Int,
        val y: Int,
    ) {
        var visible: Boolean = false
    }

    class Matrix(private val trees: List<List<Tree>>) {
        fun row(rowId: Int): List<Tree> = trees[rowId]
        fun column(columnId: Int): List<Tree> = trees.map {
            it[columnId]
        }

        fun size() = trees.size

        override fun toString(): String = buildString {
            trees.forEach { row ->
                row.forEach { tree ->
                    if (tree.visible) {
                        append("[").append(tree.height).append("]")
                    } else {
                        append(" ").append(tree.height).append(" ")
                    }
                }
                append("\n")
            }
        }

        fun toStringScenic(): String = buildString {
            trees.forEach { row ->
                row.forEach { tree ->
                    append(tree.height).append(":").append(scenic(tree)).append("\t")
                }
                append("\n")
            }
        }

        fun visible(): Int {
            var visible = 0
            trees.forEach {
                it.forEach { tree ->
                    if (tree.visible) {
                        visible++
                    }
                }
            }
            return visible
        }

        fun scenic(tree: Tree): Int { // TODO
            var left = if (tree.x != size()) 1 else 0
            row(tree.y).subList(0, tree.x + 1).forEachIndexed { index, _ ->
                val it = row(tree.y)[tree.x - index]
                if (it != tree && it.height > tree.height) {
                    left++
                }
            }
            var right = if (tree.x != size()) 1 else 0
            row(tree.y).subList(tree.x, size()).forEach {
                if (it != tree && it.height > tree.height) {
                    right++
                }
            }
            var up = if (tree.y != 0) 1 else 0
            column(tree.x).subList(0, tree.y + 1).forEachIndexed { index, _ ->
                val it = column(tree.x)[tree.y - index]
                if (it != tree && it.height > tree.height) {
                    up++
                }
            }
            var down = if (tree.y != size()) 1 else 0
            println("Down from $tree:")
            column(tree.x).subList(tree.y, size()).forEach {
                println("  Checking scenic of $tree to $it")
                if (it != tree && it.height > tree.height) {
                    println("    nice")
                    down++
                }
            }

            println("$tree = $left * $right * $up * $down")
            return left.treeValue() * right.treeValue() * up.treeValue() * down.treeValue()
        }

        private fun Int.treeValue(): Int {
            return if (this == 0) {
                1
            } else {
                this - 1 // hack
            }
        }

        fun all(): List<Tree> = trees.flatten()
    }
}