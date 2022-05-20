import attachments.*

fun main() {


    val attachments = arrayOf(AudioAttachment(Audio()), VideoAttachment(Video()))

    val testPost = Post(
        id = 0,
        date = 1000,
        text = "testPost",
        reposts = null,
        postponedId = 1,
        postType = "post_type",
        attachments = attachments,
        ownerId = 1,
        fromId = 1,
        createdBy = 1,
        replyOwnerId = 1,
        replyPostId = 1,
        friendsOnly = false,
        comments = null,
        copyright = null,
        likes = 1,
        views = null,
        signerId = 1,
        canPin = false,
        canDelete = false,
        canEdit = false,
        isPinned = false,
        markedAsAds = false,
        isFavorite = false,
        donut = null,
        postSource = null,
        geo = null,
        copyHistory = null
    )

    println(attachments[1].attachmentType)
    println(attachments[0].attachmentType)

    println(testPost.attachments?.get(0)?.attachmentType)
//
//
//
//    val firstPost = Post(
//        id = 1,
//        date = 111,
//        text = "firstPost",
//        reposts = null,
//        postponedId = null,
//        postType = null
//    )
//
//    val secondPost = Post(
//        id = 5,
//        date = 222,
//        text = "secondPost",
//        reposts = null,
//        postponedId = null,
//        postType = null
//    )
//
//    val thirdPost = Post(
//        id = 7,
//        date = 333,
//        text = "thirdPost",
//        reposts = null,
//        postponedId = null,
//        postType = null
//    )
//
//    val fourthPost = Post(
//        id = 1,
//        date = 444,
//        text = "fourthPost",
//        reposts = null,
//        postponedId = null,
//        postType = null
//    )
//
//    val fifthPost = Post(
//        id = 5,
//        date = 555,
//        text = "fifthPost",
//        reposts = null,
//        postponedId = null,
//        postType = null
//    )
//
//    println(WallService.add(firstPost))
//    println(WallService.add(secondPost))
//    println(WallService.add(thirdPost))
//    println(WallService.add(fourthPost))
//
//    println(WallService.update(Post(
//            id = 2,
//            date = 444,
//            text = "fourthPost",
//            reposts = null,
//            postponedId = null,
//            postType = null
//    )))
//
//    println(WallService.update(fifthPost))
//
//    println(WallService.toString())
//
//    WallService.add(Post(
//        id = 1234,
//        date = 4321,
//        text = "text to be changed",
//        reposts = null,
//        postponedId = null,
//        postType = null
//    ))
//    val testPost = Post(
//        id = 1234,
//        date = 1234,
//        text = "updated text",
//        reposts = null,
//        postponedId = null,
//        postType = null
//    )
//    println(WallService.toString())
//
//    println(WallService.getPost(5).toString())
//
//    println(WallService.update(testPost))
//
//    println(WallService.toString())
//
//
//    println("Количество постов: ${WallService.getPostsSize()}")


}