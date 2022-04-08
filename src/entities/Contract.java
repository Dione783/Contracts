package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import services.PaymentType;

public class Contract {
	private Integer number;
	private Date date;
	private Double contractValue;
	List<Installment> installments = new ArrayList<>();

	public Contract(Integer number,Date date,Double contractValue) {
		this.number=number;
		this.date=date;
		this.setContractValue(contractValue);
	}
	
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public void add(Installment installment) {
		installments.add(installment);
	}
	
	public int numberOfInstallments() {
		int i=0;
		while(i < installments.size()) {
			i+=1;
		}
		return i;
	}

	public Double total(PaymentType payment) {
		return payment.tax(installments);
	}
	
	public List<Installment> getInstallments(){
		return installments;
	}

	public Double getContractValue() {
		return contractValue;
	}

	public void setContractValue(Double contractValue) {
		this.contractValue = contractValue;
	}
}
