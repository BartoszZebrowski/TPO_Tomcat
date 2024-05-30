package com.example.tomcat;

import java.io.*;
import java.net.URL;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "CarServlet", value = "/CarServlet")
public class CarServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String carType = request.getParameter("type");

        if (carType == null || carType.isEmpty())
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Zły typ samochodu");

        request.setAttribute("type", carType);
        RequestDispatcher dispatcher = request.getRequestDispatcher("CarSearchServlet");
        dispatcher.forward(request, response);
    }
}