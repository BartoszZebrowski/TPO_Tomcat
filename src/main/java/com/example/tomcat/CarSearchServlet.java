package com.example.tomcat;

import com.example.tomcat.models.Car;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


@WebServlet(name = "CarSearchServlet", value = "/CarSearchServlet")
public class CarSearchServlet extends HttpServlet {

    String url = "jdbc:sqlserver://(localdb)\\Local;databaseName=Cars;integratedSecurity=true;encrypted=true;trustServerCertificate=true";
    String sql = "SELECT * FROM Cars Where Type = ?";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try (Connection connection = DriverManager.getConnection(url);
            PreparedStatement statement = connection.prepareStatement(sql);) {

            String carType = request.getParameter("type");
            statement.setString(1, carType);

            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet == null){
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Taki typ samochodu nie istnieje");
                    return;
                }

                ArrayList<Car> cars = new ArrayList<Car>();

                while (resultSet.next()) {
                    Car car = new Car(resultSet.getInt("Id"),
                            resultSet.getString("Type"),
                            resultSet.getString("Brand"),
                            resultSet.getInt("ProductionYear"),
                            resultSet.getInt("LitersPerHundredKms"));

                    cars.add(car);
                }

                request.setAttribute("cars", cars);

                RequestDispatcher dispatcher = request.getRequestDispatcher("CarPresentServlet");
                dispatcher.forward(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
