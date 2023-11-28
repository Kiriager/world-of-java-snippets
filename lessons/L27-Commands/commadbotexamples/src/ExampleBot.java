import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class ExampleBot extends TelegramLongPollingBot {
  @Override
  public void onUpdateReceived(Update update) {
    if (update.hasMessage()) {
      if (update.getMessage().isCommand()) {
        //command handling
      } else {
        //other messages handling
      }
    }
  }

  @Override
  public String getBotUsername() {
    return "BotUsername";
  }

  @Override
  public String getBotToken() {
    return "BotToken";
  }
}
