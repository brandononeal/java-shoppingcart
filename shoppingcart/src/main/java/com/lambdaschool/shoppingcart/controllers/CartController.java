package com.lambdaschool.shoppingcart.controllers;

import com.lambdaschool.shoppingcart.models.CartItem;
import com.lambdaschool.shoppingcart.models.User;
import com.lambdaschool.shoppingcart.services.CartItemService;
import com.lambdaschool.shoppingcart.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class CartController
{
    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user",
        produces = {"application/json"})
    public ResponseEntity<?> listCartItemsByUserId()
    {
        String uname = SecurityContextHolder.getContext().getAuthentication().getName();
        User u = userService.findByName(uname);

        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @PutMapping(value = "/add/user/product/{productid}",
        produces = {"application/json"})
    public ResponseEntity<?> addToCart(
        @PathVariable
            long productid)
    {
        String uname = SecurityContextHolder.getContext().getAuthentication().getName();
        User u = userService.findByName(uname);

        CartItem addCartItem = cartItemService.addToCart(u.getUserid(),
            productid,
            "I am not working");
        return new ResponseEntity<>(addCartItem,
            HttpStatus.OK);
    }

    @DeleteMapping(value = "/remove/user/product/{productid}",
        produces = {"application/json"})
    public ResponseEntity<?> removeFromCart(
        @PathVariable
            long productid)
    {
        String uname = SecurityContextHolder.getContext().getAuthentication().getName();
        User u = userService.findByName(uname);

        CartItem removeCartItem = cartItemService.removeFromCart(u.getUserid(),
            productid,
            "I am still not working");
        return new ResponseEntity<>(removeCartItem,
            HttpStatus.OK);
    }
}
