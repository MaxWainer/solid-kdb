package maxwainer.kdb.type

import maxwainer.kdb.struct.cell.CellType

object Str : CellType<String> {
    override fun from(str: String) = str

    override fun to(t: String) = t
}