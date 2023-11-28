import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import com.vdurmont.emoji.EmojiParser;

public class EmojiCommanderBot extends TelegramLongPollingBot {
  private static final String UNKNOWN_COMMAND_ANSWER_TEXT = "Sorry, I don't know this command... :confused: Try to use one from menu.";
  private static final String NOT_COMMAND_ANSWER_TEXT = "It's not a command! :confused:";

  public static final String SHOW_CAT_COMMAND = "/show_cat";
  public static final String SHOW_DOG_COMMAND = "/show_dog";
  public static final String SHOW_BIRD_COMMAND = "/show_bird";

  public static final String CAT_ALIAS = ":cat:";
  public static final String DOG_ALIAS = ":dog:";
  public static final String BIRD_ALIAS = ":bird:";

  @Override
  public void onUpdateReceived(Update update) {
    if (update.hasMessage()) {
      SendMessage response = new SendMessage();
      response.setChatId(update.getMessage().getChatId());

      if (update.getMessage().isCommand()) {
        response.setText(getResponseTextForCommand(update.getMessage().getText()));
      } else {
        response.setText(EmojiParser.parseToUnicode(NOT_COMMAND_ANSWER_TEXT));
      }

      try {
        execute(response);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  private String getResponseTextForCommand(String commandText) {
    if (commandText.equals(SHOW_CAT_COMMAND)) {
      return EmojiParser.parseToUnicode(CAT_ALIAS);
    }
    if (commandText.equals(SHOW_DOG_COMMAND)) {
      return EmojiParser.parseToUnicode(DOG_ALIAS);
    }
    if (commandText.equals(SHOW_BIRD_COMMAND)) {
      return EmojiParser.parseToUnicode(BIRD_ALIAS);
    }

    return EmojiParser.parseToUnicode(UNKNOWN_COMMAND_ANSWER_TEXT);
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
