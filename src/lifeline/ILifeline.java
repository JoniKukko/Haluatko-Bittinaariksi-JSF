package lifeline;

import model.Question;

/**
 * Created by valje on 2.4.2016.
 */

public interface ILifeline {

    // tekee jotain ja palauttaa muokatun
    Question use(Question question);



    // palauttaa jotain mitä näytetään sitten sivulla
    String result();
}
