
object WallService {

    private var posts = emptyArray<Post>()

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



//    fun likeById(id: Int) {
//        for ((index, post) in posts.withIndex()) {
//            if (post.id == id) {
//                posts[index] = post.copy(likes = Likes))
//            }
//        }
//    }


}