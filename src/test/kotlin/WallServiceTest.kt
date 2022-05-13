import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class WallServiceTest {


    @Test
    fun add_test() {

        //arrange
        val service = WallService()
        val testPost = Post(
            id = 0,
            date = 1000,
            text = "testPost"
        )

        val testPost2 = Post(
            id = 1,
            date = 1000,
            text = "testPost"
        )

        val testPost3 = Post(
            id = 0,
            date = 1000,
            text = "testPost"
        )

        //act
        val actualResult = service.add(testPost3).id != 0

        //assert
        assertTrue(actualResult)

    }

    @Test
    fun update_existingIdTest() {
        //arrange

        val service = WallService()
        service.add(Post(
            id = 1,
            date = 121212,
            text = "post"
        ))

        val testPost = Post(
            id = 1,
            date = 12,
            text = "testPost"
        )

        //act
        val actualResult = service.update(testPost)

        //assert
        assertTrue(actualResult)
    }

    @Test
    fun update_existingId_propertiesChangingTest() {

        val service = WallService()

        service.add(Post(
            id = 1234,
            date = 4321,
            text = "text to be updated"
        ))

        service.add(Post(
            id = 1233,
            date = 4321,
            text = "text to be updated"
        ))

        val testPost = Post(
            id = 12344,
            date = 1234,
            text = "updated text"
        )

        service.add(Post(
            id = 12344,
            date = 4321,
            text = "text to be updated"
        ))

        service.update(testPost)

        val expectedResult = "updated text"

        val actualResult = service.getPost(12344)?.text

        assertEquals(expectedResult, actualResult)

    }

    @Test
    fun update_noExistingIdTest() {
        //arrange
        val service = WallService()
        service.add(Post(
            id = 1234,
            date = 4321,
            text = "text to be updated"
        ))
        val testPost = Post(
            id = 1233,
            date = 444,
            text = "updated text"
        )

        //act

        val actualResult = service.update(testPost)

        //assert

        assertFalse(actualResult)
    }

    @Test
    fun update_noExistingId_FailCheck() {
        //arrange
        val service = WallService()
        service.add(Post(
            id = 15,
            date = 4321,
            text = "text to be updated"
        ))

        service.add(Post(
            id = 17,
            date = 4321,
            text = "text to be updated"
        ))
        val testPost = Post(
            id = 14,
            date = 444,
            text = "testPost"
        )

        //act

        val actualResult = service.update(testPost)

        //assert

        assertTrue(actualResult)
    }
}