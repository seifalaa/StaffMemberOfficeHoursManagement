import com.AppointmentCrud;
import com.AppointmentEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Reservation")
public class Reservation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int slotId=Integer.parseInt(request.getParameter("slotId"));
        String studentId=request.getParameter("studentId");
        String staffId=request.getParameter("staffId");
        if(resreveApp(slotId,studentId,staffId))
        {
            ///TODO: notify the user for the status of the process
        }
        else
        {

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private boolean resreveApp(int slotId, String studentId,String staffId)
    {   boolean isInsert=false;
        AppointmentEntity appointment=new AppointmentEntity();
        appointment.setOfficeHourId(slotId);
        appointment.setStaffId(staffId);
        appointment.setStudentId(studentId);
        isInsert=AppointmentCrud.addAppointment(appointment);
        return isInsert;
    }
}
