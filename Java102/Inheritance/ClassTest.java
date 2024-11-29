package Java102.Inheritance;

import java.util.ArrayList;

public class ClassTest {

    public static void main(String[] args) {
        // Create an array of LibraryItem objects
        LibraryItem[] items = new LibraryItem[] {
            new Book("1984", "B001", "George Orwell", 328),
            new Book("To Kill a Mockingbird", "B002", "Harper Lee", 281),
            new DVD("Inception", "D001", 148.0),
            new DVD("The Matrix", "D002", 136.0)
        };

        // Display the items
        System.out.println("Library Items:");
        for (LibraryItem item : items) {
            System.out.println(item);
        }

        // Check out a few items
        System.out.println("\nChecking out items...");
        items[0].checkOut(); // Check out the first book
        items[2].checkOut(); // Check out the first DVD

        // Display available items
        System.out.println("\nAvailable items:");
        ArrayList<LibraryItem> available = LibraryItem.availableItems(items);
        for (LibraryItem item : available) {
            System.out.println(item);
        }

        // Return all items
        System.out.println("\nReturning all items...");
        LibraryItem.returnAll(items);

        // Display the status of all items after returning
        System.out.println("\nItems after returning:");
        for (LibraryItem item : items) {
            System.out.println(item.title + " is available: " + item.available());
        }
    }
}
