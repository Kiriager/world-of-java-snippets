import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import com.vdurmont.emoji.EmojiParser;

public class MyBot extends TelegramLongPollingBot {

  @Override
  public void onUpdateReceived(Update update) {
    if (update.hasMessage() && update.getMessage().hasText()) {
      SendMessage message = new SendMessage();
      message.setChatId(update.getMessage().getChatId());
      String emoji = stringToEmoji(update.getMessage().getText());
      if (emoji != null) {
        message.setText(emoji);
      } else {
        message.setText(EmojiParser.parseToUnicode(
            "Sorry, there is no such emoji... :confused:"));
      }

      try {
        execute(message);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  private String stringToEmoji(String input) {
    String alias = ":" + input.toLowerCase().trim()
        .replace(" ", "_") + ":" ;
    String emoji = EmojiParser.parseToUnicode(alias);
    if (emoji.equals(alias)) {
      return null;
    }
    return emoji;
  }

  @Override
  public String getBotToken() {
    return "6162500371:AAFQzLQtCpR2Y-ZCu0SofaEniY_Ms6JY12M";
  }

  @Override
  public String getBotUsername() {
    return "MyJava2RSBot";
  }

}