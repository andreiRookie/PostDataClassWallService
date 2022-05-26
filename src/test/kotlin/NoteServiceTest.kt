import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import notes.*
import notes.CommentNotFoundException
import kotlin.random.Random


class NoteServiceTest {

    @Test
    fun addNote_test() {

        val service = NoteService()

        val expectedResult = service.addNote("title", "text")

        val actualResult = service.getNoteById(expectedResult).id

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun addNote_failCheckTest() {

        val service = NoteService()

        val expectedResult = service.addNote("title", "text")

        val actualResult = Random.nextInt(0, 1000)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun createComment_test() {

        val service = NoteService()

        val noteId = service.addNote("111", "222")
        service.addNote("111", "222")
        service.addNote("111", "222")
        println(service.getNoteList())

        val expectedResult = service.createComment(noteId = noteId, false, "message")
        println(expectedResult)
        val actualResult = service.getNoteById(noteId).comments.last().commentId
        println(actualResult)

        assertEquals(expectedResult, actualResult)
    }

    @Test(expected = NoteNotFoundException::class)
    fun createComment_NoteNotFoundTest() {
        val service = NoteService()

        val noteId = service.addNote("111", "222")
        val absentNoteId = noteId + 1

        val expectedResult = service.createComment(noteId = absentNoteId, false, "message")
        println(expectedResult)
        val actualResult = service.getNoteById(noteId).comments.last().commentId
        println(actualResult)

    }


    @Test
    fun getNoteById_Test() {
        val service = NoteService()

        val noteId1 = service.addNote("11","11")
        val noteId2 = service.addNote("22","22")

        val expectedResult = noteId2
        val actualResult = service.getNoteById(noteId = noteId2).id

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun getNoteList_test() {
        val service = NoteService()

        val noteId1 = service.addNote("11","11")
        val noteId2 = service.addNote("22","22")
        println("$noteId1, $noteId2")

        val expectedResult = mutableListOf(service.getNoteById(noteId = noteId1), service.getNoteById(noteId = noteId2))

        println(expectedResult)

        val actualResult = service.getNoteList()

        println(actualResult)

        val isEqual = expectedResult == actualResult

        assertTrue(isEqual)
    }

    @Test
    fun getCommentList_test() {

        val service = NoteService()

        val noteId1 = service.addNote("11","11")
        val noteId2 = service.addNote("22","22")

        val comment1 = service.createComment(noteId = noteId1, replyTo = false, message = "1111")
        val comment2 = service.createComment(noteId = noteId1, replyTo = false, message = "2222")

        val expectedResult = service.getNoteById(noteId1).comments

        val actualResult = service.getCommentList(noteId1)

        assertEquals(expectedResult, actualResult)

    }

    @Test(expected = NoteNotFoundException::class)
    fun getCommentList_NoteNotFoundTest() {

        val service = NoteService()

        val noteId1 = service.addNote("11","11")
        val noteId2 = service.addNote("22","22")
        val absentNote = noteId2 + 2

        val comment1 = service.createComment(noteId = noteId1, replyTo = false, message = "1111")
        val comment2 = service.createComment(noteId = noteId1, replyTo = false, message = "2222")

        val expectedResult = service.getNoteById(noteId1).comments

        val actualResult = service.getCommentList(absentNote)


    }

    @Test
    fun editNote_trueTest() {
        val service = NoteService()

        val noteId1 = service.addNote("11","11")
        val noteId2 = service.addNote("22","22")

        val actualResult = service.editNote(noteId = noteId1, "33","33")

        assertTrue(actualResult)
    }

    @Test
    fun editNote_falseTest() {
        val service = NoteService()

        val noteId1 = service.addNote("11","11")
        val noteId2 = service.addNote("22","22")
        val absentNote = noteId2 + 2

        val actualResult = service.editNote(noteId = absentNote, "33","33")

        assertFalse(actualResult)
    }

    @Test
    fun editNote_propertiesChangingTest() {
        val service = NoteService()

        val noteId1 = service.addNote("11","11")
        val noteId2 = service.addNote("22","22")


        service.editNote(noteId = noteId1, "33","33")

        val expectedResult = "33"
        val actualResult = service.getNoteById(noteId1).title

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun editComment_test() {
        val service = NoteService()

        val noteId1 = service.addNote("11","11")
        val noteId2 = service.addNote("22","22")

        val comment1 = service.createComment(noteId = noteId1, replyTo = false, message = "1111")
        val comment2 = service.createComment(noteId = noteId1, replyTo = false, message = "2222")

        val actualResult = service.editComment(noteId1, comment2, "555555")

        assertTrue(actualResult)
    }

    @Test(expected = CommentNotFoundException::class)
    fun editComment_commentNotFoundTest() {
        val service = NoteService()

        val noteId1 = service.addNote("11","11")
        val noteId2 = service.addNote("22","22")

        val comment1 = service.createComment(noteId = noteId1, replyTo = false, message = "1111")
        val comment2 = service.createComment(noteId = noteId1, replyTo = false, message = "2222")
        val absentComment = comment2 + 1

        val actualResult = service.editComment(noteId1, absentComment, "555555")

    }

    @Test
    fun editComment_propertyChangingTest() {
        val service = NoteService()

        val noteId1 = service.addNote("11","11")
        val noteId2 = service.addNote("22","22")

        val comment1 = service.createComment(noteId = noteId1, replyTo = false, message = "1111")
        val comment2 = service.createComment(noteId = noteId1, replyTo = false, message = "2222")

        val message = "555555"
        service.editComment(noteId1, comment2, message)

        val expectedResult = "555555"
        val actualResult = service.getNoteById(noteId1).comments[1].message

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun deleteNote_trueTest() {
        val service = NoteService()

        val noteId1 = service.addNote("11","11")
        val noteId2 = service.addNote("22","22")

        val actualResult = service.deleteNote(noteId1)
        assertTrue(actualResult)

    }

    @Test
    fun deleteNote_falseTest() {
        val service = NoteService()

        val noteId1 = service.addNote("11","11")
        val noteId2 = service.addNote("22","22")

        val actualResult = service.deleteNote(noteId1 + 1)
        assertFalse(actualResult)

    }

    @Test(expected = NoteNotFoundException::class)
    fun deleteNote_deletingTest() {
        val service = NoteService()

        val noteId1 = service.addNote("11","11")
        val noteId2 = service.addNote("22","22")

        service.deleteNote(noteId1)

        val actualResult = service.getNoteById(noteId1)

    }

    @Test
    fun deleteComment_test() {
        val service = NoteService()

        val noteId1 = service.addNote("11","11")
        val noteId2 = service.addNote("22","22")


        val comment1 = service.createComment(noteId = noteId2, replyTo = false, message = "1111")
        val comment2 = service.createComment(noteId = noteId2, replyTo = false, message = "2222")

        val actualResult = service.deleteComment(noteId2, comment2)

        assertTrue(actualResult)
    }

    @Test(expected = NoteNotFoundException::class)
    fun deleteComment_NoteNotFoundTest() {
        val service = NoteService()

        val noteId1 = service.addNote("11","11")
        val noteId2 = service.addNote("22","22")


        val comment1 = service.createComment(noteId = noteId2, replyTo = false, message = "1111")
        val comment2 = service.createComment(noteId = noteId2, replyTo = false, message = "2222")

        val actualResult = service.deleteComment(noteId2 + 1, comment2)

        assertTrue(actualResult)
    }

    @Test(expected = CommentNotFoundException::class)
    fun deleteComment_CommentNotFoundTest() {
        val service = NoteService()

        val noteId1 = service.addNote("11","11")
        val noteId2 = service.addNote("22","22")


        val comment1 = service.createComment(noteId = noteId1, replyTo = false, message = "1111")
        val comment2 = service.createComment(noteId = noteId2, replyTo = false, message = "2222")

        val actualResult = service.deleteComment(noteId2, comment1)

        assertTrue(actualResult)
    }

    @Test
    fun restoreComment_test() {
        val service = NoteService()

        val noteId1 = service.addNote("11","11")
        val noteId2 = service.addNote("22","22")


        val comment1 = service.createComment(noteId = noteId2, replyTo = false, message = "55555")
        val comment2 = service.createComment(noteId = noteId2, replyTo = true, message = "2222")

        service.deleteComment(noteId2, comment1)


        val actualResult = service.restoreComment(noteId2, comment1)

        assertTrue(actualResult)

    }
    @Test(expected = NoteNotFoundException::class)
    fun restoreComment_noteNotFoundTest() {
        val service = NoteService()

        val noteId1 = service.addNote("11","11")
        val noteId2 = service.addNote("22","22")


        val comment1 = service.createComment(noteId = noteId2, replyTo = false, message = "55555")
        val comment2 = service.createComment(noteId = noteId2, replyTo = true, message = "2222")

        service.deleteComment(noteId2, comment1)

        val actualResult = service.restoreComment(noteId2 + 1, comment1)

        assertTrue(actualResult)

    }


    @Test(expected = CommentNotFoundException::class)
    fun restoreComment_commentNotFoundTest() {
        val service = NoteService()

        val noteId1 = service.addNote("11","11")
        val noteId2 = service.addNote("22","22")


        val comment1 = service.createComment(noteId = noteId2, replyTo = false, message = "55555")
        val comment2 = service.createComment(noteId = noteId2, replyTo = true, message = "2222")

        service.deleteComment(noteId2, comment1)

        val actualResult = service.restoreComment(noteId2, comment2)

        assertTrue(actualResult)

    }








}