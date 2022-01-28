package Settings;

import Enums.Level;
import Enums.Tree;
import UI.EventComboBox;
import UI.UIContext;
import com.snowygryphon.osrs.script.Bot;
import com.snowygryphon.osrs.script.ui.RuntimeUI;
import com.snowygryphon.osrs.script.ui.UIMode;

public class ScriptSettings {
    private final UIContext UI_CONTEXT;
    private final Bot BOT;

    private Tree _targetTree;
    private Level _targetLevel;

    public ScriptSettings(Bot bot) {
        BOT = bot;
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
        UI_CONTEXT.AddButton("Click me", () -> BOT.logInfo("User clicked a button"));

        var treeCombo = new EventComboBox<Tree>("Tree type", Tree.values())
                .WithCallback(this::updateTargetTree);
        UI_CONTEXT.AddComboBox(treeCombo);
    }

    private void updateTargetTree(Tree tree){
        BOT.logInfo("User selected tree: " + tree.getName());
        _targetTree = tree;
    }

    public void pollForUpdates(){
        UI_CONTEXT.PollUpdates();
    }

    public Tree getTree(){
        return _targetTree;
    }

    public Level getTargetLevel(){
        return _targetLevel;
    }
}
