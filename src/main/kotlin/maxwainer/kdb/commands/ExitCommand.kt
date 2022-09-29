package maxwainer.kdb.commands

import maxwainer.kdb.ExecutionContext
import maxwainer.kdb.command.Command
import kotlin.system.exitProcess

object ExitCommand : Command {
    override fun execute(ctx: ExecutionContext, args: List<String>) {
        println("Bye!")
        exitProcess(0)
    }
}