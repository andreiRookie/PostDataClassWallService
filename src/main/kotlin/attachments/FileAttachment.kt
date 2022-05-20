package attachments

class FileAttachment(override val attachment: File) : Attachment {
    override val attachmentType: String = "file"
}