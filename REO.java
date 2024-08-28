package RealEstate;

import java.util.*;

/**
 * File: Reo.java
 * Description: Run the RealEstate program with all its classes
 * Lessons Learned:
 * 	    classes
 * 	    inheritance
 * 	    formatting
 * 	    reading input
 * 	    loops
 * 	    methods
 * Instructor's Name: Jeff Light
 *
 * @author: Sofia Silva
 * @since: 7/17/2024
 */

public class REO {
    // Attributes
    private static final Listing reoListings = new Listing();
    static Scanner scanner = new Scanner(System.in);

    // Main method
    public static void main(String[] args) {
        boolean open = true;
        while (true) {
            mainMenu();
        }//end of while loop
    }//end of main

    // Main Menu method
    private static void mainMenu() {
        System.out.println("\n----------------------------------------");
        System.out.printf("%20s\n", "Main Menu");
        System.out.println("----------------------------------------");
        System.out.println("1: Listings");
        System.out.println("2: Bids");

        System.out.print("\nWhat would you like to do? (1-2): ");
        String choiceMenu = scanner.nextLine();

        switch (choiceMenu) {
            case "1":
                listingMenu();
                break;
            case "2":
                bidsMenu();
                break;
            default:
                System.out.println("\nInvalid choice, please try again.");
        }
    }//end of mainMenu method

    // Listing Menu method
    private static void listingMenu() {
        boolean done = false;
        while (!done) {
            System.out.println("\n----------------------------------------");
            System.out.printf("%20s\n", "Listing Menu");
            System.out.println("----------------------------------------");
            System.out.println("1: Add Listing");
            System.out.println("2: Show Listings");
            System.out.println("3: Auto Populate Listings (Dev tool)");
            System.out.println("ENTER: Exit back to previous menu");

            System.out.print("\nWhat would you like to do? (1-3): ");
            String choiceListing = scanner.nextLine();

            switch (choiceListing) {
                case "1":
                    addListing();
                    break;
                case "2":
                    showListings();
                    break;
                case "3":
                    autoPopulateListings();
                    break;
                case "":
                    done = true;
                    break;
                default:
                    System.out.println("\nInvalid choice, please try again.");
            }
        }
    }//end of listing

    // Bids Menu method
    private static void bidsMenu() {
        boolean done = false;
        while (!done) {
            System.out.println("\n----------------------------------------");
            System.out.printf("%20s\n", "Bids Menu");
            System.out.println("----------------------------------------");
            System.out.println("1: Add New Bid");
            System.out.println("2: Show Existing Bids");
            System.out.println("3: Auto Populate Bids (Dev Tool)");
            System.out.println("ENTER: Exit back to previous menu");

            System.out.print("\nWhat would you like to do? (1-3): ");
            String choiceBids = scanner.nextLine();

            switch (choiceBids) {
                case "1":
                    addBids();
                    break;
                case "2":
                    showBids();
                    break;
                case "3":
                    autoPopulateBids();
                    break;
                case "":
                    done = true;
                    break;
                default:
                    System.out.println("\nInvalid choice, please try again.");
            }
        }
    }//end of bids

    // Add Listing method
    private static void addListing() {
        boolean done = false;
        while (!done) {
            System.out.println("\n---------------------------------------");
            System.out.printf("%20s\n", "Add Listing Menu");
            System.out.println("-------------------------------------");
            System.out.println("1: Add House");
            System.out.println("2: Add Condo");
            System.out.println("ENTER: Exit back to previous menu");

            System.out.print("\nWhat would you like to do? (1-2): ");
            String choiceListing1 = scanner.nextLine();

            switch (choiceListing1) {
                case "1":
                    addHouse();
                    break;
                case "2":
                    addCondo();
                    break;
                case "":
                    done = true;
                    break;
                default:
                    System.out.println("\nInvalid choice, please try again.");
            }
        }
    }//end of addListing

    // Add Bids method
    private static void addBids() {
        boolean done = false;
        System.out.println("\nCurrent Listings for REO: \n");
        System.out.printf("%-10s%s", "No.", "Property (bids)");
        System.out.print("\n--------------------------------------");

        while (!done) {

            ArrayList<Residential> residences = new ArrayList<>(reoListings.getResidences());

            for (Residential residence : residences) {
                String address = residence.getStreetAddress();
                int bidsAmount = residence.getBidCount();
                System.out.printf("\n%d: %s (%d)", (residences.indexOf(residence) + 1), address, bidsAmount);
            }
            System.out.println("\nENTER: Exit back to previous menu");

            //choosing an option
            String choiceBids;
            boolean choiceValid = false;
            while (!choiceValid) {
                System.out.print("\nFor which property would you like to add a bid?: ");
                choiceBids = scanner.nextLine();

                if (choiceBids.isEmpty()) {
                    done = true;
                    choiceValid = true;
                } else {
                    try {
                        int choiceBidsInt = Integer.parseInt(choiceBids);
                        if (choiceBidsInt <= residences.size()) {
                            choiceValid = true;

                            //show listing
                            String address = (residences.get(choiceBidsInt - 1)).getStreetAddress();
                            Residential chosenResidence = reoListings.getListing(address);
                            System.out.println(chosenResidence);

                            //adding a bid
                            manualAddBid(chosenResidence);

                        } else {
                            System.out.println("Please enter a valid choice.");
                        }//end of if
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    }//end of try-catch
                }//enf of if
            }//end of while
        }//end of while !done
    }//end of addBids

