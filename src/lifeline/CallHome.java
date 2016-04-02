package lifeline;



import model.Question;



public class CallHome implements ILifeline
{
    // ei tee mitään, ottaa vain jäljellä olevat vastausvaihtoehdot
    public Question use(Question question)
    {
        return question;
    }



    // palauttaa stringinä vastaajan mietiskelyjä "hmm oisko A tai B"
    public String result()
    {
        return null;
    }
}
