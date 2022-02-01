package Chat;
import com.snowygryphon.osrs.script.Chat.ChatMessageListener;
import com.snowygryphon.osrs.script.ChatMessage;
import com.sun.jna.platform.win32.Guid;

import java.util.function.Consumer;

public class ChatListener implements ChatMessageListener {

    private final Consumer<ChatMessage> CALLBACK;
    private final Guid.GUID IDENTIFIER;

    public ChatListener(Consumer<ChatMessage> callback) {
        IDENTIFIER = new Guid.GUID();
        CALLBACK = callback;
    }

    @Override
    public void onNewMessage(ChatMessage chatMessage) {
        CALLBACK.accept(chatMessage);
    }

    public Guid.GUID getIdentifier() {
        return IDENTIFIER;
    }
}
