package maxwainer.kdb.struct.spec

import maxwainer.kdb.struct.cell.CellType

class CellSpec(val type: CellType<*>, val nullable: Boolean = true)