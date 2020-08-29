package testcal.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CalculatorScreen {
    public static final Target Add = Target.the("Add").located(By.xpath("//span[@dcg-command='+']"));
    public  static final Target Sub= Target.the("Sub").located(By.xpath("//span[@dcg-command='-']"));
    public static final Target Mul=Target.the("Mul").located(By.xpath("//span[@dcg-command='*']"));
    public static final Target Div= Target.the("Div").located(By.xpath("//span[@dcg-command='/']"));
    public static final Target Result= Target.the("Result").located(By.xpath("//*[@id=\"main\"]//*[@class=\"dcg-basic-expression-value\"]//span[@class='dcg-mq-root-block']"));
    public static String Number= "//span[@dcg-command='";
    public static String  endNumber= "']";
}
