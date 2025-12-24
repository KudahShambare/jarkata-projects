import java.io.IOException;
import java.sql.Connection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kuda.util.DBUtil;

@WebServlet("/test-db")
public class TestDBServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/plain");

        try (Connection con = DBUtil.getConnection()) {
            if (con != null) {
                response.getWriter().println("DATABASE CONNECTED SUCCESSFULLY");
            } else {
                response.getWriter().println("DATABASE CONNECTION FAILED");
            }
        } catch (Exception e) {
            e.printStackTrace(response.getWriter());
        }
    }
}
