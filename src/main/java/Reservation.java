import com.AppointmentCrud;
import com.AppointmentEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Reservation",value ="/Reservation" )
public class Reservation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentId");

        int slotId = Integer.parseInt(request.getParameter("slotId"));
        String staffId = request.getParameter("staffId");
        //Todo: return values are null
        PrintWriter out = response.getWriter();
        System.out.println("slotid"+ slotId);
        System.out.println("staffid" + staffId);
        System.out.println("studentId" + studentId);
        if (reserveApp(slotId, studentId, staffId)) {
            ///TODO: notify the user for the status of the process
            out.print("success");
        } else {
            out.print("Reservation failed!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private boolean reserveApp(int slotId, String studentId, String staffId) {
        boolean isInsert = false;
        AppointmentEntity appointment = new AppointmentEntity();
        appointment.setOfficeHourId(slotId);
        appointment.setStaffId(staffId);
        appointment.setStudentId(studentId);
        isInsert = AppointmentCrud.addAppointment(appointment);
        return isInsert;
    }
}
