import attachments.*

data class Post(
    val id: Int = 1,
    val date: Int = 1,
    val text: String = "text",

    val reposts: Reposts? =  null,
    val postponedId: Int =  1,
    val postType: String = "post_type",
    var attachments: Array<Attachment> = emptyArray(),
    val ownerId: Int = 1,
    val fromId: Int = 1,
    val createdBy: Int = 1,
    val replyOwnerId: Int = 1,
    val replyPostId: Int = 1,
    val friendsOnly: Boolean = false,
    val comments: Comments? =  null,
    val copyright: Copyrights? =  null,
    val likes: Int = 1,
    val views: Views? =  null,
    val signerId: Int = 1,
    val canPin: Boolean = false,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false,
    val donut: Donut? =  null,
    val postSource: PostSource? = null,
    val geo: Place? = null,
    val copyHistory: Array<Post>? = emptyArray()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Post

        if (id != other.id) return false
        if (date != other.date) return false
        if (text != other.text) return false
        if (reposts != other.reposts) return false
        if (postponedId != other.postponedId) return false
        if (postType != other.postType) return false
        if (!attachments.contentEquals(other.attachments)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + date
        result = 31 * result + text.hashCode()
        result = 31 * result + (reposts?.hashCode() ?: 0)
        result = 31 * result + (postponedId ?: 0)
        result = 31 * result + (postType?.hashCode() ?: 0)
        result = 31 * result + attachments.contentHashCode()
        return result
    }
}