package listenerPattarn;

import java.util.EventObject;

/**
 * Created by daihuijun on 2017/6/22.
 */
public class MoveEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public MoveEvent(Object source) {
        super(source);
    }

    public String toString() {
        return "move";
    }
}
