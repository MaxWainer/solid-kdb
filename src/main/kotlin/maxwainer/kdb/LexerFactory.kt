package maxwainer.kdb

import maxwainer.kdb.q.Lexer

interface LexerFactory {

    fun createLexer(input: String): Lexer

}