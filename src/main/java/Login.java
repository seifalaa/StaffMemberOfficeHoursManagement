import com.StaffMemberCrud;
import com.StaffmemberEntity;
import com.StudentCrud;
import com.StudentEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/Login", value = "/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String type = request.getParameter("login_type");
        String password = request.getParameter("password");
        if (type.equals("Student")) {
            StudentEntity student = StudentCrud.findStudent(request.getParameter("id"));
            System.out.println(student.getStudentId());
            if (student != null) {
                if (password.equals(student.getStudentPassword())) {
                    //Redirect to student profile
                    System.out.println("hello student");
                } else {
                    out.print("Incorrect password!");
                }
            } else {
                out.print("There is no account matching these credientils!");
            }
        } else if (type.equals("Staff member")) {
            StaffmemberEntity staff = StaffMemberCrud.findStaffMember(request.getParameter("id"));
            if (staff != null) {
                if (password.equals(staff.getStaffPassword())) {
                    //Redirect to staff profile
                    System.out.println("hello staff");
                } else {
                    out.print("Incorrect password!");
                }
            } else {
                out.print("There is no account matching these credientils!");
            }
        }
    }
}


