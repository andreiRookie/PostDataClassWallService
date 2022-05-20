package attachments

data class LinkAttachment(override val attachmentType: String = "link", val link: Link) : Attachment {

}