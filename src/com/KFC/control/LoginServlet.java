package com.KFC.control;

import com.KFC.dao.UserDao;
import com.KFC.dao.impl.UserDaoImpl;
import com.KFC.pojo.Goods;
import com.KFC.pojo.User;
import com.KFC.service.Impl.UserServiceImpl;
import com.KFC.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService service=new UserServiceImpl();
        HttpSession session=request.getSession();
        String pwd=request.getParameter("pwd");
        String nickname=request.getParameter("username");
        User user=service.login(nickname,pwd);
        if(user!=null)
        {
            //表明登录成功
            session.setAttribute("uname",user.getNickName());
            HashMap<Goods,Integer> cart=new HashMap<>();
            session.setAttribute("cart",cart);
            request.getRequestDispatcher("/List").forward(request,response);
        }
        else{
            request.setAttribute("error",1);
            //登录不成功
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }
}
