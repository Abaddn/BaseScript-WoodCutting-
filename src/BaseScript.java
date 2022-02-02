import Bot.BotProxy;
import Settings.ScriptSettings;
import com.snowygryphon.osrs.script.Script;
import com.snowygryphon.osrs.script.ScriptInfo;
import com.snowygryphon.osrs_emu_bot.bot.StupidUtil;

@ScriptInfo(name = "Base Script", author = "Abaddon", version = "0.1")
public class BaseScript extends Script {

    private ScriptSettings SETTINGS;

    @Override
    public void onStart() {
        super.onStart();
        SETTINGS = new ScriptSettings(bot);
    }

    @Override
    public void update() {
        SETTINGS.pollForUpdates();

        if(!bot.isLoggedIn()){
            bot.logInfo("Player not logged in");
            bot.sleep(1000);
        }
        bot.logInfo(StupidUtil.typeString(bot));
    }
}
