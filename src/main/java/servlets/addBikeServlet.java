package servlets;

import helpers.BikeHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ksimeo on 17.07.2014.
 */
@WebServlet(urlPatterns="/addnewbike")
public class addBikeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            req.setCharacterEncoding("UTF-8");
            String bikeModel = req.getParameter("modelName");
            String bikeDescription = req.getParameter("modelDescription");
            BikeHelper bh = new BikeHelper();
            boolean err = false;
            List<String> bikeModels = bh.getAllBikesModels();
            Iterator<String> iter = bikeModels.iterator();
            while(iter.hasNext()) {
                String tmp = iter.next();
                if(tmp.equalsIgnoreCase(bikeModels)) {
                    req.setAttribute("ErrorForm", "Task with the same title already exists!");
                    err = true;
                    break;
                }
            }
            if (bikeModel.equals("") || bikeDescription.equals("")) {
                req.setAttribute("ErrorForm", "Fill all input field of new task, please!");
                err = true;
            }
            if(!err) {
                bh.saveBike(bikeModel, bikeDescription);
                resp.sendRedirect("/secret/boss");
            }
           else {
                req.getRequestDispatcher("/secret/addnewbike.jsp").forward(req, resp);
            }
        }
        catch (Exeption e) {
            e.printStackTrace();
        }
    }

}
