package RealEstate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Listing implements Listable {
    private final HashMap<String, Residential> listings;

    public Listing() {
        listings = new HashMap<>();
    }

    public HashMap<String, Residential> getListings(){
        return listings;
    }

    public Residential getListing(String address){
        return listings.get(address);
    }

    public Set<String> getStreetAddresses(){
        return listings.keySet();
    }

    public Collection<Residential> getResidences(){
        return listings.values();
    }

    public int getListingCount(){
        return listings.size();
    }

    public void addListing(String address, Residential value){
        listings.put(address, value);
    }
}
