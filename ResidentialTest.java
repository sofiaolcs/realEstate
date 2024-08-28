/**
 * File: ResidentialTest.java
 * Description: test the Residential class in the RealEstate package
 * Lessons Learned:
 * 	    test methods
 * 	    assertEquals
 * Instructor's Name: Jeff Light
 *
 * @author: Sofia Silva
 * @since: 6/5/2024
 */

package RealEstate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResidentialTest {

    @Test
    void getBeds() {
        Residential r = new House("14 Orange St", "84116", 2, 1.5, 900, .5);
        assertEquals(r.getBeds(), 2);
    }

    @Test
    void getBaths() {
        Residential r = new House("14 Orange St", "84116", 2, 1.5, 900, .5);
        assertEquals(r.getBaths(), 1.5);
    }

    @Test
    void getSize() {
        Residential r = new House("14 Orange St", "84116", 2, 1.5, 900, .5);
        assertEquals(r.getSize(), 900);
    }

    @Test
    void setBeds() {
        Residential r = new House("14 Orange St", "84116", 2, 1.5, 900, .5);
        r.setBeds(3);
        assertEquals(r.getBeds(), 3);
    }

    @Test
    void setBaths() {
        Residential r = new House("14 Orange St", "84116", 2, 1.5, 900, .5);
        r.setBaths(1);
        assertEquals(r.getBaths(), 1);
    }

    @Test
    void setSize() {
        Residential r = new House("14 Orange St", "84116", 2, 1.5, 900, .5);
        r.setSize(950);
        assertEquals(r.getSize(), 950);
    }
}
