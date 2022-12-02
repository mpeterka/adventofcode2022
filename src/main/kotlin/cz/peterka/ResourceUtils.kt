package cz.peterka

object ResourceUtils {
    fun readFile(path: String): String =
        ResourceUtils::class.java.getResource(path)?.readText()
            ?: throw IllegalArgumentException("Path $path was not found")
}