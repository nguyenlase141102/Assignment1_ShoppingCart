/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyenla.controller;

import nguyenla.tblfood.FoodDAO;
import nguyenla.tblfood.FoodDTO;
import nguyenla.cart.CartDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nguyenla.validation.Valid;

/**
 *
 * @author ANH NGUYEN
 */
public class UpdateCartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String SHOPPINGCART = "ShoppingCart.jsp";
    private String url;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            String amountCartFood = request.getParameter("amount").trim();
            String hiddenID = request.getParameter("hiddenID");
            int newQuantity = Integer.parseInt(amountCartFood);

            CartDTO cartUpdate = (CartDTO) session.getAttribute("CART");

            if (newQuantity > 0 || Valid.checkInteger(amountCartFood)) {

                FoodDTO updateCartFood = null;
                List<FoodDTO> listFood = new ArrayList<>();
                for (FoodDTO f : cartUpdate.getCartItem().values()) {
                    if (f.getIdFood().equals(hiddenID)) {
                        int quantityCart = f.getQuantityFood();
                        int quantityFood = FoodDAO.getQuantityFoodByID(hiddenID);
                        if (quantityFood >= newQuantity) {
                            updateCartFood = new FoodDTO(f.getIdFood(), f.getNameFood(), f.getImageFood(), f.getDescriptionFood(), f.getCreateDateFood(), f.getCategoryFood(), f.getStatusFood(), newQuantity, f.getPriceFood());
                            cartUpdate.updateCart(hiddenID, updateCartFood);
                            break;
                        } else {
                            request.setAttribute("outStock", f.getNameFood() + "out of stock!");
                        }

                    }
                }
                
            } else {
                request.setAttribute("amountMess", "Quantity must be positive number and >0!! ");
            }

            // sub Total
            int subTotal = 0;
            for (FoodDTO f : cartUpdate.getCartItem().values()) {
                subTotal += f.getPriceFood() * f.getQuantityFood();
            }
            url = SHOPPINGCART;

            session.setAttribute("subTotal", subTotal);
            RequestDispatcher dis = request.getRequestDispatcher(url);
            dis.forward(request, response);
        }catch(SQLException ex){
            log("UpdateCartServlet: "+ex.getMessage());
        }catch(NamingException ex){
            log("UpdateCartServlet: "+ex.getMessage());
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
            Logger.getLogger(UpdateCartServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(UpdateCartServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UpdateCartServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(UpdateCartServlet.class.getName()).log(Level.SEVERE, null, ex);
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
