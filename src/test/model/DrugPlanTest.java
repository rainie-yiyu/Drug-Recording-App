package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrugPlanTest {
    private DrugPlan newDrugPlan;

    @BeforeEach
    void runBefore() {
        newDrugPlan = new DrugPlan("yiyu's drugplan");
    }

    @Test
    void testDrugPlanSize() {
        assertEquals(0,newDrugPlan.length());
    }

    @Test
    void testAddDrug() {
        Drug d1 = new Drug("metformin", Category.METFORMIN);
        Drug d2 = new Drug("Jentadueto",Category.SULFONYLUREAS);
        newDrugPlan.addDrug(d1);
        newDrugPlan.addDrug(d2);
        assertEquals(2,newDrugPlan.length());
        assertEquals(d2,newDrugPlan.getDrugPlan(1));
    }

    @Test
    void testDeletDrug() {
        Drug d1 = new Drug("metformin", Category.METFORMIN);
        Drug d2 = new Drug("Jentadueto", Category.SULFONYLUREAS);
        newDrugPlan.addDrug(d1);
        newDrugPlan.addDrug(d2);
        newDrugPlan.deleteDrug(d2);
        assertEquals(d1,newDrugPlan.getDrugPlan(0));
        assertEquals(1,newDrugPlan.length());

    }


    @Test
    void testlengh() {
        assertEquals(0,newDrugPlan.length());
        Drug d1 = new Drug("metformin",  Category.METFORMIN);
        newDrugPlan.addDrug(d1);
        assertEquals(1,newDrugPlan.length());
    }

    @Test
    void testGetDrugPlan() {
        Drug d1 = new Drug("metformin",  Category.METFORMIN);
        Drug d2 = new Drug("Jentadueto", Category.SULFONYLUREAS);
        newDrugPlan.addDrug(d1);
        newDrugPlan.addDrug(d2);
        assertEquals(d1,newDrugPlan.getDrugPlan(0));
        assertEquals(d2,newDrugPlan.getDrugPlan(1));


    }


}
