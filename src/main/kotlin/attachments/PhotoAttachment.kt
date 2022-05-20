package attachments

data class PhotoAttachment(override val attachmentType: String = "photo", val photo: Photo) : Attachment {

}