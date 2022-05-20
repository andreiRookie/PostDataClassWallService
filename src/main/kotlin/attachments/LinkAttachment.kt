package attachments

class LinkAttachment(override val attachment: Link) : Attachment {
    override val attachmentType: String = "link"
}