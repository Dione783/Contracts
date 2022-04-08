package services;

import java.util.List;

import entities.Installment;

public class Paypal implements PaymentType{
	private double tax=0.02;
	private double feesSimple=0.01;
	
	public Paypal(){
		
	}

	@Override
	public double tax(List<Installment> installments) {
		// TODO Auto-generated method stub
		for(Installment inst : installments) {
			double calc1 = inst.getAmount() + (inst.getAmount() * feesSimple * 1);
			double calc2 = calc1 * tax;
			return calc1 + calc2;
		}
		return 0;
	}
}
