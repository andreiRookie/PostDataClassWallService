import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import attachments.*


class WallServiceTest {

    @Test
    fun reportComment_test() {
        WallService.wipeCommentsOut()

        val testPost = Post()
        WallService.add(testPost)

        val testComment = Comment(commentId = 333, postId = 1)
        WallService.createComment(testComment)

        WallService.reportComment(333, 3)

        val actualResult = WallService.getReports().last().commentId == 333 &&
                WallService.getReports().last().reason == 3

        assertTrue(actualResult)
    }

    @Test(expected = CommentNotFoundException::class)
    fun reportComment_shouldThrowCommentNotFound() {
        WallService.wipeCommentsOut()

        val testPost = Post(id = 5)
        WallService.add(testPost)

        val testComment = Comment(commentId = 333, postId = 5)
        WallService.createComment(testComment)

        WallService.reportComment(332, 3)
    }
    @Test(expected = ReasonNotFoundException::class)
    fun reportComment_shouldThrowReasonNotFound() {
        WallService.wipeCommentsOut()

        val testPost = Post(id = 5)
        WallService.add(testPost)

        val testComment = Comment(commentId = 333, postId = 5)
        WallService.createComment(testComment)

        WallService.reportComment(333, 9)
    }

    @Test
    fun createComment_test() {
        WallService.wipePostsOut()
        WallService.wipeCommentsOut()

        val testPost = Post()
        WallService.add(testPost)
        WallService.add(testPost.copy(id = 1))
        WallService.add(testPost.copy(id = 2))
        WallService.add(testPost.copy(id = 4))
        WallService.add(testPost.copy(id = 4))
        WallService.add(testPost.copy(id = 4))

        println(WallService.toString())

        val testComment = Comment(commentId = 333, postId = 3)

        WallService.createComment(testComment)
        WallService.createComment(testComment.copy(commentId = 334, postId = 5))
        WallService.createComment(testComment.copy(commentId = 335, postId = 3))

        val actualResult = WallService.findCommentById(333) == testComment

        assertTrue(actualResult)
    }

    @Test(expected = PostNotFoundException::class)
    fun createComment_shouldThrow() {
        WallService.wipePostsOut()
        WallService.wipeCommentsOut()

        val testPost = Post()
        WallService.add(testPost)
        WallService.add(testPost.copy(id = 1))
        WallService.add(testPost.copy(id = 2))
        WallService.add(testPost.copy(id = 3))

        val testComment = Comment(postId = 5)

        WallService.createComment(testComment)
    }





    @Test
    fun findCommentById_test() {
        //arrange
        WallService.wipePostsOut()
        WallService.wipeCommentsOut()

        val testPost = Post()
        WallService.add(testPost)
        WallService.add(testPost.copy(id = 200))
        WallService.add(testPost.copy(id = 200))
        WallService.add(testPost.copy(id = 200))
        WallService.add(testPost.copy(id = 200))
        WallService.add(testPost.copy(id = 200))

        val testComment = Comment()
        val testComment1 = testComment.copy(commentId = 101)
        val testComment2 = testComment.copy(commentId = 102)
        WallService.createComment(testComment)
        WallService.createComment(testComment1)
        WallService.createComment(testComment2)

        val expectedResult = testComment1

        //act

        val actualResult = WallService.findCommentById(101)

        //assert

        assertEquals(expectedResult, actualResult)

    }

    @Test
    fun findCommentById_nullTest() {
        //arrange
        WallService.wipePostsOut()
        WallService.wipeCommentsOut()

        val testPost = Post()
        WallService.add(testPost)
        WallService.add(testPost.copy(id = 200))
        WallService.add(testPost.copy(id = 200))
        WallService.add(testPost.copy(id = 200))
        WallService.add(testPost.copy(id = 200))
        WallService.add(testPost.copy(id = 200))

        val testComment = Comment()
        val testComment1 = testComment.copy(commentId = 101)
        val testComment2 = testComment.copy(commentId = 102)
        WallService.createComment(testComment)
        WallService.createComment(testComment1)
        WallService.createComment(testComment2)

        val expectedResult = null

        //act

        val actualResult = WallService.findCommentById(103)

        //assert

        assertEquals(expectedResult, actualResult)

    }


