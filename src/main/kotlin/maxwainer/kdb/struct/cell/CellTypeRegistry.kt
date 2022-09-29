package maxwainer.kdb.struct.cell

class CellTypeRegistry {

    private val types = mutableMapOf<String, CellType<*>>()

    fun register(type: CellType<*>) {
        types[type::class.java.simpleName] = type
    }

    fun findType(name: String) = types[name]

    fun nameOf(cellType: CellType<*>) = cellType::class.java.simpleName

}