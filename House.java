/**
 * File: House.java
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

public class House extends Residential {

    //attributes
    private double yardAcres;

    //constructors
    House() {
        super();
        yardAcres = 0.0;
    }

    House(String streetAddress, String zip, int bedCount, double bathCount, int sqFootage, double yardAcres) {
        super(streetAddress, zip, bedCount, bathCount, sqFootage);
        this.yardAcres = yardAcres;
    }

    //methods
    public double getYardAcres() {
        return yardAcres;
    }

    public void setYardAcres(double yardAcres) {
        this.yardAcres = yardAcres;
    }

    public double calculateAppraisalPrice() {
        double newAppraisalPrice = 97.0 * this.getSize() + 10000 * this.getBeds() + 12000 * this.getBaths() + 460000 * Math.floor(this.getYardAcres());
        this.setAppraisalPrice(newAppraisalPrice);
        return this.getAppraisalPrice();
    }

    @Override
    public String toString() {
        String line1 = "-------------------------------------------------------------------------------------------------------";

        String address = String.format("%s%s", "Address: ", this.getStreetAddress());
        String zip = String.format("%s%s", "Zip Code: ", this.getZip());
        String line2 = String.format("%-40s%s%40s", "Residence Type: House", address, zip);
        String line3 = "-------------------------------------------------------------------------------------------------------";
        String line4to7 = String.format("%s%d\n%s%d\n%s%.1f\n%s%,.2f", "Sq Footage: ", this.getSize(), "Bedrooms: ", this.getBeds(), "Bathrooms: ", this.getBaths(), "Yard Size (Acres): ", this.getYardAcres());
        String line8 = "----------------------------------------";
        String line9 = String.format("%s$%,.2f", "Appraisal Price: ", this.getAppraisalPrice());
        String line10 = String.format("%s$%,.2f", "List Price: ", this.getListPrice());
        String line11 = "----------------------------------------";
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s", line1, line2, line3, line4to7, line8, line9, line10, line11);
    }


}//end of class
