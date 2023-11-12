import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import com.vdurmont.emoji.EmojiManager;
import com.vdurmont.emoji.EmojiParser;

public class EmojiTestBot extends TelegramLongPollingBot {
  @Override
  public void onUpdateReceived(Update update) {
    if (update.hasMessage() && update.getMessage().hasText()) {
      SendMessage response = new SendMessage();
      response.setChatId(update.getMessage().getChatId());

      String responseText = EmojiParser.parseToUnicode(":ghost:") + "\n";
      responseText += EmojiManager.getForAlias(":crossed_swords:") + "\n";
      responseText += EmojiManager.getForAlias(":crossed_swords:").getUnicode();
      response.setText(responseText);

      try {
        execute(response);
      } catch (Exception e) {
        e.printStackTrace();
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
