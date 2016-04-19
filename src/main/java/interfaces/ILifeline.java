package interfaces;


import model.Question;

public interface ILifeline
{
    // käyttää lifelinen
    void useLifeline(Question question);

    // palauttaa mahdollisesti muokatun version kysymyksestä
    Question getQuestion();

    // palauttaa jotain mitä näytetään sitten sivulla
    String getResult();

    // palauttaa lifelifen nimen
    String getName();
}