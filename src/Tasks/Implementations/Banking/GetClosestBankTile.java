package Tasks.Implementations.Banking;

import Tasks.Abstractions.Blackboard;
import Tasks.Abstractions.Enums.TaskState;
import Tasks.Abstractions.Task;

public class GetClosestBankTile extends Task {
    private final String _blackboardKey;

    public GetClosestBankTile(Blackboard blackboard, String blackboardKey) {
        super(blackboard);

        _blackboardKey = blackboardKey;
    }

    @Override
    public boolean canExecute() {
        return true;
    }

    @Override
    public TaskState doExecute() {
        getBlackboard().write(_blackboardKey, getBot().getBank().getClosestBank().getPosition().getTile());
        return succeed();
    }
}
