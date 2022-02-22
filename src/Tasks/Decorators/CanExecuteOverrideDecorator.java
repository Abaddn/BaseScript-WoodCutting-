package Tasks.Decorators;

import Tasks.Abstractions.Blackboard;
import Tasks.Abstractions.Enums.TaskState;
import Tasks.Abstractions.Task;

import java.util.function.Supplier;

public class CanExecuteOverrideDecorator extends Task {
    private final Task _decoratedTask;
    private final Supplier<Boolean> _predicate;

    public CanExecuteOverrideDecorator(Blackboard blackboard, Task taskToDecorate, Supplier<Boolean> predicate) {
        super(blackboard);
        _decoratedTask = taskToDecorate;
        _predicate = predicate;
    }

    @Override
    public boolean canExecute() {
        return _decoratedTask != null && _predicate.get();
    }

    @Override
    protected TaskState doExecute() {
        return switch (_decoratedTask.execute()){
            case FAILED -> fail();
            case INACTIVE -> TaskState.INACTIVE;
            case RUNNING -> TaskState.RUNNING;
            case COMPLETE -> succeed();
        };
    }
}
