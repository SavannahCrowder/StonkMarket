import java.util.Random;

public class StonkMarket {

    private double exchangeRate = 1;
    private static final Random RANDY = new Random();
    //Converts the FazCoin value to USD.
    public double fazCoinToUSD(int fazCoin){
        return (fazCoin * getExchangeRate()) / 100.0;
    }

    //Gets exchange rate
    public double getExchangeRate() {

        return exchangeRate;
    }
    public double changeExchangeRate(){
        double percentageChange = RANDY.nextDouble() * 0.1 - 0.5;
        exchangeRate = (1 + percentageChange);
        return exchangeRate;
    }

    //Changes the current exchange rate randomly from -50 to 50 percent.
    //Implementation hints:
    //Call nextDouble() on your Random object
    //Default for nextDouble() (no arguments provided) will return a double in the range of 0-1
    //To change the range of values that will be returned (NOT the size of the range), add or subtract your low-range value
    //Ex: To get range from -30 to 70 percent:
    //exchangeRate += (randy.nextDouble() - 0.3)
    //To change the size of the range of return values (NOT NEEDED FOR THIS IMPLEMENTATION), add an argument to the nextDouble() call based on desired range size
    //Ex: To get range from 0 - 99:
    //return random.nextDouble(100)
}
