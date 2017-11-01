import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    public final static String TOKEN = "481732847:AAHBuel7dUkNaUwVZizR59tDVv21Nry8Wqk";

    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getFrom().getFirstName() +
                update.getMessage().getFrom().getUserName() + ":"
                + update.getMessage().getText());

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        sendMessage.setText("Hello " + update.getMessage().getFrom().getFirstName() + "\n"
                + update.getMessage().getText());

        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    public String getBotUsername() {
        return null;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }
}
