package maxwainer.kdb

import maxwainer.kdb.q.Lexer
import maxwainer.kdb.struct.Database

class ExecutionContext {

    var database: Database? = null
    val lexerFactory: LexerFactory = LexerFactoryImpl()



    private inner class LexerFactoryImpl : LexerFactory {
        override fun createLexer(input: String) = Lexer(input, this@ExecutionContext)
    }

}