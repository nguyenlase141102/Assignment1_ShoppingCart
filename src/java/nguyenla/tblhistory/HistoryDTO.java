/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyenla.tblhistory;


/**
 *
 * @author ANH NGUYEN
 */
public class HistoryDTO {
     String idHistory,nameHistory,actionHistory,statusHistory,dateHistory;
    public HistoryDTO() {
    }

    public HistoryDTO(String idHistory, String nameHistory, String actionHistory, String statusHistory, String dateHistory) {
        this.idHistory = idHistory;
        this.nameHistory = nameHistory;
        this.actionHistory = actionHistory;
        this.statusHistory = statusHistory;
        this.dateHistory = dateHistory;
    }

    public HistoryDTO(String idHistory, String nameHistory, String actionHistory, String dateHistory) {
        this.idHistory = idHistory;
        this.nameHistory = nameHistory;
        this.actionHistory = actionHistory;
        this.dateHistory = dateHistory;
    }

    public String getIdHistory() {
        return idHistory;
    }

    public void setIdHistory(String idHistory) {
        this.idHistory = idHistory;
    }

    public String getNameHistory() {
        return nameHistory;
    }

    public void setNameHistory(String nameHistory) {
        this.nameHistory = nameHistory;
    }

    public String getActionHistory() {
        return actionHistory;
    }

    public void setActionHistory(String actionHistory) {
        this.actionHistory = actionHistory;
    }

    public String getStatusHistory() {
        return statusHistory;
    }

    public void setStatusHistory(String statusHistory) {
        this.statusHistory = statusHistory;
    }

    public String getDateHistory() {
        return dateHistory;
    }

    public void setDateHistory(String dateHistory) {
        this.dateHistory = dateHistory;
    }


    

  
}
