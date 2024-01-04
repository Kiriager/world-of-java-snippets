import java.util.ArrayList;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import com.vdurmont.emoji.EmojiParser;

public class WordChainBot extends TelegramLongPollingBot {

  public static final String DOESNT_MATCH_GAME_CONDITIONS_TEXT = "Word first letter doesn't match with chain last letter. Please try another one.";
  public static final String WORD_ADDED_TEXT = "Word has been added to the chain.";
  public static final String WORD_CONTAINS_SPACES_ERROR = "Word shoudn't contain spaces. Please try another one.";
  public static final String UNKNOWN_COMMAND_ANSWER_TEXT = "Sorry, I don't know this command... :confused: Try to use one from menu.";

  public static final String CLEAR_COMMAND = "/clear";
  public static final String PRINT_COMMAND = "/print";

  ArrayList<String> wordChain = new ArrayList<>();

  @Override
  public void onUpdateReceived(Update update) {
    if (update.hasMessage() && update.getMessage().hasText()) {
      SendMessage response = new SendMessage();
      response.setChatId(update.getMessage().getChatId());

      if (update.getMessage().isCommand()) {
        response.setText(handleCommand(update.getMessage().getText()));
      } else {
        response.setText(handleNonCommandText(update.getMessage().getText()));
      }

      try {
        this.execute(response);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  private String handleNonCommandText(String messageText) {
    String itemText = messageText.trim();

    if (itemText.contains(" ")) {
      return WORD_CONTAINS_SPACES_ERROR;
    }

    if (wordChain.isEmpty()) {
      wordChain.add(itemText);
      return WORD_ADDED_TEXT;
    }
    if (itemText.toLowerCase().charAt(0) != getWordChainLastLetter()) {
      return DOESNT_MATCH_GAME_CONDITIONS_TEXT;
    }

    wordChain.add(itemText);
    return WORD_ADDED_TEXT;
  }

  private String getWordChainLastWord() {
    return wordChain.get(wordChain.size() - 1).toLowerCase();
  }

  private char getWordChainLastLetter() {
    return getWordChainLastWord().charAt(getWordChainLastWord().length() - 1); 
  }


  private String handleCommand(String commandText) {
    if (commandText.equals(PRINT_COMMAND)) {
      return wordChain.toString();
    }
    if (commandText.equals(CLEAR_COMMAND)) {
      wordChain.clear();
      return "Word chain has been cleared.";
    }
    return EmojiParser.parseToUnicode(UNKNOWN_COMMAND_ANSWER_TEXT);
  }

  @Override
  public String getBotToken() {
    return "5951902917:AAFwhQPmsKdBOT2gngpmSdUh9nh59R0FF6E";
  }

  @Override
  public String getBotUsername() {
    return "KiriagerBot";
  }
}
