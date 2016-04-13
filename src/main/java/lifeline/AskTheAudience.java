package lifeline;

import interfaces.ILifeline;
import model.Answer;
import model.Question;

import java.util.*;



public class AskTheAudience implements ILifeline
{
    private Question question;
    private String result;
    private int correctAnswerStartingPercentage;



    // Palauttaa stringinä vastausvaihtoehdot ja prosentit tyyliin A: 40 %, C: 20 %
    public AskTheAudience(Question question)
    {
        // alustukset
        this.question = question;
        this.correctAnswerStartingPercentage = 30;

        // käsittely
        this.setResult();
    }



    private void setResult()
    {
        Map<String, Integer> percentages = new HashMap<String, Integer>();

        percentages = this.initPercentages(percentages);
        percentages = this.fillPercentages(percentages);

        // muodostetaan result looppaamalla prosentit läpi
        this.result = "";
        for (Map.Entry<String, Integer> item : percentages.entrySet())
        {
            this.result += item.getKey() + ": " + item.getValue() + "%\n";
        }
    }



    // alustetaan prosentit vastausvaihtoehdoille
    private Map<String, Integer> initPercentages(Map<String, Integer> percentages)
    {
        for (Answer answer : this.question.getAnswers())
        {
            // annetaan oikealle vastaukselle muita paremmat lähtökohdat
            int startPercentage = 0;
            if (answer.getAnswerId() == this.question.getCorrectAnswerId())
                startPercentage = this.correctAnswerStartingPercentage;

            percentages.put(answer.getAnswer(), startPercentage);
        }

        return percentages;
    }



    private Map<String, Integer> fillPercentages(Map<String, Integer> percentages)
    {
        Random random = new Random();
        List<String> mapKeys = new ArrayList<String>(percentages.keySet());

        // arvotaan loput prosentit vastauksille
        for(int i = 0; i < (100 - this.correctAnswerStartingPercentage); i++)
        {
            // haetaan satunnainen vastaus
            String randomKey = mapKeys.get( random.nextInt(mapKeys.size()) );
            int currentPercentage = percentages.get(randomKey);
            // päivitetään prosenttiin yksi lisää
            percentages.put(randomKey, currentPercentage + 1);
        }

        return percentages;
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
