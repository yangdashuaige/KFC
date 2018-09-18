package com.KFC.control;

import com.KFC.pojo.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "ClearCartServlet",urlPatterns = "/clearCart")
public class ClearCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession();
        Map<Goods,Integer> cart= (Map<Goods, Integer>) session.getAttribute("cart");
        cart.clear();
        session.setAttribute("cart",cart);
        request.getRequestDispatcher("/jsp/clearCart.jsp").forward(request,response);
    }
}
