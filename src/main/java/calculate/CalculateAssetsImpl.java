package calculate;

/**
 * Calculates the profit/loss of a foreign currency asset.
 */
public class CalculateAssetsImpl implements Calculate {

    double spread = 0.005;

    @Override
    public double calculateProfitLoss(String amount, double currentRate, double pastRate) {
        double doubleAmount = Double.parseDouble(amount);

        double proffitLoss = (doubleAmount * currentRate) - (doubleAmount * pastRate);
        double percentOfProffitLoss = proffitLoss * spread;
        double total = proffitLoss - percentOfProffitLoss;

        return total;
    }

    public double getSpread() {
        return spread;
    }
}
