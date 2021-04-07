    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyenla.tblfood;

import java.io.Serializable;

/**
 *
 * @author ANH NGUYEN
 */
public class FoodDTO implements Serializable {
    private String idFood,nameFood,imageFood,descriptionFood,createDateFood,categoryFood,statusFood;
    private int quantityFood;
    private float priceFood;
    
    public FoodDTO() {
    }

    public FoodDTO(String idFood, String nameFood, String imageFood, String descriptionFood, String createDateFood, String categoryFood, String statusFood, int quantityFood, float priceFood) {
        this.idFood = idFood;
        this.nameFood = nameFood;
        this.imageFood = imageFood;
        this.descriptionFood = descriptionFood;
        this.createDateFood = createDateFood;
        this.categoryFood = categoryFood;
        this.statusFood = statusFood;
        this.quantityFood = quantityFood;
        this.priceFood = priceFood;
    }

    public FoodDTO(String imageFood, String descriptionFood, String createDateFood, String categoryFood, String statusFood, int quantityFood, float priceFood) {
        this.imageFood = imageFood;
        this.descriptionFood = descriptionFood;
        this.createDateFood = createDateFood;
        this.categoryFood = categoryFood;
        this.statusFood = statusFood;
        this.quantityFood = quantityFood;
        this.priceFood = priceFood;
    }

    public FoodDTO(String idFood, String nameFood, String imageFood, float priceFood) {
        this.idFood = idFood;
        this.nameFood = nameFood;
        this.imageFood = imageFood;
        this.priceFood = priceFood;
    }

//    public FoodDTO(String idFood, String nameFood, String imageFood, String categoryFood, String statusFood, int quantityFood, float priceFood) {
//        this.idFood = idFood;
//        this.nameFood = nameFood;
//        this.imageFood = imageFood;
//        this.categoryFood = categoryFood;
//        this.statusFood = statusFood;
//        this.quantityFood = quantityFood;
//        this.priceFood = priceFood;
//    }

    public FoodDTO(String idFood, String nameFood, String imageFood, String createDateFood, String categoryFood, String statusFood, int quantityFood, float priceFood) {
        this.idFood = idFood;
        this.nameFood = nameFood;
        this.imageFood = imageFood;
        this.createDateFood = createDateFood;
        this.categoryFood = categoryFood;
        this.statusFood = statusFood;
        this.quantityFood = quantityFood;
        this.priceFood = priceFood;
    }

   

    

   

   
    
    public String getIdFood() {
        return idFood;
    }

    public void setIdFood(String idFood) {
        this.idFood = idFood;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public String getImageFood() {
        return imageFood;
    }

    public void setImageFood(String imageFood) {
        this.imageFood = imageFood;
    }

    public String getDescriptionFood() {
        return descriptionFood;
    }

    public void setDescriptionFood(String descriptionFood) {
        this.descriptionFood = descriptionFood;
    }

    public String getCreateDateFood() {
        return createDateFood;
    }

    public void setCreateDateFood(String createDateFood) {
        this.createDateFood = createDateFood;
    }

    public String getCategoryFood() {
        return categoryFood;
    }

    public void setCategoryFood(String categoryFood) {
        this.categoryFood = categoryFood;
    }

    public String getStatusFood() {
        return statusFood;
    }

    public void setStatusFood(String statusFood) {
        this.statusFood = statusFood;
    }

    public int getQuantityFood() {
        return quantityFood;
    }

    public void setQuantityFood(int quantityFood) {
        this.quantityFood = quantityFood;
    }

    public float getPriceFood() {
        return priceFood;
    }

    public void setPriceFood(float priceFood) {
        this.priceFood = priceFood;
    }

   

  

    
}
