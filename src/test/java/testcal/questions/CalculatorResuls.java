package testcal.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import testcal.ui.CalculatorScreen;

public class CalculatorResuls implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(CalculatorScreen.Result).viewedBy(actor).asString();
    }

    public static Question<String> calculationResult(){
        return new CalculatorResuls();
    }
}
