package attachments

class PhotoAttachment(override val attachment: Photo) : Attachment {
    override val attachmentType: String = "photo"
}