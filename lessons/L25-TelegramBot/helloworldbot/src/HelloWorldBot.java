import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class HelloWorldBot extends TelegramLongPollingBot {
  @Override
  public void onUpdateReceived(Update update) {
    if (update.hasMessage() && update.getMessage().hasText()) {
      System.out.println("Hello World!");
    }
  }

  @Override
  public String getBotUsername() {
    // provide your bot username as a return value
    return "MyBotUsername";
  }

  @Override
  public String getBotToken() {
    // provide your bot token as a return value
    return "MyBotToken";
  }
}
