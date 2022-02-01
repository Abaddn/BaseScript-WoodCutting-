package Chat.Models;

public class ChatMessage extends com.snowygryphon.osrs.script.ChatMessage {
    private long _receivedTime;

    public ChatMessage(String from, String message, long receivedTime) {
        super(from, message);
        _receivedTime = receivedTime;
    }

    public long getReceivedTime() {
        return _receivedTime;
    }

}
