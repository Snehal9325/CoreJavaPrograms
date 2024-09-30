/*
5. Hotel Reservation System:
Scenario: Design a hotel reservation system that manages room bookings and reservations for a hotel.

Requirements:

Encapsulation: Create classes Room and Reservation with private fields for attributes like room number, type, price for Room, and booking dates, 
room number for Reservation. Provide public getter and setter methods.
Inheritance: Implement a base class Room with common attributes such as room number and type. Extend it to create SingleRoom and SuiteRoom 
classes, each with specific attributes and methods (e.g., suiteAmenities for SuiteRoom).
Polymorphism: Define an interface Reservable with a method makeReservation(Reservation reservation). Implement this interface in Room and 
ConferenceHall classes to handle reservation logic for different types of spaces.
Abstraction: Create an abstract class BookingSystem with abstract methods bookRoom(Room room, Reservation reservation) and cancelBooking
(Reservation reservation). Develop a concrete class HotelBookingSystem that extends BookingSystem and implements these methods for managing 
room bookings and cancellations.
*/
abstract class BookingSystem
{
	public abstract void bookRoom(Room room, Reservation reservation);
	public abstract void cancelBooking(Room room, Reservation reservation);
}
class HotelBookingSystem extends BookingSystem{
	public void bookRoom(Room room, Reservation reservation){
		if(room instanceof SingleRoom){
			System.out.println(room.makeReservation(reservation));
			System.out.println("Room Booked..............");
		}
		else if(room instanceof SuiteRoom)
			System.out.println(room.makeReservation(reservation));
		System.out.println("Room Booked..............");
	}
	public void cancelBooking( Room room,Reservation reservation){
		if(room instanceof SingleRoom){
			reservation = null;
			System.out.println(room.makeReservation(reservation));
			System.out.println("Booking cancel..............");
		}
		else if(room instanceof SuiteRoom)
			reservation = null;
		System.out.println(room.makeReservation(reservation));
			System.out.println("Booking cancel..............");
	}
}
class ConferenceHall implements Reservable
{
	String hallName;
	ConferenceHall(String hallName){
		this.hallName = hallName;
	}
	public String makeReservation(Reservation reservation){
		System.out.println("*******************Do it Fast Few Reservation are left*******************");
		System.out.println("Enter a Hall name: "+hallName);
		return "Enter Booking Dates: "+reservation.getBookingDates();
	}
}
interface Reservable{
	public String makeReservation(Reservation reservation);
}

class Room implements Reservable{
	private int roomNumber;
	private String type; double price; String bookingDates;
	Room(int roomNumber, String type, double price, String bookingDates){
		this.roomNumber = roomNumber;
		this.type = type;
		this.price = price;
		this.bookingDates = bookingDates;
	}
	public String makeReservation(Reservation reservation){
		System.out.println("*******************Do it Fast Few Reservation are left*******************");
		System.out.println("Enter a name: "+reservation.getName());
		System.out.println("Enter allocated room number: "+reservation.getRoomNumber());
		System.out.println("Enter a Room type: "+reservation.getRoomType());
		System.out.println("Enter Room Price: "+reservation.getRoomPrice());
		return "Enter Booking Dates: "+reservation.getBookingDates();
	}
	
	public int getRoomNumber(){
		return roomNumber;
	}
	public String getRoomType(){
		return type;
	}
	public double getRoomPrice(){
		return price;
	}
	public String getBookingDates(){
		return bookingDates;
	}
}
class SingleRoom extends Room{
	SingleRoom(int roomNumber, String type, double price, String bookingDates){
		super(roomNumber,type, price, bookingDates);
	}
	//@Overide
	public String makeReservation(Reservation reservation){
		return "Room Number: "+getRoomNumber()+"\nRoom Type: "+getRoomType()+"\nPrice: "+getRoomPrice()+"\nBookDates"+getBookingDates();
	}
}
class SuiteRoom extends Room{
	String suiteAmenities;
	SuiteRoom(int roomNumber, String type, double price, String bookingDates){
		super(roomNumber,type,price,bookingDates);
	}
	public void setSuiteAmenities(String suiteAmenities){
		this.suiteAmenities = suiteAmenities;
	}
	@Override
		public String makeReservation(Reservation reservation){
					return "Room Number: "+reservation.getRoomNumber()+"\nRoom Type: "+reservation.getRoomType()+"\nPrice: "+reservation.getRoomPrice()+"\nBookDates"+reservation.getBookingDates()+"\nSuit Amenities: "+suiteAmenities;
		}
}

class Reservation{
	int roomNumber;
	String name, type; double price; String bookingDates;
	Reservation(int roomNumber,String name, String type, double price, String bookingDates){
		this.roomNumber = roomNumber;
		this.name = name;
		this.type = type;
		this.price = price;
		this.bookingDates = bookingDates;
	}
	public String getName(){
		return name;
	}
	public int getRoomNumber(){
		return roomNumber;
	}
	public String getRoomType(){
		return type;
	}
	public double getRoomPrice(){
		return price;
	}
	public String getBookingDates(){
		return bookingDates;
	}
}

class  HotelReservationSystem
{
	public static void main(String[] args) 
	{
		SingleRoom s1 =new SingleRoom(101, "Single", 1500, "17-Dec-24");
		SuiteRoom s2 = new SuiteRoom(101, "Suite", 4000, "17-Dec-24");
		s2.setSuiteAmenities("5Star");
		//int roomNumber,String name, String type, double price, String bookingDate
		Reservation r1 = new Reservation(101, "XYZ","Single", 1500, "17-Dec-24");
		Room room = new Room(101, "Rooms", 3000, "17-Dec-24");
		
		HotelBookingSystem h1 = new HotelBookingSystem();
		 h1.bookRoom(s1,r1);
		 System.out.println();
		 h1.cancelBooking(room,r1);
	}
}
