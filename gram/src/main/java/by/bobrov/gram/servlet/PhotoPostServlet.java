package by.bobrov.gram.servlet;

import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PhotoPostServlet extends HttpServlet {

    @Override
    protected void doPost(
            final HttpServletRequest request,
            final HttpServletResponse response
    ) throws ServletException, IOException {
        if (request.getServletPath().equals("/check")) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success", "true");
            String string = jsonObject.toString();
            response.getOutputStream().println(string);
        }
    }
    @Override
    protected void doGet(
            final HttpServletRequest request,
            final HttpServletResponse response
    ) throws ServletException, IOException {
        System.out.println(request.getServletPath());
        switch (request.getServletPath()) {
            case "/status":
                response.getOutputStream().println("Application Is Running");
                break;
            case "/get":
                String name = request.getParameter("name");
                response.getOutputStream().println("Name is " + name);
                break;
            case "/page":
                request.getRequestDispatcher("/page.html")
                        .forward(request,response);
                break;
        }
    }
}
