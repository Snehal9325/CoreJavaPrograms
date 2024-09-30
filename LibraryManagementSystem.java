/*
1. Library Management System:
Scenario: You are tasked with designing a basic library management system for a public library. This system will manage various types of library 
items and support different operations related to these items.

Requirements:

Encapsulation: Create classes Book and Member with private fields to store the details such as title, author, and member name. Provide public getter 
and setter methods to access and modify these fields.
Inheritance: Design a base class LibraryItem that includes common properties (e.g., ID, title) and methods for library items. Extend this class to 
create Book and Magazine classes, adding specific attributes (e.g., author for Book, issue number for Magazine).
Polymorphism: Implement a method displayInfo() in the LibraryItem class to display details. Override this method in the Book and Magazine classes 
to provide specific information about each item.
Abstraction: Define an abstract class Library with abstract methods addItem(LibraryItem item) and removeItem(LibraryItem item). Create a concrete 
class PublicLibrary that extends Library and implements these methods to manage the addition and removal of items from the library.
*/
class LibraryItem {
	private int id;
	private String title;
	LibraryItem(String title, int id){
		this.id = id;
		this.title = title;
	}
	public int getId(){
		System.out.print("Id Of Book: ");
		return id;
	}
	public String getTitle(){
		return "Title Of Book: "+title;
	}
	
	public void displayInfo(){
		System.out.println("Id of Book: "+id);
		System.out.println("Title of Book: "+title);
	}
}
class Book extends LibraryItem {
	private String author,memberName;
	Book( int id,String title,String author,String memberName){
		super(title, id);
		this.author = author;
		this.memberName = memberName;
	}
	
	public String getAuthor(){
		return "Author of Book: "+author;
	}
	public String getMemberName(){
		return "Name of Member: "+memberName;
	}
	@Override
	public void displayInfo(){
		System.out.println("Id of Book: "+getId());
		System.out.println("Title of Book: "+getTitle());
		System.out.println("Author of Book: "+author);
		System.out.println("Name of Member: "+memberName);
	}
}
class Magazine extends LibraryItem{
	private String author;
	private int noOfMagazine;
	Magazine( int id,String title, String author, int noOfMagazine){
		super(title, id);
		this.author = author;
		this.noOfMagazine = noOfMagazine;
	}
	
	public String getAuthor(){
		return "Author of Book: "+author;
	}
	
	public int getNoOfMagazine(){
		return noOfMagazine;
	}
	@Override
	public void displayInfo(){
		System.out.println("Id of Magazine: "+getId());
		System.out.println("Title of Magazine: "+getTitle());
		System.out.println("Author of Magazine: "+author);
		System.out.println("No. of Magazine "+noOfMagazine);
	}
}
abstract class Library{
	public abstract void addItem(LibraryItem item);
	public abstract void removeItem(LibraryItem item);
}
class PublicLibrary extends  Library{
	public void addItem(LibraryItem item){
		if(item instanceof Book){
			 LibraryItem item1 = item;	
			 System.out.println("Book is added to library");
		}
		else if(item instanceof Magazine){
				LibraryItem item1 = item;
				System.out.println("Magazine is added to library");
		}
		else System.out.println("Invalid Item....");
	}
	public void removeItem(LibraryItem item){
		if(item instanceof Book){
			 LibraryItem item1 = null;	
			 System.out.println("Book is removed from library");
		}
		else if(item instanceof Magazine){
				LibraryItem item1 = null;
				System.out.println("Magazine is removed from library");
		}
		else System.out.println("Invalid Item....");
	}
}
class  LibraryManagementSystem
{
	public static void main(String[] args) 
	{
		//String title,String author,String memberName,int id
		//String title, int id, String author, int noOfMagazin
		Book b1 = new Book(101, "Java","James Gosling", "JG");
		Magazine m1 = new Magazine(101,"Java","James Gosling",10);
		b1.displayInfo();
		System.out.println();
		m1.displayInfo();
		System.out.println();
		PublicLibrary p1 = new PublicLibrary();
		p1. addItem(b1);
		p1. addItem(m1);
		System.out.println();
		p1.removeItem(b1);
		p1.removeItem(m1);
	}
}
