package ds.project4task3;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * This class connects with age model and view.
 * @author Karinya
 */
public class project4task3servlet extends HttpServlet {

    /**
     * This method gets date of birth from user, get age from age model, and output to clients.
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException 
     */
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        try {
            int day = Integer.parseInt(req.getParameter("day"));
            int month = Integer.parseInt(req.getParameter("month"));
            int year = Integer.parseInt(req.getParameter("year"));
            Calendar DoB = Calendar.getInstance();
            DoB.set(year, month, day);
            AgeModel ageCal = new AgeModel(DoB);
            String age = "" + ageCal.getAge();
            req.setAttribute("age", age);
            req.setAttribute("result", "OK");

        } catch (Exception ex) {
            // error occurs when calculating age
            req.setAttribute("result", "Fail");
        } finally {
            RequestDispatcher view = req.getRequestDispatcher("age.jsp");
            view.forward(req, resp);
        }
    }
}
