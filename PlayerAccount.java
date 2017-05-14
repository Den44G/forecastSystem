package ua.kiev.home.prog_it.graduate_work.project1;

public class PlayerAccount {
	private final String name;
	private final long id;
	private double totalSum;
	
	private Account cashAccount = new Account();
	private ShoppingCart shoppingCart = new ShoppingCart();

	
	public PlayerAccount(String name, long id) {
		this.name = name;
		this.id = id;
	}

	public void selectStrategy(Strategy... strategies) {
		for (Strategy str : strategies) {
			shoppingCart.addToCart(str);
		}
	}
	
	public void deselectStrategy(Strategy... strategies) {
		for (Strategy str : strategies) {
			shoppingCart.deleteFromCart(str);
		}
	}
	
	public void replenishAccount(double sum){
		cashAccount.addToAccount(sum);
	}	
	
	public void withdrowlFromAccount(double sum){
		cashAccount.decreaseAccount(sum);
	}
	
    public String placeABet(double sum){
       checkSum(sum);
	   return "Bet is placed sucessfully";
    }

    private void calcTotalSum(double sum){
    	shoppingCart.checkout();
    	double sumWithDiscont = shoppingCart.getSumOfStartegies() - ((shoppingCart.getSumOfStartegies() * shoppingCart.getDiscountSize()) / 100);
    	totalSum=sum+sumWithDiscont;
    	}
    
    private boolean checkSum(double sum){
    	calcTotalSum(sum);
    	if (sum<=0||sum>cashAccount.getCashAccount()||totalSum>cashAccount.getCashAccount()){
    		throw new IllegalArgumentException("Check the bet amount and balance on the account");
    	}
    	else {
    		return true;
    	}
    }
    
    
}
