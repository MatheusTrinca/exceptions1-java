package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Checkin date (DD/MM/YYYY): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Checkout date (DD/MM/YYYY): ");
		Date checkout = sdf.parse(sc.next());
		
		if(!checkout.after(checkin)) 
			System.out.println("Error in reservation, checkout date must be after the checkin date");
		else {
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: "+reservation);
			
			System.out.println();
			System.out.println("Enter the data to update the reservation:");
			System.out.print("Checkin date (DD/MM/YYYY): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Checkout date (DD/MM/YYYY): ");
			checkout = sdf.parse(sc.next());
			
			String error = reservation.UpdateDates(checkin, checkout);
			if(error != null) {
				System.out.println("Error in reservation: "+error);
			}else {
				System.out.println("Reservation: "+reservation);
			}
		}
		sc.close();
	}
}
