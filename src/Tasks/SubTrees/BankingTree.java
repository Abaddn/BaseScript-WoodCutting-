package Tasks.SubTrees;

import Tasks.Abstractions.Blackboard;
import Tasks.Abstractions.SequentialTask;
import Tasks.Decorators.CanExecuteOverrideDecorator;
import Tasks.Implementations.Banking.CloseBank;
import Tasks.Implementations.Banking.DepositAllItems;
import Tasks.Implementations.Banking.GetClosestBankTile;
import Tasks.Implementations.Banking.OpenBank;
import Tasks.Implementations.GameObjects.InteractWithGameObject;
import Tasks.Implementations.Movement.WalkToTile;

import java.util.ArrayList;


public class BankingTree extends SequentialTask {
    private final String _excludedItemNamesBlackboardKey;


    public BankingTree(Blackboard blackboard, String excludedItemNamesBlackboardKey) {
        super(blackboard);
        _excludedItemNamesBlackboardKey = excludedItemNamesBlackboardKey;

        addChild(new GetClosestBankTile(blackboard, "banking.nearestBankTile"));
        addChild(new WalkToTile(blackboard, "banking.nearestBankTile", 10));
        addChild(new OpenBank(blackboard));
        addChild(new DepositAllItems(blackboard, excludedItemNamesBlackboardKey));
        addChild(new CloseBank(blackboard));
    }

    @Override
    public boolean canExecute() {
        return getBot().getBank().isOpen()
                || getBot().getInventory().isFull() && getBot().getInventory().getItems().stream()
                    .anyMatch(i -> getBlackboard()
                        .read(_excludedItemNamesBlackboardKey, ArrayList.class).stream()
                        .noneMatch(ei -> i.getName().equals(ei)));
    }
}
