package com.spring.henallux.firstSpringProject.junit;
import com.spring.henallux.firstSpringProject.model.Cart;
import org.junit.*;
public class CartTest {
    private Cart cart;

    @Before
    public void setUp(){
        cart = new Cart();
    }

    @Test
    public void totalPriceFormat(){
        cart.setTotalPrice(9.909);
        Assert.assertEquals(9.91, cart.getTotalPrice(), 0.001);
    }
}
