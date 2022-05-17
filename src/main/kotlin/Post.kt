data class Post(
    val id: Int,
    val date: Int,
    val text: String,
    val reposts: Object?,
    val postponedId: Int?,
    val postType: String?

//    val ownerId: Int,
//    val fromId: Int,
//    val createdBy: Int,
//    val replyOwnerId: Int,
//    val replyPostId: Int,
//    val friendsOnly: Boolean,
//    val comment: Object,
//    val copyright: Object,
//    val likes: Likes
//    val views: Object,
//    val signerId: Int,
//    val canPin: Boolean,
//    val canDelete: Boolean,
//    val canEdit: Boolean,
//    val isPinned: Boolean,
//    val markedAsAds: Boolean,
//    val isFavorite: Boolean,
//    val donut: Object,

//    val postSource: PostSource,
//    var attachments: Array<Attachment>,
//    val geo: GeoLocation,
//    val copyHistory: Array<T>


)