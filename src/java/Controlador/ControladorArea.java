
package Controlador;

import Modelo.Area;
import ModeloDAO.AreaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
public class ControladorArea extends HttpServlet {
String listararea = "Vista/ListarArea.jsp";
    String agregararea = "Vista/AgregarArea.jsp";
    String editararea = "Vista/EditarArea.jsp";
    Area area = new Area();
    AreaDAO areaDAO = new AreaDAO();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorArea</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorArea at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String acceso = "";
        String s_accion = request.getParameter("f_accion");
        if (s_accion.equalsIgnoreCase("listararea")) {
            acceso = listararea;
        }else if (s_accion.equalsIgnoreCase("agregararea01")) {
            acceso = agregararea;
        }else if (s_accion.equalsIgnoreCase("agregararea02")) {
            String s_nombre = request.getParameter("f_nombre");
            String s_estado = request.getParameter("f_estado");
            area.setNombre(s_nombre);
            area.setEstado(s_estado);
            areaDAO.agregararea(area);
            acceso = listararea;
            
        }else if (s_accion.equalsIgnoreCase("editararea01")) {
            request.setAttribute("f_idarea", request.getParameter("f_idarea"));
            acceso = editararea;
        }else if (s_accion.equalsIgnoreCase("editararea02")) {
            int s_idarea = Integer.valueOf(request.getParameter("f_idarea"));
            String s_nombre = request.getParameter("f_nombre");
            String s_estado = request.getParameter("f_estado");
            
            area.setIdarea(s_idarea);            
            area.setNombre(s_nombre);
            area.setEstado(s_estado);
            areaDAO.editararea(area);
            acceso = listararea;
        }else if (s_accion.equals("eliminararea")) {
            int s_idarea = Integer.valueOf(request.getParameter("f_idarea"));
            areaDAO.eliminararea(s_idarea);
            acceso = listararea;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
