package listener;

import source.NStack;
import source.OverflowInterface;

/**
 *
 * @author Nikhil-Ashodariya
 */
public class OverflowListener2 implements OverflowInterface
{

    @Override
    public void overflowEvent(NStack nStack)
    {
        /*The listener can perform any code when the stack is full*/
        System.out.println("This is listener 2 ");
        System.out.println("The state of the stack is " + nStack.getTop());
    }
}
