package maxwainer.kdb.type

import maxwainer.kdb.struct.cell.CellType

object Integer : CellType<Int> {
    override fun from(str: String): Int {
        TODO("Not yet implemented")
    }

    override fun to(t: Int): String {
        TODO("Not yet implemented")
    }
}