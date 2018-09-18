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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AddCartServlet",urlPatterns = "/addCart")
public class AddCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session=request.getSession();
        if(session.getAttribute("uname")!=null)
        {
            //表明是登录状态
            GoodsService service=new GoodsServiceImpl();
            int id=Integer.parseInt(request.getParameter("id"));
            Goods goods=service.getGoodsById(id);
            Map<Goods,Integer> cart=(Map<Goods,Integer>)session.getAttribute("cart");
            if(cart==null)
            {
                cart=new HashMap<Goods,Integer>();
            }
            //向购物车添加数量信息
/*            Integer count=cart.put(goods,1);
            if(count!=null)
            {
                cart.put(goods,count+1);
            }*/
            if(cart.containsKey(goods))
            {
                Integer value=cart.get(goods)+1;
                cart.put(goods,value);
            }
            else{
                Integer i=1;
                cart.put(goods,i);
            }
            session.setAttribute("cart",cart);
            request.getRequestDispatcher("/List").forward(request,response);
        }
        else{
            //未登录
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }


    }
}
