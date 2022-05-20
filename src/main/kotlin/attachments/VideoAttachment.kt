package attachments

data class VideoAttachment(override val attachmentType: String = "video", val video: Video) : Attachment {

}