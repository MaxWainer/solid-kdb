package maxwainer.kdb.command

import maxwainer.kdb.ExecutionContext
import maxwainer.kdb.exception.CommandExecutionException

class CommandDispatcher(val context: ExecutionContext) {

    private val commands = mutableMapOf<String, Command>()

    fun registerCommand(name: String, command: Command) {
        commands[name] = command
    }

    fun tryDispatch(args: List<String>) {
        val first = args.getOrNull(0) ?: throw CommandExecutionException(null)

        val command = commands[first] ?: throw CommandExecutionException("Unknown command: $first")

        command.execute(context, args.subList(1, args.size))
    }

}