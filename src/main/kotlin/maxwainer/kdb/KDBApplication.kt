package maxwainer.kdb

import maxwainer.kdb.command.CommandDispatcher
import maxwainer.kdb.commands.EchoCommand
import maxwainer.kdb.commands.ExitCommand
import maxwainer.kdb.commands.QSCommand
import maxwainer.kdb.exception.CommandExecutionException
import java.text.DecimalFormat
import kotlin.system.measureTimeMillis

val DEC_FORMAT = DecimalFormat("###,###")

fun main() {
    val context = ExecutionContext()
    val commandDispatcher = CommandDispatcher(context)
    commandDispatcher.also {
        it.registerCommand("qs", QSCommand)
        it.registerCommand("exit", ExitCommand)
        it.registerCommand("echo", EchoCommand)
    }

    while (true) {
        print("[KDB(${context.database?.name ?: "none"})] > ")

        val input = readLine() ?: throw UnsupportedOperationException()
        try {
            val took = measureTimeMillis { commandDispatcher.tryDispatch(input.split(" ")) }
            println("Command took: ${DEC_FORMAT.format(took)}ms")
        } catch (e: CommandExecutionException) {
            if (e.message == null) continue // skip it
            println(e.message)
        }
    }
}