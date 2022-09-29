package maxwainer.kdb

import maxwainer.kdb.qs.Lexer

interface LexerFactory {

    fun createLexer(input: String): Lexer

}