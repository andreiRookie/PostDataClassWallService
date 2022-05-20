package attachments

class AudioAttachment(override val attachment: Audio) : Attachment {
    override val attachmentType: String = "audio"
}