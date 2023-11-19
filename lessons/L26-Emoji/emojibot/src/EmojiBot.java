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
      response.setText(parseMessageToEmoji(update.getMessage().getText()));

      try {
        execute(response);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  private String parseMessageToEmoji(String messageText) {
    String alias = ":" + messageText.trim().toLowerCase().replace(' ', '_') + ":";
    String unicode = EmojiParser.parseToUnicode(alias);
    if (alias.equals(unicode)) {
      return "Sorry, there's no emoji for alias '" + alias + "'";
    }
    return unicode;
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
