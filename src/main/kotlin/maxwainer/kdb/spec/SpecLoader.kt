package maxwainer.kdb.spec

interface SpecLoader<T, S> {

    fun loadSpec(to: T, spec: S)

}