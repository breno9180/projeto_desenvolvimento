//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import java.util.ArrayList;
//import java.util.List;
//
//public class FreightTest {
//    private List<Freight> freights;
//
//    @BeforeEach
//    public void setUp() {
//        freights = new ArrayList<>();
//    }
//
//    @Test
//    public void testCreateShippingSuccess() {
//        Freight freight = Freight.createShipping(freights, "F001", 1000, 150, "furgão");
//        assertEquals(1, freights.size());
//        assertEquals(600.0, freight.getValueShipping(), 0.01);
//        assertEquals(90.0, freight.getRate(), 0.01);
//    }
//
//    @Test
//    public void testCreateShippingDuplicateId() {
//        Freight.createShipping(freights, "F001", 1000, 150, "furgão");
//        assertThrows(IllegalArgumentException.class, () -> 
//            Freight.createShipping(freights, "F001", 500, 200, "caminhonete"));
//    }
//
//    @Test
//    public void testUpdateShippingSuccess() {
//        Freight.createShipping(freights, "F001", 1000, 150, "furgão");
//        Freight updatedFreight = Freight.updateShipping(freights, "F001", 2000, 300, "caminhão");
//        assertEquals(2000, updatedFreight.getWeight());
//        assertEquals(300, updatedFreight.getDistanceKm());
//        assertEquals(2700.0, updatedFreight.getValueShipping(), 0.01);
//    }
//
//    @Test
//    public void testDeleteShippingSuccess() {
//        Freight freight = Freight.createShipping(freights, "F001", 1000, 150, "furgão");
//        Freight.deleteShipping(freights, "F001");
//        assertEquals(0, freights.size());
//    }
//}
