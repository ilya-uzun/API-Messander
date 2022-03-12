import java.util.*
// Содержание сообщения
class Storage {
    
    val textPage = " "
    fun getRandQuote(): String{
        val quoteList = mutableListOf<String>("Начинать всегда стоит с того, что сеет сомнения. \n\nБорис Стругацкий.",
            "Начинать всегда стоит с того, что сеет сомнения. \n\nБорис Стругацкий.",
            "80% успеха - это появиться в нужном месте в нужное время.\n\nВуди Аллен",
            "Мы должны признать очевидное: понимают лишь те,кто хочет понять.\n\nБернар Вербер")
        val randValue = (0..quoteList.size-1).random()

        return quoteList.get(randValue)
    }//getRandQuote

    fun IntRange.random() = Random().nextInt((endInclusive + 1) - start) +  start
    

}
