package lifeline;



import model.Question;



public class FiftyFifty implements ILifeline
{
    // poistaa kaksi varmasti väärää vastausta ja tekee sen nyt
    public Question use(Question question)
    {
        return question;        // placeholder
    }



    // palauttaa null
    public String result()
    {
        return null;
    }
}
