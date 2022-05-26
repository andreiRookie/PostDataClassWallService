package notes

interface GenericInterface<A> {

    //var list = List<A>()

    fun add(element: A): Int


    fun getList(): List<A>

    fun getById(id: Int): A


    fun edit(): Boolean {
        return false
    }

    fun delete(): Boolean {
        return false
    }
}