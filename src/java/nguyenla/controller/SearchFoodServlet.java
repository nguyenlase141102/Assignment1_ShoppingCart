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

/**
 *
 * @author ANH NGUYEN
 */
public class SearchFoodServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String SEARCHPAGE = "SearchFood.jsp";
    private final String HOMEPAGE = "LoadHomePage";
    private String url;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
            /* TODO output your page here. You may use following sample code. */
            url = SEARCHPAGE;
            String searchFind = request.getParameter("txtSearch");
            String indexString = request.getParameter("index");
            String category = request.getParameter("categoryFood");
            String from = request.getParameter("fromPrice");
            String to = request.getParameter("toPrice");
            float fromPrice;
            float toPrice;
            int index;
            if (indexString == null) {
                index = 1;
            } else {
                index = Integer.parseInt(indexString);
            }

            int pageSize = 8;
            int countFood = 0;
            int endPage;

            
            
            List<FoodDTO> listSearch = new ArrayList<>();
//                List<FoodDTO> listCategory = new ArrayList<>();
            List<FoodDTO> listResult = new ArrayList<>();
            if (searchFind.equals("") && !from.equals("") && !to.equals("")) {
                fromPrice = Float.parseFloat(from);
                toPrice = Float.parseFloat(to);
                countFood = FoodDAO.countCategory(category, fromPrice, toPrice, "active");
            } else if (from.equals("") && to.equals("") && !searchFind.equals("")) {
                countFood = FoodDAO.countNotPrice(category, searchFind, "active");
            } else if (from.equals("") && to.equals("") && searchFind.equals("")) {
                countFood = FoodDAO.countOnlyCategory(category, "active");
            } else {
                fromPrice = Float.parseFloat(from);
                toPrice = Float.parseFloat(to);
                countFood = FoodDAO.countFood(searchFind, "active", fromPrice, toPrice, category);
            }

            endPage = countFood / pageSize;
            if (countFood % pageSize != 0) {
                endPage++;
            }
           
            if (searchFind.equals("") && !from.equals("") && !to.equals("")) {
                fromPrice = Float.parseFloat(from);
                toPrice = Float.parseFloat(to);
                listSearch = FoodDAO.searchByCategory(category, index, fromPrice, toPrice, "active");
                listResult = listSearch;

            } else if (from.equals("") && to.equals("") && !searchFind.equals("")) {

                listSearch = FoodDAO.searchNotPrice(category.trim(), searchFind.trim(), "active", index);
                listResult = listSearch;

            } else if (from.equals("") && to.equals("") && searchFind.equals("")) {

                listSearch = FoodDAO.searchOnlyCategory(category,"active", index);
                listResult = listSearch;

            } else {
                System.out.println("cai cuoi");
                fromPrice = Float.parseFloat(from);
                toPrice = Float.parseFloat(to);
                listSearch = FoodDAO.searchFood(searchFind, index, category, fromPrice, toPrice, "active");
                listResult = listSearch;
            }

            request.setAttribute("saveCategory", category);
            request.setAttribute("listFoodHomePage", listSearch);
            request.setAttribute("end", endPage);
            request.setAttribute("txtSearch", searchFind);
            request.setAttribute("from", from);
            request.setAttribute("to", to);
            request.setAttribute("index", index);
            RequestDispatcher dis = request.getRequestDispatcher(url);
            dis.forward(request, response);

        }catch(SQLException ex){
            log("SearchFoodServlet: "+ex.getMessage());
        }catch(NamingException ex){
            log("SearchFoodServlet: "+ex.getMessage());
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
            Logger.getLogger(SearchFoodServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(SearchFoodServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SearchFoodServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(SearchFoodServlet.class.getName()).log(Level.SEVERE, null, ex);
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
