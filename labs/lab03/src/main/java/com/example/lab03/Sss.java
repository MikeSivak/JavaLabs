package com.example.lab03;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Sss", value = "/Sss")
public class Sss extends HttpServlet {
    protected void service (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        System.out.println("Sss Servlet: -- Called service method --");
        if(request.getMethod().equals("POST")){
            System.out.println("Sss Servlet: -- POST request --");

//            response.setContentType("text/html");
            String firstName = request.getParameter("firstname");
            String lastName = request.getParameter("lastname");

            //Task (2)
//            PrintWriter pw = response.getWriter();
//            pw.println("<html><body>" +
//                    "<p>First Name: " +
//                    firstName + "</p>" +
//                    "<p>Last Name: " +
//                    lastName + "</p>" +
//                    "</body></html>");

//            RequestDispatcher rd = request.getRequestDispatcher("/Ggg");
//            rd.forward(request,response);
            HttpClient hc = new HttpClient();
            PostMethod pm = new PostMethod("http://localhost:8080/lab03-1.0-SNAPSHOT/Ggg");

            pm.addParameter("firstname", firstName);
            pm.addParameter("lastname", lastName);

            NameValuePair[] nameValuePairs = {
                    new NameValuePair("firstname", firstName),
                    new NameValuePair("lastname", lastName)
            };

            pm.setRequestBody(nameValuePairs);
            hc.executeMethod(pm);
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            pw.println(pm.getResponseBodyAsString());
            pw.flush();

//            System.out.println("Sss Servlet: -- called Ggg Servlet --");

//            response.sendRedirect("/lab03-1.0-SNAPSHOT/Ggg");
        }
        else if(request.getMethod().equals("GET")){
            System.out.println("Sss Servlet: -- Get request --");

            response.setContentType("text/html");
            String firstName = request.getParameter("firstname");
            String lastName = request.getParameter("lastname");

//            PrintWriter pw = response.getWriter();
//            pw.println("<html><body>" +
//                    "<p>First Name: " +
//                    firstName + "</p>" +
//                    "<p>Last Name: " +
//                    lastName + "</p>" +
//                    "</body></html>");

//            RequestDispatcher rd = request.getRequestDispatcher("/Ggg");
//            rd.forward(request,response);
            System.out.println("Sss Servlet: -- called Ggg Servlet --");

//            RequestDispatcher rd = request.getRequestDispatcher("/page.html");
//            rd.forward(request,response);

//            response.sendRedirect("/lab03-1.0-SNAPSHOT/page.html");
            StringBuilder buffer = new StringBuilder();
            BufferedReader br = request.getReader();
            String line;
            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }
            String data = buffer.toString();
            response.getWriter().println("Sss GET data: " + data);
            response.sendRedirect("/lab03-1.0-SNAPSHOT/Ggg?firstname=Mike&lastname=Sivak");

        }

//        HttpClient hc = new HttpClient();
////        GetMethod gm = new GetMethod("http://localhost:8080/lab03-1.0-SNAPSHOT/Sss?firstname=Mike&lastname=Sivak");
//        PostMethod pm = new PostMethod("http://localhost:8080/lab03-1.0-SNAPSHOT/Sss");
//
//        pm.addParameter("firstname", "Mike");
//        pm.addParameter("lastname", "Sivak");
//
//        NameValuePair[] nameValuePairs = {
//                new NameValuePair("firstname", "Mike"),
//                new NameValuePair("lastname", "Sivak")
//        };
//
//        pm.setRequestBody(nameValuePairs);
////        hc.executeMethod(gm);
//        hc.executeMethod(pm);
//        response.setContentType("text/html");
//        PrintWriter pw = response.getWriter();
////        pw.println(gm.getResponseBodyAsString());
//        pw.println(pm.getResponseBodyAsString());
//        pw.flush();

    }

    //Task (1)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Sss Servlet: -- Get request --");

        response.setContentType("text/html");

        PrintWriter pw = response.getWriter();
        pw.println("<html><body>" +
                "<h1>Hello, I'm Sss servlet</h1>" +
                "</body></html>");

        RequestDispatcher rd = request.getRequestDispatcher("/Ggg");
        rd.forward(request,response);

        //response.sendRedirect("/lab03-1.0-SNAPSHOT/Ggg?firstname=Mike&lastname=Sivak");
        System.out.println("Sss Servlet: -- called Ggg Servlet --");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.println("<html><body><h1>BSTU</h1></body></html>");
    }
}
