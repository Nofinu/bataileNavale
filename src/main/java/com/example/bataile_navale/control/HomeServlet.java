package com.example.bataile_navale.control;

import java.io.*;

import com.example.bataile_navale.util.Definition;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "homeServlet", value = "/")
public class HomeServlet extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher(Definition.PATH_VIEW+"Home.jsp").forward(request,response);
    }

    public void destroy() {
    }
}