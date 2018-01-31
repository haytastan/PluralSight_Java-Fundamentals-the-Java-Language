package com.pluralsight.letsgetlogical;

public class Main {

    public static void main(String[] args) {
	    int students = 150;
        int rooms = 0;

        if(rooms > 0 && students/rooms > 30)
            // && conditional logical operator checks
            // if the left hand side condition is true before
            // checking the right hand side
            // so right hand side didn't execute
            System.out.println("Crowded!!");

        System.out.println();
        System.out.println("** end program **");
    }
}
