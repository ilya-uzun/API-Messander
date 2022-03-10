import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession

fun  main() {
    val bot = TelegramBotsApi(DefaultBotSession::class.java)
    bot.registerBot(Bot())
}

//https://github.com/rubenlagus/TelegramBots/wiki/Getting-Started

//https://habr.com/ru/sandbox/165353/
