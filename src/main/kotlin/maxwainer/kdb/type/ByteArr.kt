package maxwainer.kdb.type

import maxwainer.kdb.struct.cell.CellType

object ByteArr : CellType<ByteArray> {
    override fun from(str: String) = str.toByteArray(Charsets.UTF_8)

    override fun to(t: ByteArray) = t.toString(Charsets.UTF_8)
}