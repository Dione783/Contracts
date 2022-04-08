package services;

import java.util.List;
import entities.Installment;

public interface PaymentType {
	public double tax(List<Installment> installments);
}
