
class WallService {

    private var posts = emptyArray<Post>()

    private var uniqueId = 1
        set(value) {
            if (value > 0) {
                for (post in posts) {
                    if (post.id == value) {
                        field += 1
                        return
                    }
                }
                field = value
            }
            return
        }


    fun add(newPost: Post): Post {

        uniqueId = newPost.id

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