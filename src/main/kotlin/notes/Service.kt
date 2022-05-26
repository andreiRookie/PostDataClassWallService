package notes



abstract class Service<A> {


    //var list = List<A>()

    abstract fun add(obj: A): Int


    abstract fun getList(): List<A>

    abstract fun getById(id: Int): A


    abstract fun edit(): Boolean

    abstract fun delete()
}