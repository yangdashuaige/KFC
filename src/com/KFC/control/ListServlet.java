package com.KFC.control;

import com.KFC.pojo.Goods;
import com.KFC.service.GoodsService;
import com.KFC.service.Impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListServlet",urlPatterns = "/List")
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GoodsService service= new GoodsServiceImpl();
        HttpSession session=request.getSession();
        List<Goods> goodsList=service.getAllGoods();
        request.setAttribute("goodsList",goodsList);
        request.getRequestDispatcher("/jsp/list2.jsp").forward(request,response);


    }
}
