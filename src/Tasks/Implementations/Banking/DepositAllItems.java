package Tasks.Implementations.Banking;

import Tasks.Abstractions.Blackboard;
import Tasks.Abstractions.Enums.TaskState;
import Tasks.Abstractions.Task;
import com.snowygryphon.osrs.script.InventoryItem;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class DepositAllItems extends Task {
    private final String _excludedItemsBlackboardKey;

    public DepositAllItems(Blackboard blackboard, String excludedItemsBlackboardKey) {
        super(blackboard);
        _excludedItemsBlackboardKey = excludedItemsBlackboardKey;
    }

    @Override
    public boolean canExecute() {
        return getBlackboard().getBot().getBank().isOpen();
    }

    @Override
    public TaskState doExecute() {
         var exclusions = getBlackboard().read(_excludedItemsBlackboardKey, ArrayList.class );
        if(exclusions == null || exclusions.isEmpty()){
            getBot().getBank().depositInventory();
            getBot().sleep(406,896);
            return succeed();
        }

        //TODO: Get a random inventory slot, and deposit items "nearest" to this slot.
        //TODO: Not as simple as getting closest int, as inventory rows need to be considered.
        //var randomInventorySlot = getBot().getRandom().nextInt( 28);

        var itemsGrouped = getBot().getInventory().getItems().stream().collect(Collectors.groupingBy(i -> i.getName()));
        itemsGrouped.forEach((name, items) -> {
            if(exclusions.stream().filter(e -> e.equals(name)).findAny().isEmpty()){
                DepositItem(items.get(0));
            }
        });

        return succeed();
    }



    private void DepositItem(InventoryItem item){
        getBot().getBank().depositAll(item);
        getBot().sleep(617,854);
    }

}
