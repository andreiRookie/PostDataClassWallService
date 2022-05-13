fun main() {

    val firstPost = Post(
        id = 1,
        date = 111,
        text = "firstPost"
    )

    val secondPost = Post(
        id = 5,
        date = 222,
        text = "secondPost"
    )

    val thirdPost = Post(
        id = 7,
        date = 333,
        text = "thirdPost"
    )

    val fourthPost = Post(
        id = 1,
        date = 444,
        text = "fourthPost"
    )

    val fifthPost = Post(
        id = 5,
        date = 555,
        text = "fifthPost"
    )

    println(WallService.add(firstPost))
    println(WallService.add(secondPost))
    println(WallService.add(thirdPost))
    println(WallService.add(fourthPost))

    println(WallService.update(Post(
            id = 2,
    date = 444,
    text = "fourthPost"
    )))

    println(WallService.update(fifthPost))

    println(WallService.toString())

    WallService.add(Post(
        id = 1234,
        date = 4321,
        text = "text to be changed"
    ))
    val testPost = Post(
        id = 1234,
        date = 1234,
        text = "updated text"
    )
    println(WallService.toString())

    WallService.update(testPost)

    println(WallService.toString())


    println("Количество постов: ${WallService.getPostsSize()}")


}