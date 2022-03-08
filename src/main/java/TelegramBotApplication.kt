import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession


class TelegramBotApplication

fun  main() {
    val bot = TelegramBotsApi(DefaultBotSession::class.java)
    bot.registerBot(Bot())
}

//class Storage(quoteList: ArrayList<String>){
//    constructor(quoteList: ArrayList<String>){
//        val quoteList = ArrayList<String>()
//        quoteList.add("Начинать всегда стоит с того, что сеет сомнения. \n\nБорис Стругацкий.")
//        quoteList.add("Начинать всегда стоит с того, что сеет сомнения. \n\nБорис Стругацкий.")
//        quoteList.add("80% успеха - это появиться в нужном месте в нужное время.\n\nВуди Аллен")
//        quoteList.add("Мы должны признать очевидное: понимают лишь те,кто хочет понять.\n\nБернар Вербер")
//    }
//    fun getRandQuote(){
//        val randValue = (Math.random() * quoteList.size())
//        return quoteList.get(randValue)
//    }
//}//Storage



class Bot: TelegramLongPollingBot() {

    //val storage = Storage()
    // Имя бота которые получим при его создание
    override fun getBotToken() = "5119612006:AAFH8UCHd0N580nRx7mwYpUMHRkdTzUYtCI"

    // APP ключ
    override fun getBotUsername() = "TestErey_bot"

    // Метод для получения сообщений от пользователей
    override fun onUpdateReceived(update: Update) {

        try {
            if (update.hasMessage() && update.getMessage().hasText()) {
                //Извлекаем из объекта сообщение пользователя
                val messageBot = update.getMessage()
                //Достаем из inMess id чата пользователя
                val chatId = messageBot.getChatId().toString()
                //Получаем текст сообщения пользователя, отправляем в написанный нами обработчик
                val response = parseMessage(messageBot.getText())
                val messageOut = SendMessage()
                //Добавляем в наше сообщение id чата а также наш ответ
                messageOut.setText(response)
                messageOut.setChatId(chatId)
                execute(messageOut) // Отправляем сообщение
            }
            } catch (e: TelegramApiException) {
                e.printStackTrace()
            }
        }
    
    fun parseMessage (textMsg: String): String {
        val response: String

        if(textMsg.equals("/start"))
            response = "Приветствую, бот знает много цитат. Жми /get, чтобы получить случайную из них";
        else if(textMsg.equals("/get")) // сдесь будет можно вставить строку для опоиска
            //response = storage.getRandQuote()
            response = "Команда распознано"
        else
            response = "Команда не распознано"

        return response;
    }

}//class Bot

//https://github.com/rubenlagus/TelegramBots/wiki/Getting-Started

//https://habr.com/ru/sandbox/165353/