package listenerPattarn;

import java.util.EventObject;

/**
 * Created by daihuijun on 2017/6/22.
 */
public interface IEventSource {
    void registerListener(EventObject object, IListener listener);

    void fireEvent(EventObject object);

}
