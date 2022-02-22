package Tasks.Implementations.Banking;

import Tasks.Abstractions.Blackboard;
import Tasks.Abstractions.SelectorTask;
import Tasks.Decorators.CanExecuteOverrideDecorator;
import Tasks.Implementations.GameObjects.InteractWithGameObject;

public class OpenBank extends SelectorTask {
    public OpenBank(Blackboard blackboard) {
        super(blackboard);

        addChild(new EnsureBankIsOpen(blackboard));
        var interactWithBankNode = new CanExecuteOverrideDecorator(blackboard,
                new InteractWithGameObject(blackboard, "Bank booth", "Bank", false),
                () -> !getBot().getBank().isOpen());

        addChild(interactWithBankNode);
    }

    @Override
    public boolean canExecute() {
        return true;
    }


}
