package attachments

interface Attachment {
    val attachmentType: String
    val attachment: Any

    fun attachmentToString(): String {
        return "$attachmentType: $attachment"
    }
}