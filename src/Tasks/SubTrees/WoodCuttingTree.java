package Tasks.SubTrees;

import Tasks.Abstractions.Blackboard;
import Tasks.Abstractions.SequentialTask;
import Tasks.Implementations.GameObjects.InteractWithGameObject;
import Tasks.Implementations.Items.HasAxe;
import Tasks.Implementations.Movement.WalkToTile;

public class WoodCuttingTree extends SequentialTask {

    public WoodCuttingTree(Blackboard blackboard) {
        super(blackboard);

        addChild(new HasAxe(blackboard));
        addChild(new WalkToTile(blackboard, "woodcutting.targetLocation", 10));
        addChild(new InteractWithGameObject(blackboard, "woodcutting.targetTree", "Chop down", true));
    }

    @Override
    public boolean canExecute() {
        return !getBot().getInventory().isFull()
                && getBlackboard().contains("woodcutting.targetLocation")
                && getBlackboard().contains("woodcutting.targetTree");
    }
}
