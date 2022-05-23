import attachments.Attachment

data class Comment(
    val commentId: Int = 100,
    val postId: Int = 203,
    val fromId: Int = 300,
    val date: Int = 400,
    val text: String = "comment text",
    val donut: Donut? = null,
    val replyToUser: Int = 0,
    val replyToComment: Int = 0,
    val attachments: Array<Attachment> = emptyArray(),
    val parentsStack: Array<Int> = emptyArray()
) {
}