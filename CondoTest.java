/**
 * File: CondoTest.java
 * Description: test the Condo class in the RealEstate package
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

class CondoTest {

    @Test
    void getFloorLvl() {
        Condo c = new Condo("14 Orange St", "84116", 2, 1.5, 900, 3);
        assertEquals(c.getFloorLvl(), 3);
    }

    @Test
    void setFloorLvl() {
        Condo c = new Condo("14 Orange St", "84116", 2, 1.5, 900, 3);
        c.setFloorLvl(4);
        assertEquals(c.getFloorLvl(), 4);
    }

    @Test
    void calculateAppraisalPrice() {
        Condo c = new Condo("14 Orange St", "84116", 2, 1.5, 900, 3);
        c.calculateAppraisalPrice();
        assertEquals(c.getAppraisalPrice(), 115200);
    }

    @Test
    void calculateAppraisalPriceLevel1() {
        Condo c = new Condo("14 Orange St", "84116", 2, 1.5, 900, 1);
        c.calculateAppraisalPrice();
        assertEquals(c.getAppraisalPrice(), 110200);
    }
}