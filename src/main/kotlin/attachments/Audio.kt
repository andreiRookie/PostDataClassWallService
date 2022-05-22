package attachments

class Audio(val id: Int = 111,
            val artist: String = "artist",
            val title: String = "title",
            val duration: Int = 222,
            val album: String = "album") {

     override fun toString(): String {
        return "$artist $title"
    }
}