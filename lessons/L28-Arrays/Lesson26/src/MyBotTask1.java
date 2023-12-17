import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class MyBotTask1 extends TelegramLongPollingBot {

  @Override
  public void onUpdateReceived(Update update) {
    if (update.hasMessage() && update.getMessage().hasText()) {
      String messageText = update.getMessage().getText();
      String[] words = messageText.split(" ");
      SendMessage sendMessage;

      for (String word : words) {
        sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        sendMessage.setText(word);
        try {
          execute(sendMessage);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }

  
  @Override
  public String getBotToken() {
    return "5951902917:AAFwhQPmsKdBOT2gngpmSdUh9nh59R0FF6E";
  }

  @Override
  public String getBotUsername() {
    return "KiriagerBot";
  }

}