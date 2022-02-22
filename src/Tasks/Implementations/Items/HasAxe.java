package Tasks.Implementations.Items;

import Tasks.Abstractions.*;
import Tasks.Abstractions.Enums.TaskState;

public class HasAxe extends Task {

    public HasAxe(Blackboard blackboard) {
        super(blackboard);
    }

    @Override
    public boolean canExecute() {
        return true;
    }

    @Override
    public TaskState doExecute() {
        var hasAxe = getBlackboard().getBot().getInventory()
                .getItems().stream()
                .anyMatch(i -> !i.isNoted() && i.getName().toLowerCase() .contains(" axe"));

        return hasAxe ? succeed() : fail();
    }
}
