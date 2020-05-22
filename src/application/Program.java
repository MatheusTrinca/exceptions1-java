package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Checkin date (DD/MM/YYYY): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Checkout date (DD/MM/YYYY): ");
			Date checkout = sdf.parse(sc.next());
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: "+reservation);
			
			System.out.println();
			System.out.println("Enter the data to update the reservation:");
			System.out.print("Checkin date (DD/MM/YYYY): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Checkout date (DD/MM/YYYY): ");
			checkout = sdf.parse(sc.next());
			
			reservation.UpdateDates(checkin, checkout);
			System.out.println("Reservation: "+reservation);
		}
		catch(ParseException e) {
			System.out.println("Invalid date format");
		}
		catch(DomainException e) {
			System.out.println("Error in date: "+e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		
		sc.close();
	}
}
