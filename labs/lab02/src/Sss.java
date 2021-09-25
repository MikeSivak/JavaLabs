import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GoSss")
public class Sss extends HttpServlet {
    public void init(ServletConfig sc) throws ServletException{
        super.init();
        System.out.println("Sss: init");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Sss: destroy");
    }

//    @Override
//    protected void service(HttpServletRequest rq, HttpServletResponse rs)throws  ServletException, IOException{
//        System.out.println("Sss: service: " + rq.getMethod());
//
//        PrintWriter pw = rs.getWriter();
//        pw.println("<html><body>"
//                + "<h2>Sss: service with method - " + rq.getMethod() + "</h2>"
//                + "<h3>ServerName: " + rq.getServerName() + "</h3>"
//                + "<h3>LocalAddr: " + rq.getLocalAddr() + "</h3>"
//                + "<h3>Query: " + rq.getQueryString() + "</h3>"
//                + "<br>Sss: FirstName = " + rq.getParameter("firstname")
//                + "<br>Sss: LastName = " + rq.getParameter("lastname")
//                + "</body></html>");
//    }



    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        rs.setContentType("text/html");
        PrintWriter pw = rs.getWriter();
        pw.println("<html><body>"
                + "<br>Ppp:doPost:firstname = " + rq.getParameter("firstname")
                + "<br>Ppp:doPost:lastname = " + rq.getParameter("lastname")
                + "</body></html>");
        pw.close();
    }

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        rs.setContentType("text/html");
        PrintWriter pw = rs.getWriter();
        pw.println("<html><body>"
                +"<br>Sss: FirstName = " + rq.getParameter("firstname")
                +"<br>Sss: LastName = " + rq.getParameter("lastname")
                +"<br>Sss: getRemoteHost: " + rq.getQueryString()
                +"</body></html>");
        pw.close();
    }
}
