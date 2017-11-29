package listenerPattarn;

import java.util.EventObject;

/**
 * Created by daihuijun on 2017/6/22.
 */
public class ClickEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ClickEvent(Object source) {
        super(source);
    }

    public String toString() {
        return "click";
    }
}