    // Auto Populate Bids method
    private static void autoPopulateBids() {
        //random names
        String[] autoBidders = {"John Smith", "Jane Doe", "Michael Johnson", "Emily Davis", "William Brown",
                "Olivia Wilson", "James Taylor", "Sophia Miller", "Benjamin Anderson", "Isabella Thomas",
                "Matthew Jackson", "Charlotte White", "Daniel Harris", "Amelia Martin", "Alexander Thompson",
                "Mia Garcia", "Henry Martinez", "Evelyn Clark", "Samuel Rodriguez", "Abigail Lewis"};

        Random random = new Random();

        System.out.println();

        for (Residential residence : reoListings.getResidences()) {
            int maxCount = random.nextInt(10) + 1;
            for (int i = 1; i < maxCount; i++) {
                int index = random.nextInt((autoBidders.length - 1));
                double bidPrice = random.nextDouble(1, 2);
                residence.newBid(autoBidders[index], bidPrice * (residence.getAppraisalPrice()));
            }

            System.out.println(residence.getBidCount() + " new bid(s) have been added to listing " + residence.getStreetAddress());
        }
    }

    // Manually Add a bid method
    private static void manualAddBid(Residential chosenResidence) {
        System.out.print("\nPlease enter the name of the bidder: ");
        String bidder = scanner.nextLine();
        double value = (double) inputValidation("double", scanner, "Please enter the new bid: $", "Please enter a valid number.");
        chosenResidence.newBid(bidder, value);

        System.out.println("\nNew bid for property '" + chosenResidence.getStreetAddress() + "' added.");
    }

    // Show Bids method
    private static void showBids() {
        boolean done = false;
        System.out.println("\nCurrent Listings for REO: \n");
        System.out.printf("%-10s%s", "No.", "Property (bids)");
        System.out.print("\n--------------------------------------");

        while (!done) {
            ArrayList<Residential> residences = new ArrayList<>(reoListings.getResidences());

            for (Residential residence : residences) {
                String address = residence.getStreetAddress();
                int bidsAmount = residence.getBidCount();
                System.out.printf("\n%d: %s (%d)", (residences.indexOf(residence) + 1), address, bidsAmount);
            }
            System.out.println("\nENTER: Exit back to previous menu");

            //choosing an option
            String choiceBids;
            boolean choiceValid = false;
            while (!choiceValid) {
                System.out.print("\nFor which property would you like to see the current bids?: ");
                choiceBids = scanner.nextLine();

                if (choiceBids.isEmpty()) {
                    done = true;
                    choiceValid = true;
                } else {
                    try {
                        int choiceBidsInt = Integer.parseInt(choiceBids);
                        if (choiceBidsInt <= residences.size()) {
                            choiceValid = true;

                            //show listing
                            String address = (residences.get(choiceBidsInt - 1)).getStreetAddress();
                            Residential chosenResidence = reoListings.getListing(address);
                            System.out.println(chosenResidence);

                            //show bids for the listing
                            System.out.println("\nCurrent bids for this listing:");
                            System.out.println("---------------------------------------------");
                            System.out.printf("%6s%23s\n", "Bidder", "Bid");
                            System.out.println("---------------------------------------------");
                            for (String bidder : chosenResidence.getBidders()) {
                                System.out.printf("%-23s$%,.2f\n", bidder, chosenResidence.getBid(bidder));
                            }

                        } else {
                            System.out.println("Please enter a valid choice.");
                        }//end of if
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    }//end of try-catch
                }//enf of if
            }//end of while
        }//end of while !done
    }//end of showBids

    // Show Listings method
    private static void showListings() {
        boolean done = false;
        while (!done) {
            int listingNumber = 1;
            System.out.println("Current Listings for REO: \n");
            for (Residential residence : reoListings.getResidences()) {
                System.out.printf("\n%s%d\n", "Listing No: ", listingNumber++);
                System.out.println(residence);
            }
            done = true;
        }
    }

