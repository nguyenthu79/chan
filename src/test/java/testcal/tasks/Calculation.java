package testcal.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import testcal.ui.CalculatorScreen;

public class Calculation implements Task {

    String type ;
    String number1;
    String number2;



    public Calculation(String type, String number1, String number2){
        this.type=type;
        this.number1=number1;
        this.number2=number2;
    }
    public static CalculationBuilder withOperator(String type) {
        return new CalculationBuilder(type);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        char[] arrayNumber = number1.toCharArray();
        for(int i = 0; i<arrayNumber.length; i++) {

            actor.attemptsTo(

                    Click.on(Target.the("number1").located(By.xpath(CalculatorScreen.Number+arrayNumber[i]+CalculatorScreen.endNumber)))
            );
        }
        actor.attemptsTo(
                Check.whether(type == "Add").andIfSo(
                        Click.on(CalculatorScreen.Add)
                ),
                Check.whether(type == "Sub").andIfSo(
                        Click.on(CalculatorScreen.Sub)
                ),
                Check.whether(type == "Mul").andIfSo(
                        Click.on(CalculatorScreen.Mul)
                ),
                Check.whether(type == "Div").andIfSo(
                        Click.on(CalculatorScreen.Div)
                )
        );
        char[] arrayNumber1= number2.toCharArray();
        for (int i=0; i< arrayNumber1.length;i++){
            actor.attemptsTo(
                    Click.on(Target.the("number2").located(By.xpath(CalculatorScreen.Number+arrayNumber1[i]+CalculatorScreen.endNumber)))
            );
        }

    }

    public static class CalculationBuilder{
        String type;
        String number1;
        String number2;
         public CalculationBuilder(String type){
             this.type=type;

         }
         public  CalculationBuilder between(String number1){
             this.number1=number1;
             return this;
         }
         public CalculationBuilder and(String number2){
             this.number2=number2;
             return this;
         }
         public Calculation Run(){
             return instrumented(Calculation.class, this.type, this.number1, this.number2);
         }

    }



}
