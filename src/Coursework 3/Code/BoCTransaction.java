import java.math.BigDecimal;
import java.util.Date;

public class BoCTransaction {
	private String transactionName;
	private BigDecimal transactionValue;
	private int transactionCategory;
	private Date transactionTime;

	public BoCTransaction() {
		transactionName = null;
		transactionValue = null;
		transactionCategory = 0;
		transactionTime = null;
	}


/*  
    Origin Code:
	public BoCTransaction(String tName, BigDecimal tValue, int tCat) {
		transactionName = tName;
		transactionValue = tValue;
		transactionCategory = tCat;
		transactionTime = new Date();
	}
*/
	public BoCTransaction(String tName, BigDecimal tValue, int tCat) {
		if(tName.length() > 25) {
			tName = tName.substring(0,25);
		}
		transactionName = tName;
		if(tValue.compareTo(new BigDecimal(0)) == -1) {
			tValue = new BigDecimal(0);
		}
		transactionValue = tValue;
		transactionCategory = tCat;
		transactionTime = new Date();
	}
	
	public String transactionName() {
		return transactionName;
	}

	public BigDecimal transactionValue() {
		return transactionValue;
	}

	public int transactionCategory() {
		return transactionCategory;
	}

	public Date transactionTime() {
		return transactionTime;
	}



/*
	public void setTransactionName(String tName) {
		if (tName != null) {
				transactionName = tName;
		}
	}
*/
	public void setTransactionName(String tName) {
		if (tName != null && transactionName == null) {
			if(tName.length() > 25) {
				transactionName = tName.substring(0,25);
			} else {
				transactionName = tName;
			}
		}
	}



/*
	public void setTransactionValue(BigDecimal tValue) {
		if (tValue.compareTo(new BigDecimal("0.00")) == 1) {
			// 1 means bigger, -1 means smaller, 0 means same
			transactionValue = tValue;
		}
	}
*/
	public void setTransactionValue(BigDecimal tValue) {
		if (tValue.compareTo(new BigDecimal("0.00")) == 1 && transactionValue == null) {
			// 1 means bigger, -1 means smaller, 0 means same
			transactionValue = tValue;
		}
	}



/*
	public void setTransactionCategory(int tCat) {
		if (tCat > 0) {
			transactionCategory = tCat;
		}
	}
*/
	public void setTransactionCategory(int tCat) {
		if (tCat >= 0) {
			transactionCategory = tCat;
		}
	}

	public void setTransactionTime(Date tTime) {
		if (tTime != null) {
			transactionTime = tTime;
		}
	}
/*
	new added method
	*/
	public boolean isComplete(){
		if (transactionName != null && transactionValue != null){
			return true;
		}
		return false;
	} 

/*
    public String toString() {
        return transactionName + " - ¥" + transactionValue.toString();
	    }
*/
	@Override
	public String toString() {
		if(transactionValue() == null && transactionTime() == null && transactionCategory() == 0) {
			return "Pending Transaction";
		}
		else {return "(" + transactionTime + ") " + transactionName + " - ¥" + transactionValue.toString();}
	}

}