    // Add House method
    private static void addHouse() {
        boolean done = false;
        while (!done) {
            System.out.print("\nPlease enter the street address for the residence: ");
            String address = scanner.nextLine();
            System.out.print("Please enter the zip code for the residence: ");
            String zip = scanner.nextLine();
            int bedrooms = (int) inputValidation("int", scanner, "Please enter the number of bedrooms: ", "Please enter a whole number.");
            double bathrooms = (double) inputValidation("double", scanner, "Please enter the number of bathrooms: ", "Please enter a number.");
            int sqFt = (int) inputValidation("int", scanner, "Please enter the square footage of the residence: ", "Please enter a whole number.");
            double yardSize = (double) inputValidation("double", scanner, "Please enter the size of the yard in acres: ", "Please enter a number.");

            House house = new House(address, zip, bedrooms, bathrooms, sqFt, yardSize);
            reoListings.addListing(address, house);

            System.out.printf("%s$%,.2f", "Appraisal Price for this property is: ", house.calculateAppraisalPrice());
            double listPrice = (double) inputValidation("double", scanner, "\nPlease enter the List Price for the property: $", "Please enter a number.");
            house.setListPrice(listPrice);

            System.out.println("\nYou have created a new listing!");

            System.out.println(house);
            done = true;
        }
    }

    // Add Condo method
    private static void addCondo() {
        boolean done = false;
        while (!done) {
            System.out.print("\nPlease enter the street address for the residence: ");
            String address = scanner.nextLine();
            System.out.print("Please enter the zip code for the residence: ");
            String zip = scanner.nextLine();
            int bedrooms = (int) inputValidation("int", scanner, "Please enter the number of bedrooms: ", "Please enter a whole number.");
            double bathrooms = (double) inputValidation("double", scanner, "Please enter the number of bathrooms: ", "Please enter a number.");
            int sqFt = (int) inputValidation("int", scanner, "Please enter the square footage of the residence: ", "Please enter a whole number.");
            int floorLvl = (int) inputValidation("int", scanner, "Please enter the floor level of the condo: ", "Please enter a whole number.");

            Condo condo = new Condo(address, zip, bedrooms, bathrooms, sqFt, floorLvl);
            reoListings.addListing(address, condo);

            System.out.printf("%s$%,.2f", "Appraisal Price for this property is: ", condo.calculateAppraisalPrice());
            double listPrice = (double) inputValidation("double", scanner, "\nPlease enter the List Price for the property: $", "Please enter a number.");
            condo.setListPrice(listPrice);

            System.out.println("\nYou have created a new listing!");

            System.out.println(condo);
            done = true;
        }
    }

    // Auto populate Listings method
    private static void autoPopulateListings() {
        boolean done = false;
        while (!done) {
            int currentSize = reoListings.getListingCount();
            House house1 = new House("34 Elm", "95129", 3, 2, 2200, .2);
            house1.setListPrice(house1.calculateAppraisalPrice() * 1.1);
            reoListings.addListing("34 Elm", house1);
            House house2 = new House("42 Hitchhikers", "95136", 4, 3, 2800, .3);
            house2.setListPrice(house2.calculateAppraisalPrice() * 1.1);
            reoListings.addListing("42 Hitchhikers", house2);
            Condo condo1 = new Condo("4876 Industrial", "95177", 3, 1, 1800, 3);
            condo1.setListPrice(condo1.calculateAppraisalPrice() * 1.1);
            reoListings.addListing("4876 Industrial", condo1);
            House house3 = new House("2654 Oak", "84062", 5, 53, 4200, .5);
            house3.setListPrice(house3.calculateAppraisalPrice() * 1.1);
            reoListings.addListing("2654 Oak", house3);
            Condo condo2 = new Condo("9875 Lexington", "84063", 2, 1, 1500, 1);
            condo2.setListPrice(condo2.calculateAppraisalPrice() * 1.1);
            reoListings.addListing("9875 Lexington", condo2);
            Condo condo3 = new Condo("3782 Market", "84066", 3, 1, 1800, 2);
            condo3.setListPrice(condo3.calculateAppraisalPrice() * 1.1);
            reoListings.addListing("3782 Market", condo3);
            House house4 = new House("7608 Glenwood", "84055", 6, 3, 3900, .4);
            house4.setListPrice(house4.calculateAppraisalPrice() * 1.1);
            reoListings.addListing("7608 Glenwood", house4);
            House house5 = new House("1220 Apple", "84057", 8, 7, 7900, 1);
            house5.setListPrice(house5.calculateAppraisalPrice() * 1.1);
            reoListings.addListing("1220 Apple", house5);
            int newSize = reoListings.getListingCount();

            int newListingsCount = Math.abs(currentSize - newSize);

            System.out.println("\n" + newListingsCount + " residences have been added to the listings for testing purposes.");
            done = true;
        }
    }

    /**
     * Checks if the input is valid for whatever type the developer chooses: int or double
     */
    private static Object inputValidation(String type, Scanner sIn, String question, String exceptionMessage) {

        boolean done = false;
        Object userInput = null;

        do {
            System.out.print(question);
            String input = sIn.nextLine();
            try {
                if (type.equalsIgnoreCase("int")) {
                    userInput = Integer.parseInt(input);
                } else if (type.equalsIgnoreCase("double")) {
                    userInput = Double.parseDouble(input);
                }
                done = true;
            } catch (NumberFormatException e) {
                System.out.print(exceptionMessage);
            } //end of try catch
        } while (!done);

        return userInput;
    }

}//end of class REO
