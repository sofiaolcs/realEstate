/**
 * File: HouseTest.java
 * Description: test the House class in the RealEstate package
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

class HouseTest {

    @Test
    void getYardAcres() {
        House h = new House("14 Orange St", "84116", 2, 1.5, 900, .5);
        assertEquals(h.getYardAcres(), .5);
    }

    @Test
    void setYardAcres() {
        House h = new House("14 Orange St", "84116", 2, 1.5, 900, 2);
        h.setYardAcres(1);
        assertEquals(h.getYardAcres(), 1);
    }

    @Test
    void calculateAppraisalPrice() {
        House h = new House("14 Orange St", "84116", 2, 1.5, 900, 2.4);
        h.calculateAppraisalPrice();
        assertEquals(h.getAppraisalPrice(), 1045300);
    }
}