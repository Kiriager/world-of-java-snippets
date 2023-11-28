import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import com.vdurmont.emoji.EmojiParser;

public class EmojiCommanderBot extends TelegramLongPollingBot {
  public static final String UNKNOWN_COMMAND_ANSWER_TEXT = "Sorry, I don't know this command... :confused: Try to use one from menu.";
  public static final String NOT_COMMAND_ANSWER_TEXT = "It's not a command! :confused:";

  public static final String START_COMMAND = "/start";
  public static final String HELP_COMMAND = "/help";
  public static final String SETTINGS_COMMAND = "/settings";

  public static final String SHOW_CAT_COMMAND = "/show_cat";
  public static final String SHOW_DOG_COMMAND = "/show_dog";
  public static final String SHOW_BIRD_COMMAND = "/show_bird";

  public static final String HELP_COMMAND_DESCRIPTION = "prints a list of available bot commands";
  public static final String START_COMMAND_DESCRIPTION = "bot starts on this command";
  public static final String SETTINGS_COMMAND_DESCRIPTION = "sets your profile settings";

  public static final String SHOW_CAT_COMMAND_DESCRIPTION = "shows cat emoji";
  public static final String SHOW_DOG_COMMAND_DESCRIPTION = "shows dog emoji";
  public static final String SHOW_BIRD_COMMAND_DESCRIPTION = "shows bird emoji";

  public static final String CAT_ALIAS = ":cat:";
  public static final String DOG_ALIAS = ":dog:";
  public static final String BIRD_ALIAS = ":bird:";

  public static final String WELCOME_MESSAGE_TEXT = "Welcome to our nice Emoji Commander Bot!";
  public static final String UNIMPLEMENTED_COMMAND_TEXT = "Sorry, I don't have implementation of this command. Please, try to use it later.";
  public static final String BOT_COMMANDS_LIST_DESCRIPTION_TEXT = "Here are commands you can use in our Bot:\n";

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
    if (commandText.equals(START_COMMAND)) {
      return EmojiParser.parseToUnicode(WELCOME_MESSAGE_TEXT);
    }
    if (commandText.equals(HELP_COMMAND)) {
      return getBotCommandsListText();
    }
    if (commandText.equals(SETTINGS_COMMAND)) {
      return UNIMPLEMENTED_COMMAND_TEXT;
    }

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

  private String getBotCommandsListText() {
    return BOT_COMMANDS_LIST_DESCRIPTION_TEXT +
        getCommandListLine(START_COMMAND, START_COMMAND_DESCRIPTION) +
        getCommandListLine(HELP_COMMAND, HELP_COMMAND_DESCRIPTION) + 
        getCommandListLine(SETTINGS_COMMAND, SETTINGS_COMMAND_DESCRIPTION) + 
        getCommandListLine(SHOW_CAT_COMMAND, SHOW_CAT_COMMAND_DESCRIPTION) + 
        getCommandListLine(SHOW_DOG_COMMAND, SHOW_DOG_COMMAND_DESCRIPTION) +  
        getCommandListLine(SHOW_BIRD_COMMAND, SHOW_BIRD_COMMAND_DESCRIPTION);
  }

  private String getCommandListLine(String command, String description) {
    return command + " - " + description + "\n";
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
