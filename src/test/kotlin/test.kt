import org.junit.Assert
import org.junit.Test


annotation class Before

annotation class After

class test {

    @get:Before
    private val userI = User(0, "Я")
    private val userSasha = User(1, "Сашок")
    private val userKatya = User(2, "Катя")
    private val userAnna = User(3, "Аня")

    fun init() {
        ChatService.sendMessage(userI, userSasha, "пишу я сашку")
        ChatService.sendMessage(userI, userKatya, "пишу кате")
        ChatService.sendMessage(userI, userAnna, "пишу анне")
        ChatService.sendMessage(userSasha, userI, "сашок написал")
        ChatService.sendMessage(userKatya, userI, "катя написала")
        ChatService.sendMessage(userAnna, userI, "анна написала")


    }

    @After
    fun clearData() {
        ChatService.clearAllData()
    }

    @Test
    fun getAllMessagesFromChat() {
        val result = ChatService.getAllMessage(1)
        Assert.assertEquals(ArrayList::class, result::class)
    }

    @Test
    fun addMessage() {
        val result =
            ChatService.sendMessage(sendUser = User(0, nameUseer = "Я"), getUser = User(3, "Аня"), "Ваш ответ Анне")
        Assert.assertEquals(true, result)
    }


    @Test(expected = ChatNotFound::class)
    fun deleteNonexistentChat() {
        ChatService.deleteChat(73)
    }

    @Test(expected = MessageNotFound::class)
    fun editNonexistentMessage() {
        ChatService.editMessage(52, "Ваш ответ кате (редактировали)")
    }

    @Test(expected = MessageNotFound::class)
    fun deleteNonexistentMessage() {
        ChatService.deleteMessage(85)
    }

    @Test
    fun unreadChatsCount() {
        val result = ChatService.getUnreadChatsCount(userId = 1)
        Assert.assertEquals(Int::class, result::class)
    }


    @Test
    fun getMessagesFromChat() {
        val result = ChatService.getAllMessage(1)
        Assert.assertEquals(0, result.size)
    }

    //Попробуем получить 5 сообщений из несуществующего чата
    @Test(expected = ChatNotFound::class)
    fun getMessagesFromNonexistentChat() {
        ChatService.getMessagesFromChat(12, 0, 5)
    }
}