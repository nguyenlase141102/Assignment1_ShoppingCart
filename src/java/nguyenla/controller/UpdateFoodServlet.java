/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyenla.controller;

import nguyenla.tblfood.FoodDAO;
import nguyenla.tblhistory.HistoryDAO;
import nguyenla.tblfood.FoodDTO;
import nguyenla.tblhistory.HistoryDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ANH NGUYEN
 */
public class UpdateFoodServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String HOMEPAGE = "LoadHomePage";
    private final String ERROR = "UpdateFood.jsp";
    String url;
    String typeError;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        url = ERROR;
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            String idUpdate = request.getParameter("id");
            String nameUpdate = request.getParameter("name");
            String imageUpdate = request.getParameter("image");
            String descriptionUpdate = request.getParameter("desc");
            String dateUpdate = request.getParameter("createDate");
            String categoryUpdate = request.getParameter("category");
            String statusUpdate = request.getParameter("status");
            String quantityUpdate = request.getParameter("quantity");
            String priceUpdate = request.getParameter("price");

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dateTime = new Date(System.currentTimeMillis());
            String currentDate = formatter.format(dateTime);

            HistoryDTO his = new HistoryDTO(idUpdate, nameUpdate, "Update", "Success", currentDate.trim());
            HttpSession session = request.getSession(true);
            String idData = (String) session.getAttribute("idFirst");

            Random dice = new Random();
            String idHistory = dice.nextInt(1000000) + "";

            if (!nguyenla.validation.Valid.checkEmpty(idUpdate.trim())) {
                typeError = "Id Food not empty!!";
            } else if (!nguyenla.validation.Valid.checkEmpty(nameUpdate.trim())) {
                typeError = "Name Food not empty!!";
            } else if (!nguyenla.validation.Valid.checkEmpty(imageUpdate.trim())) {
                typeError = "Image Food not empty!!";
            } else if (!nguyenla.validation.Valid.checkEmpty(descriptionUpdate.trim())) {
                typeError = "Description Food not empty!!";
            } else if (!nguyenla.validation.Valid.checkEmpty(dateUpdate.trim())) {
                typeError = "Date Food not empty!!";
            } else if (!nguyenla.validation.Valid.checkEmpty(categoryUpdate.trim())) {
                typeError = "Category Food not empty!!";
            } else if (!nguyenla.validation.Valid.checkEmpty(statusUpdate.trim())) {
                typeError = "Status Food not empty!!";
            } else if (!nguyenla.validation.Valid.checkEmpty(quantityUpdate.trim())) {
                typeError = "Quantity Food not empty!!";
            } else if (!nguyenla.validation.Valid.checkEmpty(priceUpdate.trim())) {
                typeError = "Price Food not empty!!";
            } else if (!nguyenla.validation.Valid.checkSpecialCharac(idUpdate)) {
                typeError = "ID doesn't contain special character!!";
            } else if (!nguyenla.validation.Valid.checkSpecialCharac(nameUpdate)) {
                typeError = "Name doesn't contain special character!!";
            } else if (!nguyenla.validation.Valid.checkSpecialCharac(descriptionUpdate)) {
                typeError = "Description doesn't contain special character!!";
            } else if (!nguyenla.validation.Valid.checkSpecialCharac(categoryUpdate)) {
                typeError = "Category doesn't contain special character!!";
            } else if (!nguyenla.validation.Valid.checkSpecialCharac(statusUpdate)) {
                typeError = "Status doesn't contain special character!!";
            } else if (!nguyenla.validation.Valid.checkSpecialCharac(quantityUpdate)) {
                typeError = "Quantity doesn't contain special character!!";
            } else if (!nguyenla.validation.Valid.checkPrice(priceUpdate)) {
                typeError = "Price must be float number!!";
            } else if (!nguyenla.validation.Valid.checkDate(dateUpdate)) {
                typeError = "Date format yyyy-mm--dd !!";
            } else if (!idData.trim().equals(idUpdate.trim())) {
                if (FoodDAO.getFoodByIDs(idUpdate) != null) {
                    typeError = "Duplicated Code !!";
                }
            } else if (!nguyenla.validation.Valid.checkInteger(quantityUpdate)) {
                typeError = "Quantity must be integer!!";
            } else {
                float priceFood = Float.parseFloat(priceUpdate);
                int quantityFood = Integer.parseInt(quantityUpdate);
                FoodDTO food = new FoodDTO(idUpdate, nameUpdate, imageUpdate, descriptionUpdate, dateUpdate, categoryUpdate, statusUpdate, quantityFood, priceFood);
                if (FoodDAO.updateFood(food)) {
                    if (HistoryDAO.addHistory(idHistory, nameUpdate.trim(), "Update", currentDate.trim(), "success", idUpdate.trim())) {
                        url = HOMEPAGE;
                    }
                }
            }

            List<FoodDTO> list = new ArrayList<>();

            request.setAttribute("idUpdate", idUpdate);
            request.setAttribute("nameUpdate", nameUpdate);
            request.setAttribute("imageUpdate", imageUpdate);
            request.setAttribute("descriptionUpdate", descriptionUpdate);
            request.setAttribute("dateUpdate", dateUpdate);
            request.setAttribute("categoryUpdate", categoryUpdate);
            request.setAttribute("statusUpdate", statusUpdate);
            request.setAttribute("quantityUpdate", quantityUpdate);
            request.setAttribute("priceUpdate", priceUpdate);

            request.setAttribute("errorUpdate", typeError);
            RequestDispatcher dis = request.getRequestDispatcher(url);
            dis.forward(request, response);

        }catch(SQLException ex){
            log("UpdateFoodServlet: "+ex.getMessage());
        }catch(NamingException ex){
            log("UpdateFoodServlet: "+ex.getMessage());
        }finally{
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception e) {
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception e) {
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
