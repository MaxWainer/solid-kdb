package maxwainer.kdb.commands

import maxwainer.kdb.ExecutionContext
import maxwainer.kdb.command.Command

object EchoCommand : Command {
    override fun execute(ctx: ExecutionContext, args: List<String>) {
        println(args.joinToString(" "))
    }
}