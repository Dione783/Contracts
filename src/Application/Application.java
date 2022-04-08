package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.Paypal;

public class Application {
	public static void main(String[] args) throws ParseException {
		

		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Contract data: ");
		Integer number = sc.nextInt();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		System.out.println("Date:");
		String dates = sc.next();
		Date date = sdf.parse(dates);
		System.out.println("Contract value: ");
		double contractValue = sc.nextDouble();
		Contract contract1 = new Contract(number,date,contractValue);
		System.out.println("Enter number of Installments :");
		int  n=sc.nextInt();
		for(int i=0;i < n;i++) {
			String modifiedDate = dates.substring(0,3) + (Integer.parseInt(dates.substring(4,5))+i) + dates.substring(5,10);
			contract1.add(new Installment(sdf.parse(modifiedDate),contract1.getContractValue()/n));
		}
		System.out.println("number: "+contract1.getNumber());
		System.out.println("date: " + sdf.format(contract1.getDate()));
		System.out.println("number of installments: " + contract1.numberOfInstallments());
		for(Installment inst : contract1.getInstallments()) {
			System.out.println("Due Date : " + inst.getDueDate());
			System.out.println("Installments: " + contract1.total(new Paypal()));
		}
	}
}
