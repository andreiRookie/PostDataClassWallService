package attachments

class VideoAttachment(override val attachment: Video) : Attachment {
    override val attachmentType: String = "video"
}