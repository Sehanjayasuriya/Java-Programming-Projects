/*
 * Name: Sehan Madusha
 * StudentID: 106223861
 * File name: MovieScreen.java
 * 
 * Description: Cinema ticket reservation system using menu-driven program.
 */

import java.util.*; //importing scanner for user inputs

//ticket class
class Ticket {
  private static int idCounter = 1;
  private int ticketID;
  private int numberOfSeats;
  private String seats;

  //constructor
  public Ticket(int numberOfSeats, String seats) {
      this.ticketID = idCounter++;
      this.numberOfSeats = numberOfSeats;
      this.seats = seats;
  }

  public int getTicketID() {
      return ticketID;
  }

  //display ticket details
  public void printTicket() {
      System.out.println("Ticket ID: " + ticketID +
              " | Seats: " + seats +
              " | Total: $" + (numberOfSeats * 15));
  }
}


public class MovieScreen{
	
	// 2D array represents cinema seats
    static char[][] seats = new char[8][10];
    
    //storing reservations
    static Ticket[] tickets = new Ticket[80];
    
    //tracks no. of tickets
    static int ticketCount = 0;
    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); //user inputs

        // Initialize seats
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                seats[i][j] = 'O'; // 'O' is for available seats
            }
        }

        int choice;

        //menu loop
        do {
            System.out.println("1 – Reserve Tickets");
            System.out.println("2 – Show Current Availability");
            System.out.println("3 – Show Count of Availability");
            System.out.println("4 – Search Ticket");
            System.out.println("5 – Print All Tickets");
            System.out.println("6 – Exit");
            System.out.println("Please enter your choice");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    reserveTickets(input);
                    break;

                case 2:
                    showAvailability();
                    break;

                case 3:
                    showCount();
                    break;

                case 4:
                    searchTicket(input);
                    break;

                case 5:
                    printAllTickets();
                    break;
            }

        } while (choice != 6);
    }

    // reserve ticket method
    public static void reserveTickets(Scanner input) {

        System.out.println("Enter how many tickets you wish to reserve?");
        int num = input.nextInt(); //passing the input to num object

        //program restricts to maximum 10 tickets per time
        if (num > 10) {
            System.out.println("Sorry – Maximum 10 tickets can be reserved at a time.");
            return;
        }

        boolean allocated = false;

        //system keeps asking until valid allocation is done
        while (!allocated) {

            System.out.println("Do you wish the system to allocate the seats for you Y/N?");
            char option = input.next().charAt(0);

            if (option == 'Y' || option == 'y') {
                allocated = autoAllocate(num);
            } else {
                allocated = manualAllocate(input, num);
            }
        }
    }

    // auto allocation
    public static boolean autoAllocate(int num) {

        int allocated = 0;
        int firstRow = -1, firstCol = -1;
        int lastRow = -1, lastCol = -1;

        //loop through seats
        for (int i = 0; i < 8 && allocated < num; i++) {
            for (int j = 0; j < 10 && allocated < num; j++) {

            	//check availability whether the seats are empty or not
                if (seats[i][j] == 'O') {

                    if (allocated == 0) {
                        firstRow = i;
                        firstCol = j;
                    }

                    seats[i][j] = 'X'; // 'X' for reserved seats
                    allocated++;

                    lastRow = i;
                    lastCol = j;
                }
            }
        }

        if (allocated == num) {

            String seatRange = (char) ('A' + firstRow) + "" + (firstCol + 1)
                    + " to "
                    + (char) ('A' + lastRow) + "" + (lastCol + 1);

            tickets[ticketCount++] = new Ticket(num, seatRange);

            System.out.println("Your seats are allocated from " + seatRange);

            return true;
        }

        System.out.println("Sorry, no allocation can be made.");
        return false;
    }

    // manual allocation
    public static boolean manualAllocate(Scanner input, int num) {

        System.out.println("Please select the row & seat number that you wish to reserve your seats from: ");
        String startSeat = input.next();

        //convert input A to 0
        int row = startSeat.charAt(0) - 'A';
        //converts number
        int col = Integer.parseInt(startSeat.substring(1)) - 1;

        if (col + num > 10) {
            System.out.println("Sorry, no allocation can be made. Insufficient seats in the row");
            return false;
        }

        for (int i = col; i < col + num; i++) {
            if (seats[row][i] == 'X') {
                System.out.println("Sorry, no allocation can be made. Seats already taken.");
                return false;
            }
        }

        for (int i = col; i < col + num; i++) {
            seats[row][i] = 'X';
        }

        String seatRange = (char) ('A' + row) + "" + (col + 1)
                + " to "
                + (char) ('A' + row) + "" + (col + num);

        tickets[ticketCount++] = new Ticket(num, seatRange);

        System.out.println("Seats reserved. " + seatRange);

        return true;
    }
    
    //show availability - prints the seating table
    public static void showAvailability() {

        System.out.println("Current Availability");
        System.out.println("1 2 3 4 5 6 7 8 9 10");

        for (int i = 0; i < 8; i++) {
            System.out.print((char) ('A' + i) + " ");

            for (int j = 0; j < 10; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    //show count - counts available seats
    public static void showCount() {

        int count = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                if (seats[i][j] == 'O') {
                    count++;
                }
            }
        }

        System.out.println(count + " seats are available for reservation.");
    }

    //find tickets
    public static void searchTicket(Scanner input) {

        System.out.println("Enter Ticket ID:");
        int id = input.nextInt();

        for (int i = 0; i < ticketCount; i++) {
            if (tickets[i].getTicketID() == id) {
                tickets[i].printTicket();
                return;
            }
        }

        System.out.println("Ticket not found.");
    }
    
    //print all tickets
    public static void printAllTickets() {

        for (int i = 0; i < ticketCount; i++) {
            tickets[i].printTicket();
        }
    }
}
