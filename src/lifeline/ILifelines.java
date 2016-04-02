package lifeline;



import java.util.List;



public interface ILifelines
{
    List<ILifeline> getLifelines();
    void setLifelines(List<ILifeline> lifelines);
    void addLifeline(ILifeline lifeline);
}
