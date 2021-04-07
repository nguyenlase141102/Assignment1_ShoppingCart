/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyenla.cart;

import nguyenla.tblfood.FoodDTO;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ANH NGUYEN
 */
public class CartDTO implements Serializable{
    private Map<String,FoodDTO> cart;
    private String customerName, paymentMethod;

    public CartDTO() {
    }

    public CartDTO(Map<String, FoodDTO> cartItem, String customerName, String paymentMethod) {
        this.cart = cartItem;
        this.customerName = customerName;
        this.paymentMethod = paymentMethod;
    }

    public Map<String, FoodDTO> getCartItem() {
        return cart;
    }

    public void setCartItem(Map<String, FoodDTO> cartItem) {
        this.cart = cartItem;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
    public void addCart(FoodDTO dto){
        if(this.cart == null){
            this.cart = new HashMap<String, FoodDTO>();
        }
        if(this.cart.containsKey(dto.getIdFood())){
            int quantity = this.cart.get(dto.getIdFood()).getQuantityFood();
            dto.setQuantityFood(quantity+1);
        }
        cart.put(dto.getIdFood(), dto);
    }
    
    public void deleteCart(String id){
        if(cart == null){
            return;
        }
        if(this.cart.containsKey(id)){
            cart.remove(id);
        }
    }
    
    public void updateCart(String id, FoodDTO dto){
        if(this.cart!=null){
            if(this.cart.containsKey(id)){
                this.cart.replace(id, dto);
            }
        }
    }
}
