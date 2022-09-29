package maxwainer.kdb.spec.table

import maxwainer.kdb.ExecutionContext
import maxwainer.kdb.exception.MalformedDatabaseException
import maxwainer.kdb.spec.SpecReader
import maxwainer.kdb.struct.cell.CellType
import maxwainer.kdb.struct.spec.CellSpec
import maxwainer.kdb.struct.spec.TableSpec
import java.nio.file.Path
import java.util.StringTokenizer
import kotlin.io.path.isDirectory
import kotlin.io.path.name
import kotlin.io.path.readText

class TableSpecReader(private val ctx: ExecutionContext) : SpecReader<Path, TableSpec> {
    override fun readSpec(input: Path): TableSpec {
        if (!input.isDirectory()) throw MalformedDatabaseException("Input $input, is not directory!")

        val name = input.name
        val spec = input.resolve(".spec")

        if (spec.isDirectory()) throw MalformedDatabaseException("Spec file cannot be directory!")

        val tokenizer = StringTokenizer(spec.readText(), ",", false)
        val cells = mutableMapOf<String, CellSpec>()

        while (tokenizer.hasMoreTokens()) {
            val cellTokenizer = StringTokenizer(tokenizer.nextToken(), "|")

            var cellName: String? = null
            var nullable = true
            var type: CellType<*>? = null

            for ((index, ttoken) in cellTokenizer.asSequence().withIndex()) {
                val token = ttoken.toString()

                when (index) {
                    0 -> cellName = token
                    1 -> type = ctx.cellTypesRegistry.findType(token) ?: throw MalformedDatabaseException("Error while processing " +
                            "spec! " +
                            "(Cell: $token, Index: $index, Required: cellType)")
                    2 -> nullable = token.toBooleanStrictOrNull() ?: throw MalformedDatabaseException("Error while processing spec! " +
                            "(Cell: $token, Index: $index, Required: boolean)")
                }
            }

            if (cellName == null) throw MalformedDatabaseException("WTF?! Name is null!")
            if (type == null) throw MalformedDatabaseException("WTF?! Type is null!")

            cells[cellName] = CellSpec(type, nullable)
        }

        return TableSpec(name, cells)
    }
}