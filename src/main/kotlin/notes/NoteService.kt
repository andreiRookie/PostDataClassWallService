package notes

class NoteService {

    private val noteList: MutableList<Note> = mutableListOf()

    //Create

    fun addNote(title: String, text: String): Int {

        val newNote = Note(title = title, text = text)
        noteList += newNote
        return newNote.id
    }

    fun createComment(noteId: Int,
                      replyTo: Boolean,
                      message: String): Int {

        var newComment = NoteComment(noteId = noteId, replyTo = replyTo, message = message)

        for (note in noteList) {
            if (note.id == noteId) {
                note.comments += newComment
                return newComment.commentId
            }
        }
        throw NoteNotFoundException(" No note with id $noteId")
    }


    //Read
    fun getNoteList(): MutableList<Note> {
        return noteList
    }

    fun getCommentList(noteId: Int): MutableList<NoteComment> {

        var comments = mutableListOf<NoteComment>()

        val isDeleted = fun(comment: NoteComment) = !comment.isDeleted

        for (note in noteList) {
            if (note.id == noteId) {
                comments = note.comments.filter(isDeleted) as MutableList<NoteComment>
                return comments
            }
        }
        throw NoteNotFoundException(" No note with id $noteId")
    }

    fun getNoteById(noteId: Int): Note {
        var result: Note = Note()

        for (note in noteList) {
            if (note.id == noteId) {
                result = note
                return result
            }
        }
        throw NoteNotFoundException(" No note with id $noteId")
    }

    //Update
    fun editNote(noteId: Int, newTitle: String, newText: String): Boolean {

        for ((index, note) in noteList.withIndex()) {
            if (note.id == noteId) {
                noteList[index] = note.copy(title = newTitle, text = newText)
                return true
            }
        }
        println("No note with id $noteId")
        return false
    }

    fun editComment(noteId: Int, commentId: Int, message: String): Boolean {
        for (note in noteList) {
            if (note.id == noteId) {
                for ((index,comment) in note.comments.withIndex()) {
                    if (comment.commentId == commentId && !comment.isDeleted) {
                        note.comments[index] = comment.copy(message = message)
                        return true
                    }
                }
                throw  CommentNotFoundException("Comment with id $commentId not found or deleted")


            }


        }
        throw NoteNotFoundException("No note with id $noteId")
    }

    //Delete
    fun deleteNote(noteId: Int): Boolean {
        for ((index, note) in noteList.withIndex()) {
            if (note.id == noteId) {
                noteList.removeAt(index)
                return true
            }
        }
        println("No note with id $noteId")
        return false
    }


    fun deleteComment(noteId: Int, commentId: Int): Boolean {
        for (note in noteList) {
            if (note.id == noteId) {
                for ((index,comment) in note.comments.withIndex()) {
                    if (comment.commentId == commentId && !comment.isDeleted) {
                        //note.comments.removeAt(index)
                        note.comments[index] = note.comments[index].copy(isDeleted = true)
                        return true
                    }

                }
                throw  CommentNotFoundException("Comment with id $commentId not found or deleted")
            }

        }
        throw NoteNotFoundException("No note with id $noteId")
    }

    fun restoreComment(noteId: Int, commentId: Int): Boolean {
        for (note in noteList) {
            if (note.id == noteId) {
                for ((index,comment) in note.comments.withIndex()) {
                    if (comment.commentId == commentId && comment.isDeleted) {
                        note.comments[index] = comment.copy(isDeleted = false)
                        return true
                    }


                }
                throw  CommentNotFoundException("Comment with id $commentId not found or deleted")
            }

        }
        throw NoteNotFoundException("No note with id $noteId")
    }




}