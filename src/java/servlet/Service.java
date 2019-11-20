/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Entidade.Piada;
import Regra.Regras_Piada;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.json.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author Aluno
 */
@WebServlet(name = "Service", urlPatterns = {"/Service"})
public class Service extends HttpServlet {

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
        String modo = request.getParameter("modo");
        

        response.setContentType("text/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Regras_Piada regras = new Regras_Piada();
            Gson gson = new Gson();
            if (modo.equals("rand")) {
                //http://localhost:8080/Piadas/Service?modo=rand
                Piada p = regras.randomPiada();
                
                out.println(gson.toJson(p));
            } else {
                if (modo.equals("find")) {
                    //http://localhost:8080/Piadas/Service?modo=find&categoria=0&faixaetaria=3
                    int cat = Integer.parseInt(request.getParameter("categoria"));
                    int fx = Integer.parseInt(request.getParameter("faixaetaria"));
                    String pass = request.getParameter("palavra");
                    List<Piada> list = regras.buscaPiada(cat, fx, pass);
                    out.println(gson.toJson(list));
                }
                else
                   out.println("Modo não definido"); 

            }

        } catch (Exception ex) {
            out.println(ex.toString());
        }
        out.close();
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
        processRequest(request, response);
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
