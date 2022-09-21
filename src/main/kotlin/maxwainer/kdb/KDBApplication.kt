package maxwainer.kdb

import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@OptIn(ExperimentalTime::class)
fun main() {
    val context = ExecutionContext()
    val queries = mutableListOf<String>() // ?

    while (true) {
        print("[KDB(${context.database?.name ?: "none"})] > ")

        val input = readLine() ?: throw UnsupportedOperationException()
        val lexer = context.lexerFactory.createLexer(input)
        val (result, execTime) = measureTimedValue { lexer.execute() }

        if (result.isSuccess) {
            println("Successfully executed in ${execTime.inWholeNanoseconds}ns")
        }

        if (result.isBi) {
            println("Error while executing query (Code: ${result.obj ?: "???"})")
            println(" > ${result.exception?.message ?: "None"}")
        }
    }
}