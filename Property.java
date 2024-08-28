/**
 * File: Property.java
 * Description: superclass in the RealEstate package
 * Lessons Learned:
 * 		manually coding a class
 * 		private attributes
 * 		public constructors
 * 		public getters and setters
 * Instructor's Name: Jeff Light
 *
 * @author: Sofia Silva
 * @since: 5/30/2024
 */

package RealEstate;

public abstract class Property {

    //attributes
    private String streetAddress;
    private String zip;
    private double listPrice = 0.0;
    private double appraisalPrice = 0.0;

    //constructors
    Property() {
        streetAddress = "";
        zip = "";
    }

    Property(String streetAddress, String zip) {
        this.streetAddress = streetAddress;
        this.zip = zip;
    }

    //methods
    public String getStreetAddress() {
        return streetAddress;
    }

    public String getZip() {
        return zip;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public double getAppraisalPrice() {
        return appraisalPrice;
    }

    protected void setAppraisalPrice(double appraisalPrice) {
        this.appraisalPrice = appraisalPrice;
    }

    public abstract double calculateAppraisalPrice();


}//end of class
