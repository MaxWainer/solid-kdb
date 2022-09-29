package maxwainer.kdb.spec.table

import maxwainer.kdb.ExecutionContext
import maxwainer.kdb.spec.SpecLoader
import maxwainer.kdb.struct.spec.TableSpec
import java.nio.file.OpenOption
import java.nio.file.Path
import java.nio.file.StandardOpenOption

import kotlin.io.path.createFile
import kotlin.io.path.notExists
import kotlin.io.path.writeText

class TableSpecLoader(private val ctx: ExecutionContext) : SpecLoader<Path, TableSpec> {
    override fun loadSpec(to: Path, spec: TableSpec) {
        val dir = to.resolve(spec.name)
        val dotSpec = dir.resolve(".spec")

        if (dotSpec.notExists()) {
            dotSpec.createFile()
        }

        val rawSpec = spec.cells.entries.joinToString(",") { (k, v) -> "$k|${ctx.cellTypesRegistry.nameOf(v.type)}|${v.nullable}" }

        dotSpec.writeText(rawSpec, options = arrayOf(StandardOpenOption.TRUNCATE_EXISTING))
    }
}