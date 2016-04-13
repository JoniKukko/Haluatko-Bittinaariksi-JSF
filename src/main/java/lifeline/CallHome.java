package lifeline;

import interfaces.ILifeline;
import model.Answer;
import model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class CallHome implements ILifeline
{
    private Question question;
    private String result;
    private List<String> resultStrings;
    private int odds;



    public CallHome(Question question)
    {
        // alustukset
        this.question = question;

        // millä todennäköisyydellä "vastaaja" tietää oikean vastauksen
        this.odds = 70;

        // TODO: 3.4.2016  Oisko nämä stringit parempi jossain tiedostossa?
        // "vastaajan" vastauksia
        this.resultStrings = new ArrayList<String>();
        this.resultStrings.add("Hmm, luulen että se voisi olla '%s'..");
        this.resultStrings.add("No tää on varma! Se on '%s'.");
        this.resultStrings.add("Ehdottomasti ehkä '%s'.");
        this.resultStrings.add("En tiedä, mutta jos jotain pitää sanoa niin valitsisin '%s'.");
        this.resultStrings.add("Aapuuaa ehkä '%s'?");
        this.resultStrings.add("MITÄ SÄ MULLE SOITTELET!?!");

        // käsittely
        this.setResult();
    }



    private void setResult()
    {
        Random random = new Random();
        List<Answer> answers = this.question.getAnswers();

        // haetaan valmiiksi jokin randomi
        Answer resultAnswer = answers.get( random.nextInt(answers.size()) );

        // haetaan oikea vastaus jos todennäköisyydet nappaa
        if (random.nextInt(100) < this.odds) {
            for (Answer answer : answers) {
                if (answer.getAnswerId() == this.question.getCorrectAnswerId()) {
                    resultAnswer = answer;
                    break; // poistutaan for-loopista
                }
            }
        }

        // haetaan satunnainen vastaus ja lisätään siihen haettu vastaus
        String resultString = this.resultStrings.get( random.nextInt(this.resultStrings.size()) );
        this.result = String.format(resultString, resultAnswer.getAnswer());
    }



    public Question getQuestion()
    {
        return question;
    }



    public String getResult()
    {
        return result;
    }
}
