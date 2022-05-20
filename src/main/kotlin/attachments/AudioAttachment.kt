package attachments

data class AudioAttachment(override val attachmentType: String = "audio", val audio: Audio) : Attachment {

}