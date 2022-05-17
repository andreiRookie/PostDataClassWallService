
class WallService {

    private var posts = emptyArray<Post>()


//    private var uniqueId = 1
//        set(value) {
//            if (value > 0) {
//                for (post in posts) {
//                    if (post.id == value) {
//                        field += 1
//                        return
//                    }
//                }
//                field = value
//            }
//            return
//        }

    /*TODO set of unique IDs



     */




    fun add(newPost: Post): Post {

        var uniqueIdSet = buildSet<Int> {
            for (post in posts) {
                add(post.id)
            }
        }

        var uniqueId = if (newPost.id == 0) 1 else newPost.id

        for (id in uniqueIdSet) {
            if (id == uniqueId) {
                uniqueId += 1
                uniqueIdSet += uniqueId
                add(newPost.copy(id = uniqueId))
                return posts.last()
            }

        }
        posts += newPost.copy(id = uniqueId)
        return posts.last()
    }

    fun update(postToUpdate: Post): Boolean {
        val postId = postToUpdate.id

        for((index, post) in posts.withIndex()) {
            if (post.id == postId) {
                posts[index] = postToUpdate.copy(id = post.id, date = post.date)
                return true
            }
        }
        return false
    }

    fun getPostsSize(): Int {
        return posts.size
    }

    override fun toString(): String {
        var result = ""

        for (post in posts) {
            result += "$post\n"
        }
        return result
    }

    fun getPost(id: Int): Post? {
        for (post in posts) {
            if (post.id == id) {
                return post
            }
        }
        return null
    }



    fun getPosts(): Array<Post> {
        return posts
    }

    fun postsToString(): String {
        var result  = ""
        for (post in posts) {
            result += "$post\n"
        }
        return result
    }



//    fun likeById(id: Int) {
//        for ((index, post) in posts.withIndex()) {
//            if (post.id == id) {
//                posts[index] = post.copy(likes = Likes))
//            }
//        }
//    }


}