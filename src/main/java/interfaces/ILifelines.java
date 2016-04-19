package interfaces;

import java.util.List;



public interface ILifelines
{
    List<ILifeline> getLifelines();
    void setLifelines(List<ILifeline> lifelines);
    void addLifeline(ILifeline lifeline);
    void removeLifeline(ILifeline lifeline);
}