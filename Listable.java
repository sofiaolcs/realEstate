package RealEstate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public interface Listable {
    HashMap<String, Residential> getListings();

    Residential getListing(String address);

    Set<String> getStreetAddresses();

    Collection<Residential> getResidences();

    int getListingCount();

    void addListing(String address, Residential value);


}
