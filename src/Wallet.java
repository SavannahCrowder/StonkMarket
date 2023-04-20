public class Wallet {

    private int fazCoin;
    private double USDollars;


    public Wallet() {
        //Default constructor for the Wallet. Sets FazCoin to 500 and USDollars to 5.
        fazCoin = 500;
        USDollars = 5;

    }

    public Wallet(int fazCoin, double USDollars) {
        //Overloaded constructor for the Wallet. Sets Wallet's FazCoin amount to argument fazCoin and Wallet USDollars to argument USDollars.
        this.fazCoin = fazCoin;
        this.USDollars = USDollars;
    }

    public int getFazCoin() {
        return fazCoin;
    }

    public void setFazCoin(int fazCoin) {
        this.fazCoin = fazCoin;
    }
    public double getUSDollars() {
        return USDollars;
    }
    public void setUSDollars(double USDollars) {
        this.USDollars = USDollars;
    }
}
