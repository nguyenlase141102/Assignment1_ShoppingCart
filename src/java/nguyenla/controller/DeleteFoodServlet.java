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
import nguyenla.cart.CartDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class DeleteFoodServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            CartDTO cart = (CartDTO) session.getAttribute("recordFoodToDelete");
            List<FoodDTO> listDeleteFood = new ArrayList<>();

            //Add cart to list
            for (FoodDTO f : cart.getCartItem().values()) {
                listDeleteFood.add(f);
            }

            Random dice = new Random();
            String idHistory;

            //Delete Food and Add History
            for (FoodDTO f : listDeleteFood) {
                String idFoodDelete = f.getIdFood().trim();
                String nameFoodDelete = f.getNameFood().trim();
                idHistory = dice.nextInt(1000000) + "";
                if (FoodDAO.deleteFood("inactive", idFoodDelete)) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
                    Date dateTime = new Date(System.currentTimeMillis());
                    String currentDate = formatter.format(dateTime);
                    HistoryDTO his = new HistoryDTO(idFoodDelete, nameFoodDelete, "Delete", "Success", currentDate.trim());
                    if (his != null) {
                        HistoryDAO.addHistory(idHistory, nameFoodDelete, "Delete", currentDate.trim(), "success", idFoodDelete);
                    }
                }
            }

            //Load Home page
            session.removeAttribute("recordFoodToDelete");
            request.setAttribute("deleteFood","Yes");
            RequestDispatcher dis = request.getRequestDispatcher("LoadHomePage");
            dis.forward(request, response);

        }catch(SQLException ex){
            log("DeleteFoodServlet: "+ex.getMessage());
        }catch(NamingException ex){
            log("DeleteFoodServlet: "+ex.getMessage());
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
            Logger.getLogger(DeleteFoodServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(DeleteFoodServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DeleteFoodServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(DeleteFoodServlet.class.getName()).log(Level.SEVERE, null, ex);
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
