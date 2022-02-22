package Tasks.Abstractions;

import Bot.BotProxy;
import Tasks.Abstractions.Enums.TaskState;

import java.util.ArrayList;
import java.util.stream.Collectors;

public abstract class Task {

    private TaskState _state = TaskState.INACTIVE;
    private final Blackboard _blackboard;
    private final BotProxy _bot;
    private final ArrayList<Task> _children = new ArrayList<>();
    protected Boolean _debug = false;

    public Task(Blackboard blackboard){
        _blackboard = blackboard;
        _bot = _blackboard.getBot();
    }

    public abstract boolean canExecute();

    public TaskState execute() {
        _debug = getBlackboard().contains("debug");

        if(!canExecute())
            return _state;

        if(_state == TaskState.INACTIVE) {
            _state = TaskState.RUNNING;
        }


            getBot().logDebug("executing node: " + super.getClass().getSimpleName(), _debug);
            var childStates = getChildren().stream().map(c -> c.getClass().getSimpleName() + " : " + c.getState().toString()).collect(Collectors.toList()).toString();
            getBot().logDebug("children states: " + childStates, _debug);

        return doExecute();
    }

    protected TaskState fail(){

            getBot().logDebug("node failed: " + super.getClass().getSimpleName(), _debug);

        _state = TaskState.FAILED;
        return TaskState.FAILED;
    }

    protected TaskState fail(String reason) {
        var result = fail();
        getBot().logDebug("reason: " + reason, _debug);
        return result;
    }

    protected TaskState succeed(){

            getBot().logDebug("node succeeded: " + super.getClass().getSimpleName(), _debug);

        _state = TaskState.COMPLETE;
        return TaskState.COMPLETE;
    }

    protected void reset(){
        this._state = TaskState.INACTIVE;
        this.getChildren().forEach(t -> t.reset());
    }

    public TaskState getState(){
        return _state;
    }

    public Blackboard getBlackboard(){
        return _blackboard;
    }
    public BotProxy getBot(){
        return _blackboard.getBot();
    }

    public void addChild(Task task){
        _children.add(task);
    };

    public ArrayList<Task> getChildren(){
        return _children;
    };

    protected abstract  TaskState doExecute();
}

