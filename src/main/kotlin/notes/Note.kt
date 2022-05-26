package notes

import kotlin.random.Random

data class Note(
    val id: Int = Random.nextInt(0, 1000),
    val title: String = "note title",
    val text: String = "note text"
) {

    val comments: MutableList<NoteComment> = mutableListOf()
}