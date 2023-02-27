package com.spring.henallux.firstSpringProject.junit;
import com.spring.henallux.firstSpringProject.model.CartItem;
import org.junit.*;
public class CartItemTest {
    private CartItem cartItem;


    @Before
    public void setUp(){
        this.cartItem = new CartItem();
    }

    @Test
    public void setQuantityBelowOne() {
        cartItem.setQuantity(-1);
        Assert.assertEquals(1, cartItem.getQuantity());

        cartItem.setQuantity(0);
        Assert.assertEquals(1, cartItem.getQuantity());
    }
}
