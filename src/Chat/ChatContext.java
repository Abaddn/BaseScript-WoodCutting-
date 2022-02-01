package Chat;

import Chat.Models.TimestampedChatMessage;
import com.snowygryphon.osrs.script.Bot;
import com.snowygryphon.osrs.script.ChatMessage;
import com.sun.jna.platform.win32.Guid;

import java.util.ArrayList;

public class ChatContext {
    private final Bot BOT;
    private ArrayList<TimestampedChatMessage> CHAT_HISTORY = new ArrayList();
    private int MAX_MESSAGE_COUNT = 50;
    private ArrayList<ChatListener> CUSTOM_LISTENERS = new ArrayList();
    
    public ChatContext(Bot BOT) {
        var listener = new ChatListener(this::onNewMessage);
        BOT.getChat().setMessageListener(listener);
        this.BOT = BOT;
    }
    
    public ArrayList<TimestampedChatMessage> getChatHistory() {
        return CHAT_HISTORY;
    }

    public TimestampedChatMessage getLastMessage() {
        var messageCount = CHAT_HISTORY.size();
        if(messageCount == 0)
            return null;

        return CHAT_HISTORY.get(messageCount - 1);
    }

    public Boolean addEventListener(ChatListener listener) {
        CUSTOM_LISTENERS.add(listener);
        return true;
    }

    public Boolean removeEventListener(Guid.GUID identifier){
        return CUSTOM_LISTENERS.removeIf(l -> l.getIdentifier() == identifier);
    }

    private void onNewMessage(ChatMessage message){
        if(CHAT_HISTORY.size() >= MAX_MESSAGE_COUNT){
            removeMessage(0);
        }

        var timestampedMessage = new TimestampedChatMessage(message.getFrom(), message.getMessage(), System.currentTimeMillis());
        CHAT_HISTORY.add(timestampedMessage);

        CUSTOM_LISTENERS.forEach(l -> l.onNewMessage(timestampedMessage));
    }

    private void removeMessage(int index) {
        CHAT_HISTORY.remove(index);
    }
    
}