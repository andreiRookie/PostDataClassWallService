package attachments

class Link(
    val url: String = "linkUrl",
    val title: String = "title",
    val description: String = "four positions, gonna show you now, brought the map") {

    override fun toString(): String {
        return "$url $description"
    }
}