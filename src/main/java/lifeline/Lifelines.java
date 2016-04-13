package lifeline;

import interfaces.ILifeline;
import interfaces.ILifelines;

import java.util.ArrayList;
import java.util.List;



public class Lifelines implements ILifelines
{
    private List<ILifeline> lifelines;



    public Lifelines()
    {
        this.lifelines = new ArrayList<ILifeline>();
    }



    public Lifelines(List<ILifeline> lifelines)
    {
        this.lifelines = lifelines;
    }



    public List<ILifeline> getLifelines()
    {
        return lifelines;
    }



    public void setLifelines(List<ILifeline> lifelines)
    {
        this.lifelines = lifelines;
    }



    public void addLifeline(ILifeline lifeline)
    {
        this.lifelines.add(lifeline);
    }
}
