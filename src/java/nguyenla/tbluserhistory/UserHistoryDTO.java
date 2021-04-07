/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyenla.tbluserhistory;

/**
 *
 * @author ANH NGUYEN
 */
public class UserHistoryDTO {
    String nameUserHistory,dateUserHistory;
    int quantityUserHistory;
    float priceUserHistory;

    public UserHistoryDTO() {
    }

    public UserHistoryDTO(String nameUserHistory, String dateUserHistory, int quantityUserHistory, float priceUserHistory) {
        this.nameUserHistory = nameUserHistory;
        this.dateUserHistory = dateUserHistory;
        this.quantityUserHistory = quantityUserHistory;
        this.priceUserHistory = priceUserHistory;
    }

    public String getNameUserHistory() {
        return nameUserHistory;
    }

    public void setNameUserHistory(String nameUserHistory) {
        this.nameUserHistory = nameUserHistory;
    }

    public String getDateUserHistory() {
        return dateUserHistory;
    }

    public void setDateUserHistory(String dateUserHistory) {
        this.dateUserHistory = dateUserHistory;
    }

    public int getQuantityUserHistory() {
        return quantityUserHistory;
    }

    public void setQuantityUserHistory(int quantityUserHistory) {
        this.quantityUserHistory = quantityUserHistory;
    }

    public float getPriceUserHistory() {
        return priceUserHistory;
    }

    public void setPriceUserHistory(float priceUserHistory) {
        this.priceUserHistory = priceUserHistory;
    }

   

   

   
}
