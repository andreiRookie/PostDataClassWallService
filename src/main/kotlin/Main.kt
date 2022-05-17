fun main() {

    val firstPost = Post(
        id = 1,
        date = 111,
        text = "firstPost",
        reposts = null,
        postponedId = null,
        postType = null
    )

    val secondPost = Post(
        id = 5,
        date = 222,
        text = "secondPost",
        reposts = null,
        postponedId = null,
        postType = null
    )

    val thirdPost = Post(
        id = 7,
        date = 333,
        text = "thirdPost",
        reposts = null,
        postponedId = null,
        postType = null
    )

    val fourthPost = Post(
        id = 1,
        date = 444,
        text = "fourthPost",
        reposts = null,
        postponedId = null,
        postType = null
    )

    val fifthPost = Post(
        id = 5,
        date = 555,
        text = "fifthPost",
        reposts = null,
        postponedId = null,
        postType = null
    )

    println(WallService.add(firstPost))
    println(WallService.add(secondPost))
    println(WallService.add(thirdPost))
    println(WallService.add(fourthPost))

    println(WallService.update(Post(
            id = 2,
            date = 444,
            text = "fourthPost",
            reposts = null,
            postponedId = null,
            postType = null
    )))

    println(WallService.update(fifthPost))

    println(WallService.toString())

    WallService.add(Post(
        id = 1234,
        date = 4321,
        text = "text to be changed",
        reposts = null,
        postponedId = null,
        postType = null
    ))
    val testPost = Post(
        id = 1234,
        date = 1234,
        text = "updated text",
        reposts = null,
        postponedId = null,
        postType = null
    )
    println(WallService.toString())

    println(WallService.getPost(5).toString())

    println(WallService.update(testPost))

    println(WallService.toString())


    println("Количество постов: ${WallService.getPostsSize()}")


}