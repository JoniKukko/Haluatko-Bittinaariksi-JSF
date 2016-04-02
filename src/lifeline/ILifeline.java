package lifeline;



import model.Question;



public interface ILifeline
{
    // tekee jotain ja palauttaa muokatun
    Question use(Question question);

    // palauttaa jotain mitä näytetään sitten sivulla
    String result();
}
