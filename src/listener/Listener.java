package listener;

/**
 *
 * @author Nikhil-Ashodariya
 */
import source.NStack;

public class Listener
{

    public static void main(String[] args)
    {
        /**
         * When the NStack object gets full 
         * i.e. when ten elements are inserted 
         * and when we try to insert 11th element then it generates overflowEvent
         */
        NStack s = new NStack();
        OverflowListener1 i1 = new OverflowListener1();
        OverflowListener2 i2 = new OverflowListener2();
        s.addListener(i1);
        s.addListener(i2);
        s.push(23);
        s.push(23);
        s.push(23);
    }
}
