package com.lambdaschool.shoppingcart.services;

import com.lambdaschool.shoppingcart.ShoppingCartApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShoppingCartApplication.class)
public class CartItemServiceImplTest
{
    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void addToCart()
    {
    }

    @Test
    public void removeFromCart()
    {
    }
}