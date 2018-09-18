package com.KFC.control;

import com.KFC.dao.GoodsDao;
import com.KFC.dao.impl.GoodsDaoImpl;
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
import java.util.Map;

@WebServlet(name = "DelCartServlet",urlPatterns = "/delCart")
public class DelCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GoodsService service=new GoodsServiceImpl();
        HttpSession session=request.getSession();
        int id=Integer.parseInt(request.getParameter("id"));//获取商品id
        Goods good=service.getGoodsById(id);
        Map<Goods,Integer > cart=(Map<Goods,Integer >) session.getAttribute("cart");
        Integer count=cart.put(good,1);
        if(count>1) {
            cart.put(good,count-1);  //这边返回旧值
        }
        else{
            cart.remove(good);
        }
        session.setAttribute("cart", cart);
        request.getRequestDispatcher("/jsp/cart.jsp").forward(request,response);
    }
}
