package maxwainer.kdb.spec

interface SpecReader<I, S> {

    fun readSpec(input: I): S

}