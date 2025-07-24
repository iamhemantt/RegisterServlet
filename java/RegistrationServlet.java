import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class RegistrationServlet extends HttpServlet {

    List<User> users = new ArrayList<User>();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h2> Register User </h2>");

        if (users.isEmpty()){
            out.println("<p>No Users Found!</p>");
        }
        else{

            out.println("<ul>");

            for (User user:users){
                out.println("<li>"+user.getName()+ " - "+user.getEmail()+"</li>");
            }
            out.println("</ul>");
        }
        out.println("<a href='index.html'> Back to Registration Page</a>");
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        users.add(new User(name,email));
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h2> Registration Successful </h2>");
        out.println("<p> Name : " + name + "</p>");
        out.println("<p> Email : " + email + "</p>");
        out.println("<a href='register'>View All Registered Users</a><br>");
        out.println("<a href='index.html'>Back</a>");


    }
}


class User{
    private String name;
    private String email;

    User(String name, String email){
        this.name =name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
