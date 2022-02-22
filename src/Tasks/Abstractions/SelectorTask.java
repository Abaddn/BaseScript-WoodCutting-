package Tasks.Abstractions;

import Tasks.Abstractions.Enums.TaskState;

public abstract class SelectorTask extends Task {

    public SelectorTask(Blackboard blackboard) {
        super(blackboard);
    }

    @Override
    public TaskState doExecute() {
        if (this.getChildren().stream().anyMatch(c -> c.getState() == TaskState.COMPLETE))
            return succeed();

        var nextChild = this.getChildren().stream()
                .filter(c -> c.getState() == TaskState.INACTIVE || c.getState() == TaskState.RUNNING)
                .findFirst();

        if(nextChild.isEmpty())
            return fail();

        var childToExecute = nextChild.get();
        if(!childToExecute.canExecute()) {
            childToExecute.fail();
            return getState();
        }

        childToExecute.execute();
        return getState(); //This should always be RUNNING if we got here
    }

    @Override
    protected TaskState fail() {
        resetChildren();
        return super.fail();
    }

    @Override
    protected TaskState succeed() {
        resetChildren();
        return super.succeed();
    }

    private void resetChildren() {
        this.getChildren().forEach(t -> t.reset());
    }
}
