package testcal.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import testcal.questions.CalculatorResuls;
import testcal.tasks.OpenTheApplication;
import testcal.tasks.Calculation;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class SearchByKeywordStory {

    Actor anna = Actor.named("Anna");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    OpenTheApplication openTheApplication;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
        givenThat(anna).wasAbleTo(openTheApplication);

    }
/*
    @Test
    public void search_results_should_show_the_search_term_in_the_title() {


    }

 */

    @Test
    public void Add_number1_number2() {


        anna.attemptsTo(
                Calculation.withOperator("Add").between("12345678").and("87654321").Run()

        );
        anna.should(
                seeThat(CalculatorResuls.calculationResult(), equalTo("=99999999"))

        );
    }

        @Test
        public void Sub_number1_and_number2() {
            givenThat(anna).wasAbleTo(openTheApplication);

            anna.attemptsTo(
                    Calculation.withOperator("Sub").between("265").and("145").Run()

            );
            anna.should(
                    seeThat(CalculatorResuls.calculationResult(), equalTo("=120"))

            );
        }
        @Test
        public void Mul_number1_number2() {

            anna.attemptsTo(
                    Calculation.withOperator("Mul").between("300").and("1").Run()

            );
            anna.should(
                    seeThat(CalculatorResuls.calculationResult(), equalTo("=300"))

            );
        }
        @Test
        public void Div_number1_number2() {

            anna.attemptsTo(
                    Calculation.withOperator("Div").between("25").and("5").Run()

            );
            anna.should(
                    seeThat(CalculatorResuls.calculationResult(), equalTo("=5"))

            );
        }


    @After
    public void AfterTest(){
        this.herBrowser.quit();
    }


}




