package lifeline;

import model.Question;

/**
 * Created by valje on 2.4.2016.
 */

public class AskTheAudience implements Lifeline {

    // Ei tee mitään, ottaa vain jäljellä olevat vastausvaihtoehdot
    public Question use(Question question) {
        return question;
    }



    // Palauttaa stringinä vastausvaihtoehdot ja prosentit tyyliin A: 40 %, C: 20 %
    public String result() {
        return null;
    }
}
