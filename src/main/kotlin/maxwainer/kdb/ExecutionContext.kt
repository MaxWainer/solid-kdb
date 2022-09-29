package maxwainer.kdb

import maxwainer.kdb.struct.Database
import maxwainer.kdb.struct.cell.CellTypeRegistry

class ExecutionContext {

    var database: Database? = null
    val cellTypesRegistry = CellTypeRegistry()
    val databasePool = mutableListOf<Database>()


}