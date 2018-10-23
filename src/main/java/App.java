import calculate.Calculate;
import calculate.CalculateAssetsImpl;
import controller.Controller;
import entity.CurrencyRates;
import tools.HttpClient;
import view.ViewForm;

/**
 * Main class create instance and start app.
 */
public class App {

    public static void main(String[] args) {

        ViewForm viewForm = new ViewForm("Calculation of a currency asset");
        CurrencyRates currentDate = new CurrencyRates();
        CurrencyRates buyDate = new CurrencyRates();
        Calculate calculate = new CalculateAssetsImpl();
        HttpClient httpClient = new HttpClient();

        Controller controller = new Controller(viewForm, currentDate, buyDate, calculate, httpClient);
        controller.initController();
    }

}
