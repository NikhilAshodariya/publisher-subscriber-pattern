package publisher;

/**
 *
 * @author Nikhil-Ashodariya
 */
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NStack implements Cloneable
{

    private int top = -1;
    private int a[] = new int[10];//after storing 10 elements it will generate and alert
    private ArrayList<OverflowInterface> h = new ArrayList();

    public void push(int v)
    {
        if (top == a.length - 1)
        {
            fireOverflowTrigger();
        }
        else
        {
            a[++top] = v;
        }
    }

    public int pop()
    {
        System.out.println("This is pop of S1");
        if (top == -1)
        {
            System.out.println("Stack is underflow");
            return -1;
        }
        else
        {
            int v = a[top--];
            return v;
        }
    }

    public void addListener(OverflowInterface h)
    {
        this.h.add(h);
    }

    public void removeListener(OverflowInterface h)
    {
        this.h.remove(h);
    }

    private void fireOverflowTrigger()
    {
        h.stream().forEach((h1)
                -> 
                {
                    try
                    {
                        h1.overflowEvent((NStack) this.clone());//clone is sent so the changes made by client is unaffected
                    }
                    catch (CloneNotSupportedException ex)
                    {
                        Logger.getLogger(NStack.class.getName()).log(Level.SEVERE, null, ex);
                    }
        });
    }

    public int getTop()
    {
        return top;
    }

    public int[] getStack()
    {
        return a.clone();//clone is returned since no one should edit the orignal stack
    }

}
