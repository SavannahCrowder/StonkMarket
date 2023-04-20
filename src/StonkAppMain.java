public class StonkAppMain {

    StonkMarket sm = new StonkMarket();
    StonksAppView view = new StonksAppView();
    Wallet w;

    public void go(){                       //Main controller for program.
        view.startScreen();                 //Start screen for the program. Feel free to add a splash screen.
        walletInitializer();
        view.printMenu();
        view.walletInfo(w, sm);
        String action = view.getAction("What would you like to do? ");
        while(!action.startsWith("x")) {
            parseAction(action);
            view.walletInfo(w, sm);
            action = view.getAction("What would you like to do? ");
        }
    }

    //Initializes the wallet, either default or with custom values based on user input.
    public void walletInitializer(){
        String walletChoice = view.getAction("Would you like to start with the default wallet, or enter your own?\n" +
                "Enter [d]efault or [c]ustom: ");
        if(walletChoice.startsWith("d")){
            w = new Wallet();
        }
        else{
            int fazCoin = Integer.parseInt(view.getAction("So you want to invest more!\n"
                    + "How much FazCoin do you already own? "));
            double usd = Double.parseDouble(view.getAction("How much money in USD do you plan to work with? "));
            w = new Wallet(fazCoin, usd);
        }
    }

    public void parseAction(String action) {
        if (action.startsWith("b")) {
            int num = Integer.parseInt(view.getAction("How much FazCoin would you like to buy? "));
            purchaseFazCoin(num);
        } else if (action.startsWith("s")) {
            int num = Integer.parseInt(view.getAction("How much FazCoin would you like to sell? "));
            sellFazCoin(num);
        } else if (action.startsWith("n") || action.startsWith("d")) {
            //Don't do anything
        } else {
            System.out.println("Please enter a valid command.");
        }
    }

    //Adds FazCoin to the wallet and removes appropriate USD amount
    public void purchaseFazCoin(int numFazCoin){
        //When buying FazCoin:
        //  Check if there is enough money in your wallet to buy the desired number of FazCoin.
        //  If you can, then add the purchased FazCoin to your wallet and subtract the cost of the purchased FazCoin from your total USD.
        //  Otherwise, if the desired amount of FazCoin costs more than you currently have in USD, print a statement such as "You do not have enough money to buy that much FazCoin."
        if (sm.fazCoinToUSD(numFazCoin) <= w.getUSDollars()) {
            w.setFazCoin(w.getFazCoin() + numFazCoin);
            w.setUSDollars(w.getUSDollars() - sm.fazCoinToUSD(numFazCoin));
        }
        else{
            System.out.println("You do not have enough money to buy that much FazCoin.");
        }

    }

    //Removes FazCoin from the wallet and adds appropriate USD amount
    public void sellFazCoin(int numFazCoin){
        //When selling FazCoin:
        //  Check if there is enough FazCoin in your wallet to sell the desired number of FazCoin.
        //  If you can, then subtract the sold FazCoin from your wallet and add the price of the sold FazCoin to your total USD.
        //  Otherwise, if the desired amount of FazCoin to sell exceeds your current amount of FazCoin, print a statement such as "You do not have enough FazCoin to sell."
        if (numFazCoin <= w.getFazCoin()){
            w.setFazCoin((w.getFazCoin() - numFazCoin));
            w.setUSDollars(w.getUSDollars() + sm.fazCoinToUSD(numFazCoin));
        }
        else{
            System.out.println("You do not have enough FazCoin to sell.");
        }
    }

    public static void main(String[] args) {
        StonkAppMain m = new StonkAppMain();
        m.go();
    }

}
