/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.uantwerpen.dc.studyassistant;

import be.uantwerpen.dc.studyassistant.entities.Environment;
import be.uantwerpen.dc.studyassistant.network.NetworkUtility;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leonardelezi
 */
@WebServlet(name = "StudyAssistant", urlPatterns = {"/resources"})
public class StudyAssistant extends HttpServlet {

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
        
        URL url = new URL("https://192.168.2.33:8443/logs");        
        
        String jstring = null;
        try {
            jstring = NetworkUtility.request(url, false, true);
        } catch (Exception ex) {
            Logger.getLogger(StudyAssistant.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create(); 
        JsonParser parser = new JsonParser();
        JsonArray jArray = parser.parse(jstring).getAsJsonArray();
        
        ArrayList<Environment> lcs = new ArrayList<Environment>();
        
        for(JsonElement obj : jArray )
        {
            Environment cse = gson.fromJson( obj , Environment.class);
            lcs.add(cse);
        } 
        
        Integer min = Integer.MAX_VALUE;
        Integer max = Integer.MIN_VALUE;
        for(Environment e: lcs){
            if(e.getArduinoloudness()!= null && e.getArduinoloudness() < min){
                min = e.getArduinoloudness();
            }            
            if(e.getArduinoloudness() != null && e.getArduinoloudness() > max){
                max = e.getArduinoloudness();
            }
        }
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudyAssistant</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudyAssistant at " + request.getContextPath() + "</h1>");
            for(Environment e: lcs){
                out.println(e.toString()); 
            }
            
            out.println("Noise MAX: " + max);
            out.println("Noise MIN: " + min);
            
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
