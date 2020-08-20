package Controlador;

import Modelo.Sugerencia;
import ModeloDAO.SugerenciaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorSugerencia extends HttpServlet {
    String listarsugerencia = "Vista/ListarSugerencia.jsp";
    String agregarsugerencia = "Vista/AgregarSugerencia.jsp";
    String editarsugerencia = "Vista/EditarSugerencia.jsp";
    Sugerencia sugerencia = new Sugerencia();
    SugerenciaDAO sugerenciaDAO = new SugerenciaDAO();
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
            out.println("<title>Servlet ControladorSugerencia</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorSugerencia at " + request.getContextPath() + "</h1>");
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
        if (s_accion.equalsIgnoreCase("listarsugerencia")) {
            acceso = listarsugerencia;
        }else if (s_accion.equalsIgnoreCase("agregarsugerencia01")) {
            acceso = agregarsugerencia;
        }else if (s_accion.equalsIgnoreCase("agregarsugerencia02")) { 
            int s_idsugerencia= Integer.valueOf(request.getParameter("f_idsugerencia"));
            String s_fecha = request.getParameter("f_fecha");
            String s_descripcion = request.getParameter("f_descripcion");
            int s_idpersona = Integer.valueOf(request.getParameter("f_idpersona"));
            int s_idrol = Integer.valueOf(request.getParameter("f_idrol"));
            int s_idarea = Integer.valueOf(request.getParameter("f_idarea"));
            
            
            
            sugerencia.setFecha(s_fecha);
            sugerencia.setDescripcion(s_descripcion);
            sugerencia.setIdpersona(s_idpersona);
            sugerencia.setIdrol(s_idrol);
            sugerencia.setIdarea(s_idarea);
            
            sugerenciaDAO.agregarsugerencia(sugerencia);
            acceso = listarsugerencia;
            
        }else if (s_accion.equalsIgnoreCase("editarsugerencia01")) {
            request.setAttribute("f_idsugerencia", request.getParameter("f_idsugerencia"));
            acceso = editarsugerencia;
        }else if (s_accion.equalsIgnoreCase("editarsugerencia02")) {
            
            int s_idsugerencia= Integer.valueOf(request.getParameter("f_idsugerencia"));
            String s_fecha = request.getParameter("f_fecha");
            String s_descripcion = request.getParameter("f_descripcion");
            int s_idpersona = Integer.valueOf(request.getParameter("f_idpersona"));
            int s_idrol = Integer.valueOf(request.getParameter("f_idrol"));
            int s_idarea = Integer.valueOf(request.getParameter("f_idarea"));
            
            
                      
            sugerencia.setFecha(s_fecha);
            sugerencia.setDescripcion(s_descripcion);
            sugerencia.setIdpersona(s_idpersona);
            sugerencia.setIdrol(s_idrol);
            sugerencia.setIdarea(s_idarea);
            sugerenciaDAO.editarsugerencia(sugerencia);
            acceso = listarsugerencia;
        }else if (s_accion.equals("eliminarsugerencia")) {
            int s_idsugerencia = Integer.valueOf(request.getParameter("f_idsugerencia"));
            sugerenciaDAO.eliminarsugerencia(s_idsugerencia);
            acceso = listarsugerencia;
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
