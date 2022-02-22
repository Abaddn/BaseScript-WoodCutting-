package Tasks.Implementations.Banking;

import Tasks.Abstractions.Blackboard;
import Tasks.Abstractions.Enums.TaskState;
import Tasks.Abstractions.Task;
import com.snowygryphon.osrs.script.InventoryItem;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CloseBank extends Task {

    public CloseBank(Blackboard blackboard) {
        super(blackboard);
    }

    @Override
    public boolean canExecute() {
        return getBot().getBank().isOpen();
    }

    @Override
    public TaskState doExecute() {
        getBot().getBank().close();

        return succeed();
    }
}
