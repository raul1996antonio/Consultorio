package com.emergentes.controlador;

import com.emergentes.dao.EstadoDAO;
import com.emergentes.dao.EstadoDAOimpl;
import com.emergentes.modelo.Estado;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EstadoControlador", urlPatterns = {"/EstadoControlador"})
public class EstadoControlador extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Estado est = new Estado();
            int id;
            EstadoDAO dao = new EstadoDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch(action){
                case "add":
                    request.setAttribute("action", action);
                    request.setAttribute("estado", est);
                    
                    request.getRequestDispatcher("frmEstados.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    est = dao.getById(id);
                    
                    request.setAttribute("action", action);
                    request.setAttribute("estado", est);
                    
                    request.getRequestDispatcher("frmEstados.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("EstadoControlador");
                    break;
                case "view":
                    //  Obtener la lista de registro
                    List<Estado> lista = dao.getAll();
                    request.setAttribute("estados", lista);
                    request.getRequestDispatcher("estados.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("ERROR EN EL doGet:  "+ex.getMessage());
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String estado = new String(request.getParameter("estado").getBytes("ISO-8859-1"),"UTF-8");
        String descripcion = new String(request.getParameter("descripcion").getBytes("ISO-8859-1"),"UTF-8");
        
        Estado est = new Estado();
        est.setId(id);
        est.setEstado(estado);
        est.setDescripcion(descripcion);
        
        EstadoDAO dao = new EstadoDAOimpl();
        if(id == 0){
            try {
                //  NUEVO REGISTRO
                dao.insert(est);
            } catch (Exception ex) {
                System.out.println("ERROR AL INSERTAR REGISTRO:  "+ex.getMessage());
            }
        } else {
            try {
                //  EDICION DE REGISTRO
                dao.update(est);
            } catch (Exception ex) {
                System.out.println("ERROR AL EDITAR REGISTRO:  "+ex.getMessage());
            }
        }
        response.sendRedirect("EstadoControlador");
    }
}
