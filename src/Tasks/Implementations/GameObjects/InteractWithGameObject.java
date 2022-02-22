package Tasks.Implementations.GameObjects;

import Tasks.Abstractions.Blackboard;
import Tasks.Abstractions.Enums.TaskState;
import Tasks.Abstractions.Task;
import com.snowygryphon.osrs.script.GameObject;

import java.util.stream.Collectors;

public class InteractWithGameObject extends Task {
    private final String _targetObject;
    private final Boolean _getFromBlackboard;
    private final String _action;

    public InteractWithGameObject(Blackboard blackboard, String targetObject, String action, Boolean fromBlackBoard) {
        super(blackboard);
        _targetObject = targetObject;
        _getFromBlackboard = fromBlackBoard;
        _action = action;
    }

    @Override
    public boolean canExecute() {
        return true;
    }

    @Override
    public TaskState doExecute() {
        var target = "";

        if(_getFromBlackboard){
            target = getBlackboard().read(_targetObject, String.class);
        } else {
            target = _targetObject;
        }

        getBot().logDebug(String.format("Interacting with: %s, action: %s", target, _action), _debug);

        if(target == "")
            return fail();

        var foundTarget = getBot().getGameObjects().getClosest(target);
        var foundAction = foundTarget.getActions().stream().filter(a -> a.equals(_action)).findFirst();

        if(foundTarget == null)
            return fail("Could not find " + target);

        if(foundAction.isEmpty())
            return fail(String.format("could not find action %s on %s", _action, target));

        getBot().interactWith(foundTarget, foundAction.get());
        return succeed();
    }
}
