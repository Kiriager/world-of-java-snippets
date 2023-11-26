import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import com.vdurmont.emoji.Emoji;
import com.vdurmont.emoji.EmojiManager;

public class ReversedEmojiBot extends TelegramLongPollingBot {
  public static final String UNKNOWN_EMOJI_MESSAGE = "Sorry... I don't know an emoji with this unicode";

  @Override
  public void onUpdateReceived(Update update) {
    if (update.hasMessage() && update.getMessage().hasText()) {
      SendMessage response = new SendMessage();

      response.setChatId(update.getMessage().getChatId());
      response.setText(getEmojiInfo(update.getMessage().getText()));

      try {
        execute(response);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  private String getEmojiInfo(String messageText) {
    Emoji emoji = EmojiManager.getByUnicode(messageText);
    if (emoji == null) {
      return UNKNOWN_EMOJI_MESSAGE;
    }
    return EmojiManager.getByUnicode(messageText).getDescription();
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
