import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            //telegramBotsApi.registerBot(new MyBotTask1());
            telegramBotsApi.registerBot(new MyBotTask2());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
