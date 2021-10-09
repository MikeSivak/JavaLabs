package com.example.lab03;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Ggg", value = "/Ggg")
public class Ggg extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Ggg Servlet: -- GET request --");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        response.setContentType("text/html");

        PrintWriter pw = response.getWriter();
        pw.println("<html><body>" +
                "<h1>Hello, I'm Ggg servlet</h1>" +
                "<p>First Name: " +
                firstName + "</p>" +
                "<p>Last Name: " +
                lastName + "</p>" +
                "</body></html>");
        System.out.println("Ggg Servlet: -- called from Sss servlet --");
//        RequestDispatcher rd = request.getRequestDispatcher("/page.html");
//        rd.forward(request,response);
//        response.sendRedirect("/lab03-1.0-SNAPSHOT/page.html");
//        System.out.println("Ggg Servlet: -- redirected to page.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Ggg Servlet: -- POST request --");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        response.setContentType("text/html");

//        PrintWriter pw = response.getWriter();
//        pw.println("<html><body>" +
//                "<h1>Hello, I'm Ggg servlet</h1>" +
//                "<p>First Name: " +
//                firstName + "</p>" +
//                "<p>Last Name: " +
//                lastName + "</p>" +
//                "</body></html>");
//        System.out.println("Ggg Servlet: -- called from Sss servlet --");

        PrintWriter pw = response.getWriter();
        pw.println("<html><body>" +
                "<h1>Hello, I'm Ggg servlet</h1>" +
                "<p>First Name: " +
                firstName + "</p>" +
                "<p>Last Name: " +
                lastName + "</p>" +
                "</body></html>");
        System.out.println("Ggg Servlet: -- called from Sss servlet --");
    }
}
