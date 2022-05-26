package notes

import kotlin.random.Random

data class NoteComment(
    val noteId: Int,
    val commentId: Int = Random.nextInt(0, 1000),
    val replyTo: Boolean = false,
    val message: String = "comment message",
    val isDeleted: Boolean = false
) {

}