package ch9;

public class Chatting {
    void startChar(String chatId){
        final String nickName = chatId;
        Chat chat = new Chat(){
            @Override
            void start() {
                while (true) {
                    String inputDatat = "안녕하세요";
                    String message = "[" + nickName + "] " + inputDatat;
                    sendMessage(message);
                }
            }
        };
        chat.start();
    }
    class Chat{
        void start(){}
        void sendMessage(String message){}
    }
}
