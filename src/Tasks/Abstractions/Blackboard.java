package Tasks.Abstractions;

import  Bot.BotProxy;

import java.util.HashMap;

public class Blackboard {
    private final BotProxy _bot;
    private final HashMap<String, Object> _bag = new HashMap<>();

    public Blackboard(BotProxy bot) {
        _bot = bot;
    }

    public BotProxy getBot() {
        return _bot;
    }

    public void write(String key, Object value){
        if(_bag.containsKey(key)){
            _bag.replace(key, value);
            return;
        }

        _bag.put(key, value);
    }

    public <T> T read(String key, Class<T> targetType){
        return targetType.cast(_bag.getOrDefault(key, null));
    }

    public Boolean contains(String key){
        return _bag.containsKey(key);
    }
}
