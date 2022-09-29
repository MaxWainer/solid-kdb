package maxwainer.kdb.type

import maxwainer.kdb.struct.cell.CellType

object Bool : CellType<Boolean> {
    override fun from(str: String) = str.toBooleanStrict()

    override fun to(t: Boolean) = t.toString()
}