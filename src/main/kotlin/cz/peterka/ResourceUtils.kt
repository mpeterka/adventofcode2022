package cz.peterka

object ResourceUtils {
    fun readResource(path: String): String =
        ResourceUtils::class.java.getResource(path)?.readText()
            ?: throw IllegalArgumentException("Path $path was not found")
}