import Bot.BotProxy;
import Enums.Axe;
import Settings.ScriptSettings;
import Tasks.Abstractions.Blackboard;
import Tasks.SubTrees.BankingTree;
import Tasks.SubTrees.WoodCuttingTree;
import Tasks.TaskTree;
import com.snowygryphon.osrs.script.Script;
import com.snowygryphon.osrs.script.ScriptInfo;

import java.util.Arrays;
import java.util.stream.Collectors;

@ScriptInfo(name = "Example Script (Woodcutter)", author = "Abaddon", version = "0.1")
public class BaseScript extends Script {

    private ScriptSettings SETTINGS;
    private BotProxy BOTPROXY;
    private TaskTree TASKTREE;

    @Override
    public void onStart() {
        super.onStart();
        BOTPROXY = new BotProxy(bot);
        Blackboard blackboard = setupBlackboard();
        SETTINGS = new ScriptSettings(BOTPROXY, blackboard);
        TASKTREE = setupTree(blackboard);
        //blackboard.write("debug", null);
    }

    private Blackboard setupBlackboard() {
        var blackboard = new Blackboard(BOTPROXY);
        blackboard.write("banking.excludedItemNames", Arrays.stream(Axe.values()).map(a -> a.Name()).collect(Collectors.toList()));
        return blackboard;
    }

    private TaskTree setupTree(Blackboard blackboard){
        var lumberjackTree = new TaskTree(blackboard);
        lumberjackTree.addChild(new WoodCuttingTree(blackboard));
        lumberjackTree.addChild(new BankingTree(blackboard, "banking.excludedItemNames"));

        return lumberjackTree;
    }

    @Override
    public void update() {
        SETTINGS.pollForUpdates();

        if(!bot.isLoggedIn()){
            bot.logInfo("Player not logged in");
            bot.sleep(1000);
        } else {
            TASKTREE.execute();
        }
    }
}
