package maxwainer.kdb.command

import maxwainer.kdb.ExecutionContext

interface Command {

    fun execute(ctx: ExecutionContext, args: List<String>)

}