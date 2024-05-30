package com.example.tomcat;

import com.example.tomcat.models.Car;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CarPresentServlet", value = "/CarPresentServlet")
public class CarPresentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Car> cars = (ArrayList<Car>)request.getAttribute("cars");

        request.setAttribute("cars", cars);
        request.setAttribute("type", cars.get(0).Type);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/mojaStrona.jsp");
        dispatcher.forward(request, response);
    }
}
