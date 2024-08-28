/**
 * File: PropertyTest.java
 * Description: test the Property class in the RealEstate package
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

class PropertyTest {

    @Test
    void getStreetAddress() {
        Property p = new House("14 Orange St", "84116", 2, 1.5, 900, .5);
        assertEquals(p.getStreetAddress(), "14 Orange St");
    }

    @Test
    void getZip() {
        Property p = new House("14 Orange St", "84116", 2, 1.5, 900, .5);
        assertEquals(p.getZip(), "84116");
    }

    @Test
    void setStreetAddress() {
        Property p = new House("14 Orange St", "84116", 2, 1.5, 900, .5);
        p.setStreetAddress("111 Tancredo Neves Avenue");
        assertEquals(p.getStreetAddress(), "111 Tancredo Neves Avenue");
    }

    @Test
    void setZip() {
        Property p = new House("14 Orange St", "84116", 2, 1.5, 900, .5);
        p.setZip("1234");
        assertEquals(p.getZip(), "1234");
    }

    @Test
    void getAppraisalPrice() {
        Property p = new House("14 Orange St", "84116", 2, 1.5, 900, .5);
        assertEquals(p.getAppraisalPrice(), 0.0);
    }

    @Test
    void setAppraisalPrice() {
        Property p = new House("14 Orange St", "84116", 2, 1.5, 900, .5);
        p.setAppraisalPrice(100000);
        assertEquals(p.getAppraisalPrice(), 100000);
    }
}