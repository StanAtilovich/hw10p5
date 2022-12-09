fun main() {
    //2 создекм юзера
    val userI = User(0, "Я")
    val userSasha = User(1, "Сашок")
    val userKatya = User(2, "Катя")
    val userAnna = User(3, "Аня")


    //7 отправляем смс
    ChatService.sendMessage(userI, userSasha, "сообщение сашку от меня")
    ChatService.sendMessage(userI, userKatya, "сообщение кате от меня")
    ChatService.sendMessage(userI, userAnna, " сообщения анне от меня")
    ChatService.sendMessage(userSasha, userI, "ответ сашки")
    ChatService.sendMessage(userKatya, userI, "ответ кати")
    ChatService.sendMessage(userAnna, userI, "ответ ани")
    ChatService.sendMessage(userSasha, userAnna, "переписка сашка и ани")

    println("Количество непрочитанных чатов: ${ChatService.getUnreadChatsCount(userI.id)}")


    //15 распечатка всех смс
    printChatListMessages(userI)
    println("\n")
    printChatListMessages(userAnna)


    //18 удаление чата
    println("удаление чата Анна")
    ChatService.deleteChat(3)
    ChatService.getChatUser(userAnna).forEach { println(it) }

    println("\nУдаление чата с Id = 1")
    ChatService.deleteChat(1)


    //19 удаление смс
    println("Удалим смс")
    ChatService.deleteMessage(2)
    printChatListMessages(userKatya)

//22 редактирование смс
    println("редактируем существующее сообщение")
    ChatService.editMessage(0, "Ваш ответ сашку (редактировали)")
    printChatListMessages(userI)
}