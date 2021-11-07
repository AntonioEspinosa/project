package account.checkout.creditcard;


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class ExpiredCreditCardTest {

    @Test
    public void beyondBalanceTest(){
        assertEquals(1,2);
    }

    @Test
    public void wrongDateTest(){
        assertEquals(1,1);
    }


}
