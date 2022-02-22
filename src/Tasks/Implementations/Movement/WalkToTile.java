package Tasks.Implementations.Movement;

import Tasks.Abstractions.Blackboard;
import Tasks.Abstractions.Enums.TaskState;
import Tasks.Abstractions.Task;
import com.snowygryphon.osrs.script.Tile;
import com.snowygryphon.osrs.script.WorldPos;

public class WalkToTile extends Task {
    private final String _targetTileName;
    private final int _maxDistance;


    public WalkToTile(Blackboard blackboard, String targetTileName, int maxDistance) {
        super(blackboard);
        _targetTileName = targetTileName;
        _maxDistance = maxDistance;
    }

    @Override
    public boolean canExecute() {
        var player = getBot().getLocalPlayer();
        return player.getAnimation() == -1 && getBot().getTimeSinceLastInteraction() > 2636 + getBot().getRandom().nextInt(3846);
    }

    @Override
    public TaskState doExecute() {
        var targetTile = getBlackboard().read(_targetTileName, Tile.class);

        if(targetTile == null)
            return fail();

        if(getBot().getLocalPlayer().getTile().distance(targetTile.x, targetTile.y) <= _maxDistance)
            return succeed();

        var targetWorldPos = new WorldPos();
        targetWorldPos.setTile(targetTile);
        getBot().webWalkTo(targetWorldPos);

        return getState();
    }
}
