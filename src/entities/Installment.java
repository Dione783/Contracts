package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {
	private Date dueDate;
	private double amount;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
	
	public Installment(Date dueDate,double amount) {
		this.dueDate=dueDate;
		this.amount=amount;
	}
	
	public String getDueDate() {
		return sdf.format(dueDate);
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
