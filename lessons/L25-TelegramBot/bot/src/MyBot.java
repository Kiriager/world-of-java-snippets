import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class MyBot extends TelegramLongPollingBot {
  @Override
  public void onUpdateReceived(Update update) {
    if (update.hasMessage() && update.getMessage().hasText()) {
      
    }
  }

  @Override
  public String getBotUsername() {
    return "KiriagerBot";
  }

  @Override
  public String getBotToken() {
    return "5951902917:AAFwhQPmsKdBOT2gngpmSdUh9nh59R0FF6E";
  }
}
