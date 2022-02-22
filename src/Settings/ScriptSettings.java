package Settings;

import Enums.Level;
import Enums.Tree;
import Tasks.Abstractions.Blackboard;
import UI.EventComboBox;
import UI.UIContext;
import Bot.BotProxy;
import com.snowygryphon.osrs.script.ui.RuntimeUI;
import com.snowygryphon.osrs.script.ui.UIMode;

public class ScriptSettings {
    private final UIContext UI_CONTEXT;
    private final BotProxy BOT;
    private final Blackboard BLACKBOARD;

    public ScriptSettings(BotProxy bot, Blackboard blackboard) {
        BOT = bot;
        BLACKBOARD = blackboard;
        var uiRuntime = setupRuntimeUI();
        UI_CONTEXT = new UIContext(uiRuntime.getDefaultUI());

        addUIElements();
    }

    private RuntimeUI setupRuntimeUI(){
        var runtimeUi = BOT.getRuntimeUI();
        runtimeUi.setUIMode(UIMode.Default);

        return runtimeUi;
    }

    private void addUIElements(){
        UI_CONTEXT.AddButton("Set Cutting Location", this::updateTargetLocation);

        var treeCombo = new EventComboBox<Tree>("Tree type", Tree.values())
                .WithCallback(this::updateTargetTree);
        UI_CONTEXT.AddComboBox(treeCombo);
    }

    private void updateTargetTree(Tree tree){
        BOT.logInfo("User selected tree: " + tree.getName());
        BLACKBOARD.write("woodcutting.targetTree", tree.getName());
    }

    private void updateTargetLocation(){
        BOT.logInfo("User updated cutting location");
        BLACKBOARD.write("woodcutting.targetLocation", BOT.getLocalPlayer().getTile());
    }

    public void pollForUpdates(){
        UI_CONTEXT.PollUpdates();
    }
}
