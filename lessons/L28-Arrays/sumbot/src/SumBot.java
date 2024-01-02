import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class SumBot extends TelegramLongPollingBot {
  public static final String INVALID_NUMBER_FORMAT_ERROR_TEXT = "Can't calculate sum. Message text contains invalid number format.";

  @Override
  public void onUpdateReceived(Update update) {
    if (update.hasMessage() && update.getMessage().hasText()) {
      SendMessage respond = new SendMessage();
      respond.setChatId(update.getMessage().getChatId());
      respond.setText(createRespondText(update.getMessage().getText()));

      try {
        this.execute(respond);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  private String createRespondText(String messageText) {
    int sum = 0;
    String[] rows = messageText.split("\n");
    
    for (int i = 0; i < rows.length; i++) {
      try {
        sum += Integer.parseInt(rows[i]);
      } catch (Exception e) {
        return INVALID_NUMBER_FORMAT_ERROR_TEXT;
      }
    }

    return Integer.toString(sum);
  }

  @Override
  public String getBotToken() {
    return "BotToken";
  }

  @Override
  public String getBotUsername() {
    return "BotName";
  }
}
