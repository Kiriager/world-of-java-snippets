import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class MyBotTask2 extends TelegramLongPollingBot {

  @Override
  public void onUpdateReceived(Update update) {
    if (update.hasMessage() && update.getMessage().hasText()) {
      SendMessage myMessage = new SendMessage();

      myMessage.setChatId(update.getMessage().getChatId());
      myMessage.setText(EmojiTranslator.translateToEmojiLanguage(update.getMessage().getText()));
      try {
        execute(myMessage);
      } catch (Exception e) {
        e.printStackTrace();
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