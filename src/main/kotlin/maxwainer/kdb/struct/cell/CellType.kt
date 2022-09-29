package maxwainer.kdb.struct.cell

interface CellType<T> {

    fun from(str: String): T

    fun to(t: T): String

}