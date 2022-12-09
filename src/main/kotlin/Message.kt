data class Message(//6 создали параметры смс
    val id: Int,
    val chatId: Int,
    val sendUser: String,
    val getUser: Int,
    val text: String,
    var read: Boolean = false
)