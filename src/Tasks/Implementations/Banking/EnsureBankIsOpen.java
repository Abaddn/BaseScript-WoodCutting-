package Tasks.Implementations.Banking;

import Tasks.Abstractions.Blackboard;
import Tasks.Abstractions.Enums.TaskState;
import Tasks.Abstractions.Task;

public class EnsureBankIsOpen extends Task {
    public EnsureBankIsOpen(Blackboard blackboard) {
        super(blackboard);
    }

    @Override
    public boolean canExecute() {
        return true;
    }

    @Override
    protected TaskState doExecute() {
        return getBot().getBank().isOpen() ? succeed() : fail();
    }
}
