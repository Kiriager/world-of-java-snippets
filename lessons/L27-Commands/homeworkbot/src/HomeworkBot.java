import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import com.vdurmont.emoji.EmojiParser;

public class HomeworkBot extends TelegramLongPollingBot {
  private static final String UNKNOWN_COMMAND_ANSWER_TEXT = "Sorry, I don't know this command... :confused: Try to use one from menu.";
  private static final String NOT_COMMAND_ANSWER_TEXT = "It's not a command! :confused:";

  public static final String START_COMMAND = "/start";
  public static final String HELP_COMMAND = "/help";
  public static final String CHAT_ID_COMMAND = "/chat_id";

  public static final String HELP_COMMAND_DESCRIPTION = "prints a list of available bot commands";
  public static final String START_COMMAND_DESCRIPTION = "bot starts on this command";
  public static final String CHAT_ID_COMMAND_DESCRIPTION = "prints current chat id";

  public static final String WELCOME_MESSAGE_TEXT = "Welcome to my beautiful Homework Bot!";
  public static final String BOT_COMMANDS_LIST_DESCRIPTION_TEXT = "Here are commands you can use in our Bot:\n";
  
  @Override
  public void onUpdateReceived(Update update) {
    if (update.hasMessage()) {
      SendMessage response = new SendMessage();
      response.setChatId(update.getMessage().getChatId());

      if (update.getMessage().isCommand()) {
        response.setText(getResponseTextForCommand(update.getMessage()));
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

  private String getResponseTextForCommand(Message message) {
    if (message.getText().equals(START_COMMAND)) {
      return EmojiParser.parseToUnicode(WELCOME_MESSAGE_TEXT);
    }
    if (message.getText().equals(HELP_COMMAND)) {
      return getBotCommandsListText();
    }
    if (message.getText().equals(CHAT_ID_COMMAND)) {
      return message.getChatId().toString();
    }

    return EmojiParser.parseToUnicode(UNKNOWN_COMMAND_ANSWER_TEXT);
  }

  private String getBotCommandsListText() {
    return BOT_COMMANDS_LIST_DESCRIPTION_TEXT +
        getCommandListLine(START_COMMAND, START_COMMAND_DESCRIPTION) +
        getCommandListLine(HELP_COMMAND, HELP_COMMAND_DESCRIPTION) + 
        getCommandListLine(CHAT_ID_COMMAND, CHAT_ID_COMMAND_DESCRIPTION);
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
