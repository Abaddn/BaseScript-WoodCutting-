package Chat;
import com.snowygryphon.osrs.script.Chat.ChatMessageListener;
import com.snowygryphon.osrs.script.ChatMessage;

import java.util.function.Consumer;

public class ChatListener implements ChatMessageListener {

    private final Consumer<ChatMessage> CALLBACK;

    public ChatListener(Consumer<ChatMessage> callback) {
        CALLBACK = callback;
    }

    @Override
    public void onNewMessage(ChatMessage chatMessage) {
        CALLBACK.accept(chatMessage);
    }
}
