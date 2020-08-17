package Controlador;

import Modelo.Rol;
import ModeloDAO.RolDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorRol extends HttpServlet {
    String listarrol = "Vista/ListarRol.jsp";
    String agregarrol = "Vista/AgregarRol.jsp";
    String editarrol = "Vista/EditarRol.jsp";
    Rol rol = new Rol();
    RolDAO rolDAO = new RolDAO();
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
            out.println("<title>Servlet ControladorRol</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorRol at " + request.getContextPath() + "</h1>");
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
        if (s_accion.equalsIgnoreCase("listarrol")) {
            acceso = listarrol;
        }else if (s_accion.equalsIgnoreCase("agregarrol01")) {
            acceso = agregarrol;
        }else if (s_accion.equalsIgnoreCase("agregarrol02")) {
            String s_nombre = request.getParameter("f_nombre");
            String s_estado = request.getParameter("f_estado");
            rol.setNombre(s_nombre);
            rol.setEstado(s_estado);
            rolDAO.agregarrol(rol);
            acceso = listarrol;
            
        }else if (s_accion.equalsIgnoreCase("editarrol01")) {
            request.setAttribute("f_idrol", request.getParameter("f_idrol"));
            acceso = editarrol;
        }else if (s_accion.equalsIgnoreCase("editarrol02")) {
            int s_idrol = Integer.valueOf(request.getParameter("f_idrol"));
            String s_nombre = request.getParameter("f_nombre");
            String s_estado = request.getParameter("f_estado");
            
            rol.setIdrol(s_idrol);            
            rol.setNombre(s_nombre);
            rol.setEstado(s_estado);
            rolDAO.editarrol(rol);
            acceso = listarrol;
        }else if (s_accion.equals("eliminarrol")) {
            int s_idrol = Integer.valueOf(request.getParameter("f_idrol"));
            rolDAO.eliminarrol(s_idrol);
            acceso = listarrol;
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
