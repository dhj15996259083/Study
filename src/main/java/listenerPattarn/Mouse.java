package listenerPattarn;

import java.util.*;

/**
 * Created by daihuijun on 2017/6/22.
 */
public class Mouse implements IEventSource{
    Map<String, List<IListener>> listeners = new HashMap<String, List<IListener>>();

    @Override
    public void registerListener(EventObject object, IListener listener) {
       List<IListener> l = listeners.get(object.toString());
       if(l == null) {
           l = new ArrayList<>();
       }
       l.add(listener);
       listeners.put(object.toString(), l);
    }

    @Override
    public void fireEvent(EventObject object) {
        List<IListener> l = listeners.get(object.toString());
        if(l == null) {
            return;
        }

        for(int i = 0; i < l.size(); i++) {
            l.get(i).processEvent(object);
        }
    }

    public static void main(String[] args) {
        Mouse mouse = new Mouse();

        ClickEvent click = new ClickEvent(mouse);
        MoveEvent move = new MoveEvent(mouse);

        mouse.registerListener(click, (o)-> {System.out.println(o.getSource()+"点击鼠标");});
        mouse.registerListener(move, (o)-> {System.out.println(o.getSource()+"移动鼠标");});


        mouse.fireEvent(click);
        mouse.fireEvent(move);
    }

}
