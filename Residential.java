/**
 * File: Residential.java
 * Description: superclass/subclass in the RealEstate package
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

import java.util.HashMap;
import java.util.Set;

public abstract class Residential extends Property implements Biddable {

    //attributes
    private int bedCount;
    private double bathCount;
    private int sqFootage;
    HashMap<String, Double> bids;

    //constructors
    Residential() {
        super();
        bedCount = 0;
        bathCount = 0.0;
        sqFootage = 0;
        bids = new HashMap<>();
    }

    Residential(String streetAddress, String zip, int bedCount, double bathCount, int sqFootage) {
        super(streetAddress, zip);
        this.bedCount = bedCount;
        this.bathCount = bathCount;
        this.sqFootage = sqFootage;
        bids = new HashMap<>();
    }

    //methods
    public int getBeds() {
        return bedCount;
    }

    public double getBaths() {
        return bathCount;
    }

    public int getSize() {
        return sqFootage;
    }

    public void setBeds(int bedCount) {
        this.bedCount = bedCount;
    }

    public void setBaths(double bathCount) {
        this.bathCount = bathCount;
    }

    public void setSize(int sqFootage) {
        this.sqFootage = sqFootage;
    }

    public abstract double calculateAppraisalPrice();

    public HashMap<String, Double> getBids(){
        return bids;
    }

    public double getBid(String bidder){
        return bids.get(bidder);
    }

    public Set<String> getBidders(){
        return bids.keySet();
    }

    public int getBidCount(){
        return bids.size();
    }

    public void newBid(String bidder, Double value){
        bids.putIfAbsent(bidder, value);
    }

}//end of class
