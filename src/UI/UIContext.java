package UI;

import com.snowygryphon.osrs.script.ui.Button;
import com.snowygryphon.osrs.script.ui.ComboBox;
import com.snowygryphon.osrs.script.ui.Label;
import com.snowygryphon.osrs.script.ui.UICollection;

import java.util.HashMap;
import java.util.function.Consumer;

public class UIContext {
    private final UICollection UICOLLECTION;
    private final HashMap<Button, Runnable> BUTTONS = new HashMap<>();
    private final HashMap<EventComboBox, Consumer> COMBOBOXES = new HashMap<>();

    public UIContext(UICollection ui) {
        UICOLLECTION = ui;
    }

    public Button AddButton(String caption, Runnable callback){
        var button = UICOLLECTION.addButton(caption);
        BUTTONS.put(button, callback);

        return button;
    }

    public ComboBox AddComboBox(EventComboBox dto){
        var comboBox = UICOLLECTION.addComboBox(dto.getLabel());
        comboBox.setElements(dto.options.keySet().stream());

        COMBOBOXES.put(dto, dto.onChangeCallback);
        dto.SetComboBox(comboBox);
        return comboBox;
    }

    public Label AddLabel(String caption, String value){
        var label = UICOLLECTION.addLabel(caption, value);
        return label;
    }


    public void PollUpdates() {
        BUTTONS.entrySet().forEach(set -> {
            if(set.getKey().hasBeenClicked()){
                set.getValue().run();
            }
        });

        COMBOBOXES.entrySet().forEach(set -> {
            var comboBox = set.getKey();
            if(comboBox.SelectionHasChanged()){
                comboBox.RaiseEvent();
            }
        });
    }
}
