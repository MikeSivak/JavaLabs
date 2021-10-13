import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;

@WebServlet(name = "Jjj", urlPatterns = "/jjj")
public class Jjj extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        if(req.getMethod().contains("POST")) {
            this.doPost(req, res);

        }else if(req.getMethod().contains("GET")) {
            System.out.println("Jjj:doGet");

//                this.doPost(req,res);
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int c;  // char value for each symbol of answer from .jsp

            String page = hour < 6 ? "night.jsp" : hour < 12 ? "morning.jsp" : hour < 18 ? "afternoon.jsp" : "evening.jsp";

            //Get method - Task 11
//            ServletContext servletContext = getServletContext();
//            String path = "/pages/".concat(page);
//            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
//            requestDispatcher.forward(req, res);
//            System.out.println("forwared to '" + page + "' page");
//            res.sendRedirect("http://localhost:8080/lab_04/pages/".concat(page));
//            System.out.println("redirected to '" + page + "' page");

            //Post request in Get
            HttpClient hc = new HttpClient();
            PostMethod pm = new PostMethod("http://localhost:8080/lab_04/pages/".concat(page));
            hc.executeMethod(pm);
            PrintWriter pw = res.getWriter();
            pw.println(pm.getResponseBodyAsString());
            pw.flush();
            System.out.println("Make Post request from Get");
    }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Jjj:doGet");
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int c;  // char value for each symbol of answer from .jsp

        String page = hour < 6 ? "night.jsp" : hour < 12 ? "morning.jsp" : hour < 18 ? "afternoon.jsp" : "evening.jsp";

        URL url = new URL("http://localhost:8080/lab_04/pages/".concat(page));
        URLConnection connection = url.openConnection();

        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setUseCaches(false);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        InputStream input = connection.getInputStream();
        StringBuilder result = new StringBuilder();

        while((c = input.read()) != -1) {
            result.append((char) c);
        }
        input.close();

        Document document = Jsoup.parse(result.toString());
        String body = document.body().html();

        response.getWriter()
                .append(body);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Jjj:doPost");
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int c;  // char value for each symbol of answer from .jsp

        String page = hour < 6 ? "night.jsp" : hour < 12 ? "morning.jsp" : hour < 18 ? "afternoon.jsp" : "evening.jsp";

        URL url = new URL("http://localhost:8080/lab_04/pages/".concat(page));
        URLConnection connection = url.openConnection();

        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setUseCaches(false);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        InputStream input = connection.getInputStream();
        StringBuilder result = new StringBuilder();

        while((c = input.read()) != -1) {
            result.append((char) c);
        }
        input.close();

        Document document = Jsoup.parse(result.toString());
        String body = document.body().html();

        response.getWriter()
                .append(body);
    }
}
