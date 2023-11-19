import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import com.vdurmont.emoji.Emoji;
import com.vdurmont.emoji.EmojiManager;

public class ReversedEmojiBot extends TelegramLongPollingBot {
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
      return "Sorry... I don't know emoji with your unicode";
    }
    return EmojiManager.getByUnicode(messageText).getDescription();
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