    @Test
    fun findPostById_test() {
        WallService.wipePostsOut()
        val testPost = Post()
        val testPost1 = testPost.copy(id = 2)
        WallService.add(testPost)
        WallService.add(testPost.copy(id = 3))
        WallService.add(testPost.copy(id = 4))
        WallService.add(testPost.copy(id = 4))
        WallService.add(testPost.copy(id = 4))
        WallService.add(testPost.copy(id = 4))

        val expectedResult = Post(id = 5)
        val actualResult = WallService.findPostById(5)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun findPostById_nullTest() {
        WallService.wipePostsOut()
        val testPost = Post()
        WallService.add(testPost)
        WallService.add(testPost.copy(id = 1))
        WallService.add(testPost.copy(id = 4))
        WallService.add(testPost.copy(id = 4))
        WallService.add(testPost.copy(id = 4))
        WallService.add(testPost.copy(id = 4))

        val expectedResult = null
        val actualResult = WallService.findPostById(3)

        assertEquals(expectedResult, actualResult)
    }



    @Test
    fun add_test() {

        //arrange
        WallService.wipePostsOut()
        val testPost = Post(
            id = 0,
            date = 1000,
            text = "testPost",
            reposts =  null,
            postponedId =  1,
            postType = "post_type",
            ownerId = 1,
            fromId = 1,
            createdBy = 1,
            replyOwnerId = 1,
            replyPostId = 1,
            friendsOnly = false,
            comments =  null,
            copyright =  null,
            likes = 1,
            views =  null,
            signerId = 1,
            canPin = false,
            canDelete = false,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut =  null,
            postSource = null,
            geo = null
        )

        //act
        val actualResult = WallService.add(testPost).id != 0

        //assert
        assertTrue(actualResult)

    }

    @Test
    fun update_existingIdTest() {
        //arrange
        WallService.wipePostsOut()
        WallService.add(Post(
            id = 1,
            date = 121212,
            text = "post",
            reposts =  null,
            postponedId =  1,
            postType = "post_type",
            ownerId = 1,
            fromId = 1,
            createdBy = 1,
            replyOwnerId = 1,
            replyPostId = 1,
            friendsOnly = false,
            comments =  null,
            copyright =  null,
            likes = 1,
            views =  null,
            signerId = 1,
            canPin = false,
            canDelete = false,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut =  null,
            postSource = null,
            geo = null
        ))

        val testPost = Post(
            id = 1,
            date = 12,
            text = "testPost",
            reposts =  null,
            postponedId =  1,
            postType = "post_type",
            ownerId = 1,
            fromId = 1,
            createdBy = 1,
            replyOwnerId = 1,
            replyPostId = 1,
            friendsOnly = false,
            comments =  null,
            copyright =  null,
            likes = 1,
            views =  null,
            signerId = 1,
            canPin = false,
            canDelete = false,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut =  null,
            postSource = null,
            geo = null
        )

        //act
        val actualResult = WallService.update(testPost)

        //assert
        assertTrue(actualResult)
    }

    @Test
    fun update_existingId_propertiesChangingTest() {
        WallService.wipePostsOut()
        WallService.add(Post(
            id = 1234,
            date = 4321,
            text = "text to be updated",
            reposts =  null,
            postponedId =  1,
            postType = "post_type",
            ownerId = 1,
            fromId = 1,
            createdBy = 1,
            replyOwnerId = 1,
            replyPostId = 1,
            friendsOnly = false,
            comments =  null,
            copyright =  null,
            likes = 1,
            views =  null,
            signerId = 1,
            canPin = false,
            canDelete = false,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut =  null,
            postSource = null,
            geo = null
        ))
        val testPost = Post(
            id = 1234,
            date = 1234,
            text = "updated text",
            reposts =  null,
            postponedId =  1,
            postType = "post_type",
            ownerId = 1,
            fromId = 1,
            createdBy = 1,
            replyOwnerId = 1,
            replyPostId = 1,
            friendsOnly = false,
            comments =  null,
            copyright =  null,
            likes = 1,
            views =  null,
            signerId = 1,
            canPin = false,
            canDelete = false,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut =  null,
            postSource = null,
            geo = null
        )

        WallService.update(testPost)

        val expectedResult = "updated text"

        val actualResult = WallService.getPost(1234)?.text

        assertEquals(expectedResult, actualResult)

    }

    @Test
    fun update_noExistingIdTest() {
        //arrange
        WallService.wipePostsOut()
        WallService.add(Post(
            id = 1234,
            date = 4321,
            text = "text to be updated",
            reposts =  null,
            postponedId =  1,
            postType = "post_type",
            ownerId = 1,
            fromId = 1,
            createdBy = 1,
            replyOwnerId = 1,
            replyPostId = 1,
            friendsOnly = false,
            comments =  null,
            copyright =  null,
            likes = 1,
            views =  null,
            signerId = 1,
            canPin = false,
            canDelete = false,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut =  null,
            postSource = null,
            geo = null
        ))
        val testPost = Post(
            id = 1233,
            date = 444,
            text = "testPost",
            reposts =  null,
            postponedId =  1,
            postType = "post_type",
            ownerId = 1,
            fromId = 1,
            createdBy = 1,
            replyOwnerId = 1,
            replyPostId = 1,
            friendsOnly = false,
            comments =  null,
            copyright =  null,
            likes = 1,
            views =  null,
            signerId = 1,
            canPin = false,
            canDelete = false,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut =  null,
            postSource = null,
            geo = null
        )

        //act

        val actualResult = WallService.update(testPost)

        //assert

        assertFalse(actualResult)
    }

    @Test
    fun update_noExistingId_FailCheck() {
        //arrange
        WallService.wipePostsOut()
        WallService.add(Post(
            id = 17,
            date = 4321,
            text = "text to be updated",
            reposts =  null,
            postponedId =  1,
            postType = "post_type",
            ownerId = 1,
            fromId = 1,
            createdBy = 1,
            replyOwnerId = 1,
            replyPostId = 1,
            friendsOnly = false,
            comments =  null,
            copyright =  null,
            likes = 1,
            views =  null,
            signerId = 1,
            canPin = false,
            canDelete = false,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut =  null,
            postSource = null,
            geo = null
        ))
        val testPost = Post(
            id = 17,
            date = 444,
            text = "testPost",
            reposts =  null,
            postponedId =  1,
            postType = "post_type",
            ownerId = 1,
            fromId = 1,
            createdBy = 1,
            replyOwnerId = 1,
            replyPostId = 1,
            friendsOnly = false,
            comments =  null,
            copyright =  null,
            likes = 1,
            views =  null,
            signerId = 1,
            canPin = false,
            canDelete = false,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut =  null,
            postSource = null,
            geo = null
        )

        //act

        val actualResult = !WallService.update(testPost)

        //assert

        assertTrue(actualResult)
    }
}