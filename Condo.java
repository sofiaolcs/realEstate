/**
 * File: Condo.java
 * Description: subclass in the RealEstate package
 * Lessons Learned:
 * 		manually coding a class
 * 		private attributes
 * 		public constructors
 * 		public getters and setters
 * Instructor's Name: Jeff Light
 *
 * @author: Sofia Silva
 * @since: 6/5/2024
 */

package RealEstate;

public class Condo extends Residential {

    //attributes
    private int floorLvl;

    //constructors
    Condo() {
        super();
        floorLvl = 1;
    }

    Condo(String streetAddress, String zip, int bedCount, double bathCount, int sqFootage, int floorLvl) {
        super(streetAddress, zip, bedCount, bathCount, sqFootage);
        this.floorLvl = floorLvl;
    }

    //methods
    public int getFloorLvl() {
        return floorLvl;
    }

    public void setFloorLvl(int floorLvl) {
        this.floorLvl = floorLvl;
    }

    public double calculateAppraisalPrice() {
        double newAppraisalPrice = 88.0 * this.getSize() + 8000 * this.getBeds() + 10000 * this.getBaths();

        //+5000 if floor level is above level 1
        if (this.getFloorLvl() > 1) {
            newAppraisalPrice += 5000;
        }

        this.setAppraisalPrice(newAppraisalPrice);
        return this.getAppraisalPrice();
    }

    @Override
    public String toString() {
        String line1 = "-------------------------------------------------------------------------------------------------------";

        String address = String.format("%s%s", "Address: ", this.getStreetAddress());
        String zip = String.format("%s%s", "Zip Code: ", this.getZip());
        String line2 = String.format("%-40s%s%40s", "Residence Type: Condo", address, zip);

        String line3 = "-------------------------------------------------------------------------------------------------------";
        String line4to7 = String.format("%s%d\n%s%d\n%s%.1f\n%s%d", "Sq Footage: ", this.getSize(), "Bedrooms: ", this.getBeds(), "Bathrooms: ", this.getBaths(), "Floor: ", this.getFloorLvl());
        String line8 = "----------------------------------------";
        String line9 = String.format("%s$%,.2f", "Appraisal Price: ", this.getAppraisalPrice());
        String line10 = String.format("%s$%,.2f", "List Price: ", this.getListPrice());
        String line11 = "----------------------------------------";
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s", line1, line2, line3, line4to7, line8, line9, line10, line11);
    }

}//end of class
