import java.util.ArrayList;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;


public class HomeworkBot extends TelegramLongPollingBot {
  public static final int MAX_MESSAGES = 5;

  private ArrayList<String> messageList = new ArrayList<>();

  @Override
  public void onUpdateReceived(Update update) {
    if (update.hasMessage() && update.getMessage().hasText()) {
      messageList.add(update.getMessage().getText());
      
      if (messageList.size() >= MAX_MESSAGES) {
        SendMessage respond = new SendMessage();
        respond.setChatId(update.getMessage().getChatId());
        respond.setText(getMessagesListText());

        try {
          execute(respond);
        } catch (Exception e) {
          e.printStackTrace();
        }

        messageList.clear();
      }
    }
  }

  private String getMessagesListText() {
    String result = new String();
    for (int i = 0; i < messageList.size(); i++) {
      result += (i + 1) + " " + messageList.get(i) + "\n";
    }
    return result;
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
