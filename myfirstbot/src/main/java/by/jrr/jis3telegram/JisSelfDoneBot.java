package by.jrr.jis3telegram;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
@Component
public class JisSelfDoneBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "Jis_SelfDone_Bot";
    }

    @Override
    public String getBotToken() {
        return "1352159213:AAEc-cN0_de9Me8iLf6IZmDwX8T8yNANTO0";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()){
            Message message = update.getMessage();
            if (message.hasText()){
                String text = message.getText();
                if (text.equals("/Hello")) {
                    String response = "Hello you too, " + message.getFrom().getFirstName();
                    sendMessg(message, response);
                }else if (text.equals("/Привет")){
                    String response = "Приветик, мой дорогой " + message.getFrom().getFirstName();
                    sendMessg(message,response);
                }else if (text.equals("/Bye")){
                    String response = "See you...";
                    sendMessg(message,response);
                }else if (text.equals("/Как дела")){
                    String response = "Всё гуд, в процессе. Сам как?";
                    sendMessg(message,response);
                }  else if (text.equals("/Start")) {
                    String response = "How can I help you?";
                    sendMessg(message, response);
                }
                else if (text.startsWith("/Say")) {
                    String question = text.substring(text.indexOf("/Say") + "/Say".length()).trim();
                    if (question.equals("What temperature now?")) {
                        String response = "30 degrees. Summer";
                        sendMessg(message, response);
                    } else if (question.equals("Какой курс?")) {
                        String response = "смотри в банке";
                        sendMessg(message, response);
                    } else if (question.equals("Куда пойти в Минске?")) {
                        String response = "сиди дома";
                        sendMessg(message, response);
                    } else if (question.contains("майдан")) {
                        String response = "я за тобой слежу:)";
                        sendMessg(message, response);

                    }
                }
            }
        }
    }
    public void sendMessg (Message message, String response){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText(response);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
