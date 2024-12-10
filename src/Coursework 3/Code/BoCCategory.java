import java.math.BigDecimal;

public class BoCCategory {
	private String CategoryName;
	private BigDecimal CategoryBudget;
	private BigDecimal CategorySpend;

	public BoCCategory() {
		CategoryName = "New Category";
		CategoryBudget = new BigDecimal("0.00");
		CategorySpend = new BigDecimal("0.00");
	}

	/*public BoCCategory(String newTitle) {
		CategoryName = newTitle;
		CategoryBudget = new BigDecimal("0.00");
		CategorySpend = new BigDecimal("0.00");
	}*/
	public BoCCategory(String newTitle) {
		if(newTitle.length()>15)
		{
			System.err.println("Invalid Input! Title must less than 15 characters!\n");
		}
		else 
		{
			CategoryName = newTitle;
			CategoryBudget = new BigDecimal("0.00");
			CategorySpend = new BigDecimal("0.00");
		}
	}

	public String CategoryName() {
		return CategoryName;
	}

	public BigDecimal CategoryBudget() {
		return CategoryBudget;
	}

	public BigDecimal CategorySpend() {
		return CategorySpend;
	}

	/*public void setCategoryName(String newName) {
		CategoryName = newName;
	}*/
	public void setCategoryName(String newName) {
		if (newName.length()>15||newName=="\r") {
			CategoryName = "wrongInput";
			System.err.println("Invalid Input.You need to Input a right string no more than 15 characters\n");
		}else if(newName.length()==0){
			CategoryName = "New Category";
		} else {
			CategoryName = newName;}
	}

	/*origin code:public void setCategoryBudget(BigDecimal newValue) {
		// 1 means bigger, -1 means smaller, 0 means same
		if (newValue.compareTo(new BigDecimal("0.00")) == 1) {
			CategoryBudget = newValue;
		}
	}*/
		public void setCategoryBudget(BigDecimal newValue) {
		// 1 means bigger, -1 means smaller, 0 means same
		if (newValue.compareTo(new BigDecimal("0.00")) == 1) {
			CategoryBudget = newValue;
		}
		else if(newValue.compareTo(new BigDecimal("0.00")) == 0) {
			CategoryBudget = new BigDecimal("-9999.99"); //if an invaild input was received, the Budget will be set as "-9999.99"
			System.err.println("CategoryBudget can't be zero!");
		}
		else {
			CategoryBudget = new BigDecimal("-9999.99");
			System.err.println("CategoryBudget can't be negative!");
		}
	}

	/*public void addExpense(BigDecimal valueToAdd) {
		CategorySpend = CategorySpend.add(valueToAdd);
	}*/
	public void addExpense(BigDecimal valueToAdd) {
		int i=valueToAdd.compareTo(BigDecimal.ZERO);
			if (i==-1) {
				System.err.println("invaild input! addExpense can not be negative!");
			}
			else {
				CategorySpend = CategorySpend.add(valueToAdd);
				}
	}

	/*public void removeExpense(BigDecimal valueToRemove) {
		CategorySpend = CategorySpend.subtract(valueToRemove);
	}*/
	public void removeExpense(BigDecimal valueToRemove) {
		int i=valueToRemove.compareTo(BigDecimal.ZERO);
		if (i==-1) {
			System.err.println("invaild input! removeExpense can not be negative!");
		}
		else {
			int j=(CategorySpend.subtract(valueToRemove)).compareTo(BigDecimal.ZERO);
			if(j==-1){
			System.err.println("invaild input! removeExpense can not be smaller than addExpense!");
			}
			else {
				CategorySpend = CategorySpend.subtract(valueToRemove);
				}
		}
	}
	public void resetBudgetSpend() {
		CategorySpend = new BigDecimal("0.00");
	}

	public BigDecimal getRemainingBudget() {
		BigDecimal remainingBudget = CategoryBudget.subtract(CategorySpend);
		return remainingBudget;
	}

	@Override
	public String toString() {
		BigDecimal a = new BigDecimal(0);
		int com = getRemainingBudget().compareTo(a);
		if (CategoryName == null){
			CategoryName = "New Category";
		}
		if(com == -1){
			return CategoryName + "(¥" + CategoryBudget.toPlainString() + ") - Est. ¥" + CategorySpend.toPlainString()
					+ " (¥" +  (getRemainingBudget().multiply(new BigDecimal(-1))).toPlainString() + " Overspent)";
		}else{
			return CategoryName + "(¥" + CategoryBudget.toPlainString() + ") - Est. ¥" + CategorySpend.toPlainString()
				+ " (¥" + getRemainingBudget().toPlainString() + " Remaining)";
		}
	}
	/*public String toString() {
		return CategoryName + "(¥" + CategoryBudget.toPlainString() + ") - Est. ¥" + CategorySpend.toPlainString()
				+ " (¥" + getRemainingBudget().toPlainString() + " Remaining)";
	}*/

}
