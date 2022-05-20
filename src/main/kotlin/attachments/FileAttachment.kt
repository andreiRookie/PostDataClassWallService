package attachments

data class FileAttachment(override val attachmentType: String = "file", val file: File) : Attachment {

}