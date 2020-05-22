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
		
		System.out.println("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.println("Checkin date (DD/MM/YYYY): ");
		Date checkin = sdf.parse(sc.next());
		System.out.println("Checkout date (DD/MM/YYYY): ");
		Date checkout = sdf.parse(sc.next());
		
		if(!checkout.after(checkin)) 
			System.out.println("Error in reservation, checkout date must be after the checkin date");
		else {
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: "+reservation);
		
			System.out.println("Enter the data to update the reservation:");
			System.out.println("Checkin date (DD/MM/YYYY): ");
			checkin = sdf.parse(sc.next());
			System.out.println("Checkout date (DD/MM/YYYY): ");
			checkout = sdf.parse(sc.next());
			
			Date now = new Date();
			if(checkin.before(now) || checkout.before(now)) {
				System.out.println("Error in reservation, checkout date must be after future dates");
			}else if(!checkout.after(checkin)) {
				System.out.println("Error in reservation, checkout date must be after the checkin date");
			}else {
				reservation.UpdateDates(checkin, checkout);
				System.out.println("Reservation: "+reservation);
				
			}
		
		}
	}
}
