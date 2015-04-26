/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.uantwerpen.dc.studyassistant;

import be.uantwerpen.dc.studyassistant.entities.Environment;
import be.uantwerpen.dc.studyassistant.index.StudyIndex;
import be.uantwerpen.dc.studyassistant.network.NetworkUtility;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
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
@WebServlet(name = "StudyAssistant", urlPatterns = {"/resources", "/resources/gauge", "/resources/humidity", "/resources/temperature", "/resources/loudness", "/resources/light"})
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
        
        String urlPath = request.getServletPath();
        
        if(urlPath.equalsIgnoreCase("/resources")){
            
            ArrayList<Environment> lcs = this.getEnvironmentResources();

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
        } else if(urlPath.equalsIgnoreCase("/resources/gauge")){
            Environment lastRecord = this.getLastEnvironmentRecord();
            
//            var jsonData = {
//                    cols: [{id: 'Host Name', label: 'Host Name', type: 'string'},
//                           {id: 'Value', label: 'Value', type: 'number'}],
//                    rows: [{c:[{v: 'bongo'}, {v: 24}]},
//                           {c:[{v: 'chappie'}, {v: 78}]}]
//                    }
            
            StudyIndex inx = new StudyIndex(lastRecord);
            double index = inx.getStudyIndex();
            index *= 100;
            
            index = Math.round(index * 100.0) / 100.0;
            
            
            
            JsonObject obj = new JsonObject();
            
            // create an array called cols
            JsonArray cols = new JsonArray();
            JsonArray rows = new JsonArray();
            
            JsonObject col = new JsonObject();
            col.addProperty("id", "Index");
            col.addProperty("label", "Index");
            col.addProperty("type", "string");
            cols.add(col);
            
            JsonObject col2 = new JsonObject();
            col2.addProperty("id", "Value");
            col2.addProperty("label", "Value");
            col2.addProperty("type", "number");
            cols.add(col2);
            
            obj.add("cols", cols);
            
            JsonObject c = new JsonObject();
            JsonArray row = new JsonArray();
            
            JsonObject v1 = new JsonObject();
            v1.addProperty("v", "Index");
            row.add(v1);
            
            JsonObject v2 = new JsonObject();
            v2.addProperty("v", index);
            row.add(v2);
            
            c.add("c", row);
            
            rows.add(c);
            
            obj.add("rows", rows);
            
            Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            
            
            PrintWriter out = response.getWriter();
                                    
            out.print(gson.toJson(obj));
        } else if (urlPath.equalsIgnoreCase("/resources/humidity")){            
            JsonObject obj = this.getCoreChartsJson("Humidity");
            this.printJson(obj, response);
        } else if (urlPath.equalsIgnoreCase("/resources/temperature")){            
            JsonObject obj = this.getCoreChartsJson("Temperature");
            this.printJson(obj, response);            
        } else if (urlPath.equalsIgnoreCase("/resources/loudness")){            
            JsonObject obj = this.getCoreChartsJson("Loudness");
            this.printJson(obj, response);            
        } else if (urlPath.equalsIgnoreCase("/resources/light")){            
            JsonObject obj = this.getCoreChartsJson("Light");
            this.printJson(obj, response);            
        }
    }
    
    private void printJson(JsonObject obj, HttpServletResponse response) throws IOException{
            Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
            
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            
            PrintWriter out = response.getWriter();
                                    
            out.print(gson.toJson(obj));        
    }
    
    private JsonObject getCoreChartsJson(String property){
        
            ArrayList<Environment> envs = this.getEnvironmentResources();
            
            JsonObject obj = new JsonObject();
            
            // create an array called cols
            JsonArray cols = new JsonArray();
            JsonArray rows = new JsonArray();
            
            JsonObject col = new JsonObject();
            col.addProperty("id", "Time");
            col.addProperty("label", "Time");
            col.addProperty("type", "date");
            cols.add(col);
            
            JsonObject col2 = new JsonObject();
            col2.addProperty("id", property);
            col2.addProperty("label", property);
            col2.addProperty("type", "number");
            cols.add(col2);            
            
            obj.add("cols", cols);
            
            for(Environment e: envs ){
                JsonObject c = new JsonObject();
                JsonArray row = new JsonArray();
                
                JsonObject v1 = new JsonObject();
                v1.addProperty("v", "Date("+e.getCreated().getTime()+")");
                row.add(v1);
                
                JsonObject v2 = new JsonObject();
                
                if(property.equalsIgnoreCase("temperature")){
                    v2.addProperty("v", e.getDs18b20temp());                    
                } else if(property.equalsIgnoreCase("humidity")){
                    v2.addProperty("v", e.getDht11hum());                    
                } else if(property.equalsIgnoreCase("loudness")){
                    v2.addProperty("v", e.getArduinoloudness());                    
                } else if(property.equalsIgnoreCase("light")){
                    v2.addProperty("v", e.getArduinolight());                    
                }
                
                row.add(v2);
                
                c.add("c", row);
                
                rows.add(c);
            }
            obj.add("rows", rows);
            
            return obj;
    }
    
    private ArrayList<Environment> getEnvironmentResources(){
        URL url = null;        
        try {
            url = new URL("https://192.168.2.33:8443/logs");
        } catch (MalformedURLException ex) {
            Logger.getLogger(StudyAssistant.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
            
            return lcs;        
    }
    
    private Environment getLastEnvironmentRecord(){
        URL url = null;        
        try {
            url = new URL("https://192.168.2.33:8443/log");
        } catch (MalformedURLException ex) {
            Logger.getLogger(StudyAssistant.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
            
            return lcs.get(0);  
        
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
