package by.training.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
//        processReque(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
//        processRequest(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);

    }

    //    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
//        String page = null;
//        CommandFactory factory = CommandFactory.getInstance();
//        String commandParameter = request.getParameter(ParameterNames.COMMAND);
//        Command command = factory.getCommand(commandParameter);
//        page = command.execute(request, response);
//        if(page == null) {
//            page = PageNames.START_PAGE;
//        }
//        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException | IOException e) {
//
//        }
//    }
}
