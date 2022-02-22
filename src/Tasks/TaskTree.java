package Tasks;

import Tasks.Abstractions.Blackboard;
import Tasks.Abstractions.SelectorTask;

public class TaskTree extends SelectorTask {

    public TaskTree(Blackboard blackboard) {
        super(blackboard);
    }

    @Override
    public boolean canExecute() {
        return true;
    }

}
