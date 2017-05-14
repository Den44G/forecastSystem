package ua.kiev.home.prog_it.graduate_work.project1;

import java.util.LinkedList;
import java.util.List;

final class ShoppingCart {

	private List<Strategy> str;
	private double sumOfStartegies;
	private double discountSize;


	void addToCart(Strategy strategy) {
		str = new LinkedList<Strategy>();
		str.add(strategy);
	}

	public double getSumOfStartegies() {
		return sumOfStartegies;
	}

	public double getDiscountSize() {
		return discountSize;
	}

	void deleteFromCart(Strategy strategy) {

		for (Strategy s : str) {
			if (s == strategy) {
				str.remove(s);
			}
		}
	}

	boolean checkout() {
		if (checkStrategies()) {
			calculateDiscount();
			countOfStrategySum();
			return true;
		} else {
			throw new IllegalArgumentException("No strategy selected!");
		}

	}

	// розрахунок знижки у випадку вибору декількох стратегій
	private void calculateDiscount() {
		int discount = str.size();
		switch (discount) {
		case 1:
			discountSize = 10;
			break;
		case 2:
			discountSize = 12;
			break;
		}
	}

	// підрахунок варти обраних стратегій

	private void countOfStrategySum() {
		for (Strategy s : str) {
			sumOfStartegies += s.getPrice();
		}
	}

	// перевірка чи обрано стратегії
	private boolean checkStrategies() {
		if (str.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
}