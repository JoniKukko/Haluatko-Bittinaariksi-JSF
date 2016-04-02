package lifeline;

import model.Question;

/**
 * Created by valje on 2.4.2016.
 */

public class FiftyFifty implements ILifeline {

    // poistaa kaksi varmasti väärää vastausta ja tekee sen nyt
    public Question use(Question question) {
        return question;        // placeholder
    }



    // palauttaa null
    public String result() {
        return null;
    }
}
