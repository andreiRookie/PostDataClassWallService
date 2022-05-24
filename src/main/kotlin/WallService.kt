import attachments.*

object WallService {

    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()


    private var reports = emptyArray<Report>()
    private val reportReasons = arrayOf(0,1,2,3,4,5,6,7,8)



    fun reportComment(commentId: Int, reason: Int) {
        if (findCommentById(commentId) != null) {

            try {
                reports += Report(commentId = commentId, reason = reportReasons[reason])
                println("report (commentId $commentId, reason $reason) sent")
            } catch (e: IndexOutOfBoundsException) {
                throw ReasonNotFoundException("no report reason with id $reason")
            }

        } else {
            throw CommentNotFoundException("no comment with id $commentId")
        }

    }

    fun createComment(comment: Comment) {

        if (findPostById(comment.postId) != null) {
            comments += comment
        } else {
            throw PostNotFoundException("no post with id ${comment.postId}")
        }

    }


//    fun addComment(comment: Comment){
//          uniqueCommentId
//    }

    fun findCommentById(commentId: Int): Comment? {
        for (comment in comments) {
            if (comment.commentId == commentId) {
                return comment
            }
        }
        return null
    }


    fun findPostById(id: Int): Post? {
        for (post in posts) {
            if (post.id == id) {
                return post
            }
        }
        return null
    }


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

    fun wipePostsOut() {
        posts = emptyArray()
    }

    fun wipeCommentsOut() {
        comments = emptyArray()
    }

    fun getReports(): Array<Report> {
        return reports
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