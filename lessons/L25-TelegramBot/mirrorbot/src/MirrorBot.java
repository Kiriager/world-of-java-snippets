import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class MirrorBot extends TelegramLongPollingBot {
  @Override
  public void onUpdateReceived(Update update) {
    if (update.hasMessage() && update.getMessage().hasText()) {
      // cтворюємо об'єкт повідомлення-відповіді
      SendMessage myMessage = new SendMessage();
      // визначаємо чат та текст повідомлення
      myMessage.setChatId(update.getMessage().getChatId());
      myMessage.setText(update.getMessage().getText());
      //відправку повідомлення загортаємо в try...catch
      try {
        execute(myMessage);
      } catch (Exception e) {
        System.err.println(e);
      }
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