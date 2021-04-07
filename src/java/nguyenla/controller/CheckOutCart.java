/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyenla.controller;

import nguyenla.tblfood.FoodDAO;
import nguyenla.tblorder.OrderDAO;
import nguyenla.tblfood.FoodDTO;
import nguyenla.tbluserhistory.UserHistoryDTO;
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
import nguyenla.tbluserhistory.UserHistoryDAO;
import nguyenla.tblorderline.OrderLineDAO;

/**
 *
 * @author ANH NGUYEN
 */
public class CheckOutCart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String SUCCESS = "LoadHomePage";
    private final String ERROR = "ShoppingCart.jsp";
    private String url;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            /* TODO output your page here. You may use following sample code. */
            url = ERROR;
            HttpSession session = request.getSession();
          
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            List<FoodDTO> listFood = new ArrayList<>();
            String userID = (String) session.getAttribute("User");
            String paymentMethod = request.getParameter("cmbPayment");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date dateTime = new Date(System.currentTimeMillis());
            String currentDate = formatter.format(dateTime);
            Random dice = new Random();
            String orderString = dice.nextInt(1000000) + "";
            int orderID = Integer.parseInt(orderString);
            for (FoodDTO f : cart.getCartItem().values()) {
                listFood.add(f);
            }
            
            
            
            OrderDAO.addOrder(orderID, userID, paymentMethod, currentDate);
            for (FoodDTO f : listFood) {
                String idCart = f.getIdFood().trim();
                String nameCart = f.getNameFood().trim();
                int quantityCart = f.getQuantityFood();
                int quantityFood = FoodDAO.getQuantityFoodByID(idCart);
                Float price = f.getPriceFood();
                if (quantityFood >= quantityCart) {
                    FoodDAO.reduceQuantity(quantityFood, quantityCart, idCart);
                    //Add Order line
                    if (OrderLineDAO.addOrderLine(orderID, idCart, quantityCart, price)) {
                        //Add userHistory
                        if (UserHistoryDAO.addUserHistory(nameCart, quantityCart, price, currentDate, orderID,userID)) {
                            url = SUCCESS;
                            session.removeAttribute("CART");
                            request.setAttribute("confirmMess", "Buy Food to success!!");
                           
                        }
                    }

                } else {
                    request.setAttribute("outStock", nameCart + "out of stock!");
                }
            }

            List<UserHistoryDTO> listUserHistory = new ArrayList<>();
            listUserHistory = UserHistoryDAO.getUserHistory(userID);
            session.setAttribute("listUserHistory", listUserHistory);
            int subTotal = 0;
            for (FoodDTO f : cart.getCartItem().values()) {
                subTotal += f.getPriceFood()* f.getQuantityFood();
            }
           
            session.setAttribute("subTotal", subTotal);
            RequestDispatcher dis = request.getRequestDispatcher(url);
            dis.forward(request, response);
        }catch(SQLException ex){
            log("CheckOutCart: "+ex.getMessage());
        }catch(NamingException ex){
            log("CheckOutCart: "+ex.getMessage());
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
            Logger.getLogger(CheckOutCart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CheckOutCart.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CheckOutCart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CheckOutCart.class.getName()).log(Level.SEVERE, null, ex);
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
