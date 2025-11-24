import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class InventoryItemTest {
InventoryItem inventoryItem = new InventoryItem("Audifonos", 4, 70000);
Exception exception= null;

@Test
   public void addStockTest(){
    inventoryItem.addStock(3);
    assertEquals(7,inventoryItem.getQuantity());
   }

@Test
   public void sellTest(){
   inventoryItem.sell(2);
   assertEquals(2,inventoryItem.getQuantity());
   }
@Test
   public void totalValueTest(){
      assertEquals(280000, inventoryItem.totalValue(),0.001);
   }
@Test
   public void negativeStockTest(){
      exception=assertThrows(IllegalArgumentException.class,()->{
         InventoryItem inventoryItemFailed= new InventoryItem("Arroz",-3,3000);
      });
   }
@Test
public void negativePriceTest(){
   exception=assertThrows(IllegalArgumentException.class, ()->{
      InventoryItem inventoryItemFailed = new InventoryItem("mouse gamer", 3, -50000);
   });
   }

@Test
public void addStockNegativeTest(){
   exception= assertThrows(IllegalArgumentException.class,()->{
      inventoryItem.addStock(-4);
   });

   }
@Test
public void sellNegativeTest(){
   exception=assertThrows(IllegalArgumentException.class,()->{
      inventoryItem.sell(-3);
   });
   }
@Test
public void sellMorteThanStockTest(){
   exception=assertThrows(IllegalStateException.class,()->{
      inventoryItem.sell(7);
   });
}
}
