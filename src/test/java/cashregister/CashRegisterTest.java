package cashregister;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CashRegisterTest {


    @Test
    public void should_print_the_real_purchase_when_call_process() {
        //given
        Printer printer = mock(Printer.class);
        Purchase purchase = mock(Purchase.class);
        CashRegister cashRegister = new CashRegister(printer);
        when(purchase.asString()).thenReturn("the message");

        //when
        cashRegister.process(purchase);

        //then
        verify(printer).print("the message");
    }

    @Test
    public void should_print_the_stub_purchase_when_call_process() {
        //given
        Printer printer = mock(Printer.class);
        Purchase purchase = mock(Purchase.class);
        CashRegister cashRegister = new CashRegister(printer);
        //when(purchase.asString()).thenReturn("the message");

        //when
        cashRegister.process(purchase);

        //then
        verify(purchase).asString();
    }

    @Test
    public void should_verify_with_process_call_with_mockito() {
        //given
        Printer printer = mock(Printer.class);
        Purchase purchase = mock(Purchase.class);
        CashRegister cashRegister = new CashRegister(printer);
        when(purchase.asString()).thenReturn("the message");

        //when
        cashRegister.process(purchase);

        //then
        verify(printer).print("the message");
        
    }
    @Test
    public void should_return_item_name_and_price_when_asSting_given_mock_item() {
    	Item item1 = mock(Item.class);
    	Item item2 = mock(Item.class);
    	Item[] items = {item1,item2};
    	Purchase purchase = new Purchase(items);
    	
    	
    	purchase.asString();
    	
    	
    	verify(item1).getName();
    	verify(item1).getPrice();
    	verify(item2).getName();
    	verify(item2).getPrice();
    	
    	
    	
    	
    	
    }
    @Test
    public void should_return_item_name_and_price_string_when_asSting_given_mock_item() {
    	Item item1 = mock(Item.class);
    	Item item2 = mock(Item.class);
    	Item[] items = {item1,item2};
    	Purchase purchase = new Purchase(items);
    	when(item1.getName()).thenReturn("apple");
    	when(item1.getPrice()).thenReturn(1.0);
    	when(item2.getName()).thenReturn("orange");
    	when(item2.getPrice()).thenReturn(2.0);
    	
    	
    	
    	String result = purchase.asString();
    	
    	assertEquals(result, "apple\t1.0\norange\t2.0\n");
    	
    	

    	
    	
    	
    	
    	
    }

}
