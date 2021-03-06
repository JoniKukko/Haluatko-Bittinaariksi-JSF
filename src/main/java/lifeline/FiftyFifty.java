package lifeline;

import interfaces.ILifeline;
import model.Answer;
import model.Question;

import java.util.List;
import java.util.Random;



// poistaa kaksi varmasti väärää vastausta ja tekee sen nyt
public class FiftyFifty implements ILifeline
{
    private Question question;
    private String result;



    public void useLifeline(Question question)
    {
        // alustukset
        this.question = question;
        this.result = null;

        // käsittely
        this.removeTwoWrongAnswers();
    }



    private void removeTwoWrongAnswers()
    {
        // haetaan nykyiset vastaukset ja luodaan randomi
        List<Answer> answers = this.question.getAnswers();
        Random random = new Random();
        int index;

        // loopataan niin kauan että on vain kaksi vaihtoehtoa jäljellä
        while(answers.size() > 2)
        {
            index = random.nextInt(answers.size());
            // poistetaan vastaus mikäli se ei ole oikea vastaus
            if (answers.get(index).getAnswerId() != this.question.getCorrectAnswerId())
                answers.remove(index);
        }

        // päivitetään vastaukset
        this.question.setAnswers(answers);

        this.result = "Poistin juuri kaksi varmasti väärää vastausta..";
    }



    public Question getQuestion()
    {
        return question;
    }



    public String getResult()
    {
        return result;
    }



    public String getName() { return "Fifty-Fifty"; }
}
