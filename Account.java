package ua.kiev.home.prog_it.graduate_work.project1;

class Account {

	private double cashAccount;

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(double sum) {
		this.cashAccount = sum;
	}

	 double getCashAccount() {
		return cashAccount;
	}

	 void addToAccount(double sum) {
		this.cashAccount += sum;
	}

	 void decreaseAccount(double sum) {
		this.cashAccount -= sum;
	}
}
