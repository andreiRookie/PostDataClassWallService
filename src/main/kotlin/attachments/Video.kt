package attachments

class Video(
    val id: Int = 111,
    val title: String = "video title",
    val length: Int = 22222,
) {
    override fun toString(): String {
        return "id $id $title"
    }
}