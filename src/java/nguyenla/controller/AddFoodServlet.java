/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyenla.controller;

import nguyenla.tblfood.FoodDAO;
import nguyenla.tblfood.FoodDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ANH NGUYEN
 */
public class AddFoodServlet extends HttpServlet {

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
    private final String ERROR = "AddFood.jsp";
    String typeError;
    String url;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            /* TODO output your page here. You may use following sample code. */
            url = ERROR;
            String idFood = request.getParameter("id");
            String nameFood = request.getParameter("name");
            String imageFood = request.getParameter("image");
            String descriptionFood = request.getParameter("desc");
            String categoryFood = request.getParameter("category");
            String quantityStringFood = request.getParameter("quantity");
            String priceStringFood = request.getParameter("price");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
            Date dateTime = new Date(System.currentTimeMillis());
            String currentDate = formatter.format(dateTime);

            if (!nguyenla.validation.Valid.checkEmpty(idFood)) {
                typeError = "Id Food not empty!!";
            } else if (!nguyenla.validation.Valid.checkEmpty(nameFood)) {
                typeError = "Name Food not empty!!";
            } else if (!nguyenla.validation.Valid.checkEmpty(imageFood.trim())) {
                typeError = "Image Food not empty!!";
            } else if (!nguyenla.validation.Valid.checkEmpty(descriptionFood.trim())) {
                typeError = "Description Food not empty!!";
            } else if (!nguyenla.validation.Valid.checkEmpty(categoryFood.trim())) {
                typeError = "Category Food not empty!!";
            } else if (!nguyenla.validation.Valid.checkEmpty(quantityStringFood.trim())) {
                typeError = "Quantity Food not empty!!";
            } else if (!nguyenla.validation.Valid.checkEmpty(priceStringFood.trim())) {
                typeError = "Price Food not empty!!";
            } else if (!nguyenla.validation.Valid.checkSpecialCharac(idFood)) {
                typeError = "ID doesn't contain special character!!";
            } else if (!nguyenla.validation.Valid.checkSpecialCharac(nameFood)) {
                typeError = "Name doesn't contain special character!!";
            } else if (!nguyenla.validation.Valid.checkSpecialCharac(descriptionFood)) {
                typeError = "Description doesn't contain special character!!";
            } else if (!nguyenla.validation.Valid.checkSpecialCharac(categoryFood)) {
                typeError = "Category doesn't contain special character!!";
            } else if (!nguyenla.validation.Valid.checkSpecialCharac(quantityStringFood)) {
                typeError = "Quantity doesn't contain special character!!";
            } else if (!nguyenla.validation.Valid.checkPrice(priceStringFood)) {
                typeError = "Price must be float number!!";
            } else if (FoodDAO.getFoodByIDs(idFood) != null) {
                typeError = "Duplicated Code !!";
            } else if (!nguyenla.validation.Valid.checkInteger(quantityStringFood)) {
                typeError = "Quantity must be integer!!";
            } else {
                Float priceFood = Float.parseFloat(priceStringFood.trim());
                int quantityFood = Integer.parseInt(quantityStringFood.trim());
                FoodDTO foodNew = new FoodDTO(idFood, nameFood, imageFood, descriptionFood, currentDate, categoryFood, "active", quantityFood, priceFood);
                if (FoodDAO.addFood(foodNew)) {
                    url = HOMEPAGE;
                } else {
                    typeError = "Add fail !!";
                }
            }

            request.setAttribute("idAdd", idFood);
            request.setAttribute("nameAdd", nameFood);
            request.setAttribute("imageAdd", imageFood);
            request.setAttribute("descriptionAdd", descriptionFood);
            request.setAttribute("categoryAdd", categoryFood);
            request.setAttribute("quantityAdd", quantityStringFood);
            request.setAttribute("priceAdd", priceStringFood);
            request.setAttribute("errorAdd", typeError);
            
            RequestDispatcher dis = request.getRequestDispatcher(url);
            dis.forward(request, response);
        }catch(SQLException ex){
            log("AddFoodServlet: "+ex.getMessage());
        }catch(NamingException ex){
            log("AddFoodServlet: "+ex.getMessage());
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
        } catch (SQLException ex) {
            Logger.getLogger(AddFoodServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(AddFoodServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(AddFoodServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(AddFoodServlet.class.getName()).log(Level.SEVERE, null, ex);
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
