package UI;

import Misc.Named;
import com.snowygryphon.osrs.script.ui.ComboBox;

import java.util.LinkedHashMap;
import java.util.function.Consumer;

public class EventComboBox<T extends Named>{

    private ComboBox ComboBox;

    private String label = "";
    public int selectedIndex = -1;
    public LinkedHashMap<String, T> options = new LinkedHashMap<>();
    public Consumer<T> onChangeCallback;

    public String getLabel(){
        return this.label;
    };

    public EventComboBox(String label) {
        this.label = label;
    }

    public EventComboBox(String label, T[] options){
        this(label);
        for (T option : options) {
            this.WithOption(option.getName(), option);
        }
        this.label = label;
    }

    public EventComboBox SetComboBox(ComboBox comboBox){
        this.ComboBox = comboBox;
        return this;
    }

    public EventComboBox WithOption(String optionCaption, T value){
        options.put(optionCaption, value);

        if(this.ComboBox != null)
            this.ComboBox.setElements(options.keySet().stream());

        return this;
    }

    public EventComboBox WithCallback(Consumer<T> callback){
        this.onChangeCallback = callback;
        return this;
    }

    public T selectedValue() {
        if(options.size() == 0 || ComboBox.selectedIndex() == -1)
            return null;

        return options.entrySet().stream().toList().get(selectedIndex).getValue();
    }

    public Boolean SelectionHasChanged(){
        return this.ComboBox.selectedIndex() != selectedIndex;
    }

    public void RaiseEvent(){
        if(ComboBox.selectedIndex() == -1)
            return;

        this.selectedIndex = this.ComboBox.selectedIndex();
        this.onChangeCallback.accept(selectedValue());
    }
}