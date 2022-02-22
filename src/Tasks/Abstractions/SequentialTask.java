package Tasks.Abstractions;

import Tasks.Abstractions.Enums.TaskState;

public abstract class SequentialTask extends Task {

    public SequentialTask(Blackboard blackboard) {
        super(blackboard);
    }

    @Override
    public TaskState doExecute() {
        if (this.getChildren().stream().anyMatch(c -> c.getState() == TaskState.FAILED))
            return fail(String.format("A child node of %s node was set to failed", this.getClass().getSimpleName()));

        var nextChild = this.getChildren().stream()
                .filter(c -> c.getState() == TaskState.INACTIVE || c.getState() == TaskState.RUNNING)
                .findFirst();

        if(nextChild.isEmpty())
            return succeed();

        var childToExecute = nextChild.get();
        if(!childToExecute.canExecute()) {
            return fail(String.format("%s node was unable to run", nextChild.getClass().getName()));
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
