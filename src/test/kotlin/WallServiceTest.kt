import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import attachments.*


class WallServiceTest {


    @Test
    fun add_test() {

        //arrange

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
            geo = null,
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
            geo = null,
        )

        //act
        val actualResult = WallService.update(testPost)

        //assert
        assertTrue(actualResult)
    }

    @Test
    fun update_existingId_propertiesChangingTest() {
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