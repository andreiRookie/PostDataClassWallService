package attachments

class Video(
    val id: Int = 111,
    val title: String = "title",
    val length: Int = 22222,
) {
    override fun toString(): String {
        return "$id $title"
    }
}