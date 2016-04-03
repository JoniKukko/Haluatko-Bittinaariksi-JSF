package lifeline;



import model.Question;



public interface ILifeline
{
    // palauttaa mahdollisesti muokatun version kysymyksestä
    Question getQuestion();

    // palauttaa jotain mitä näytetään sitten sivulla
    String getResult();
}
