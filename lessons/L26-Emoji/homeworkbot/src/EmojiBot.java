import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import com.vdurmont.emoji.EmojiParser;

public class EmojiBot extends TelegramLongPollingBot {
  @Override
  public void onUpdateReceived(Update update) {
    if (update.hasMessage() && update.getMessage().hasText()) {
      SendMessage response = new SendMessage();

      response.setChatId(update.getMessage().getChatId());
      response.setText(createResponseText());

      try {
        execute(response);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  private String createResponseText() {
    int result = (int) (Math.random() * 3);
    if (result == 0) {
      return EmojiParser.parseToUnicode(":scissors:");
    }
    if (result == 1) {
      return EmojiParser.parseToUnicode(":mountain:");
    }
    return EmojiParser.parseToUnicode(":page_facing_up:");
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
