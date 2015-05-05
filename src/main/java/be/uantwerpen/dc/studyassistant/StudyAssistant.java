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
@WebServlet(name = "StudyAssistant", urlPatterns = {"/resources", "/resources/gauge", "/resources/humidity", "/resources/temperature", "/resources/loudness", "/resources/light", "/resources/bubbleindex","/resources/minmax"})
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
            
            StudyIndex inx = new StudyIndex(lastRecord);
            double index = inx.getStudyIndex();
            index *= 100;
            
            index = Math.round(index * 100.0) / 100.0;
            
            
            
            JsonObject obj = new JsonObject();
            
            // create an array called cols
            JsonArray cols = new JsonArray();
            JsonArray rows = new JsonArray();
            JsonArray messages = new JsonArray();
            
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
            
            
            
            
            String msg = "";
            if((inx.alcoholIndex < 0.90)||(inx.methaneIndex < 0.90)){
                msg += "Room needs better air circulation."; 
                JsonObject msg1 = new JsonObject();
                msg1.addProperty("text", msg);
                messages.add(msg1);
            }
            
            JsonObject msg2 = new JsonObject();
            msg = "";
            if(lastRecord.getArduinolight() < StudyIndex.lightOptimalValue){
                msg += "Increase room luminance!";                
            } else if (lastRecord.getArduinolight() > StudyIndex.lightOptimalValue){
                msg += "Lower room luminance!";
            } else {
                msg += "Room luminance is optimal!";
            }            
            msg2.addProperty("text", msg);
            messages.add(msg2);
            
            JsonObject msg3 = new JsonObject();
            msg = "";
            if(lastRecord.getDs18b20temp() < StudyIndex.temperatureOptimalValue){
                msg += "Increase room temperature!";                
            } else if (lastRecord.getDs18b20temp() > StudyIndex.temperatureOptimalValue){
                msg += "Lower room temperature!";
            } else {
                msg += "Room temperature is optimal!";
            } 
            msg3.addProperty("text", msg);
            messages.add(msg3);
            
            JsonObject msg4 = new JsonObject();
            msg = "";
            if (lastRecord.getArduinoloudness() > StudyIndex.loudnessOptimalValue){
                msg += "Room is too noisy. Find a quiter place!";
                msg4.addProperty("text", msg);
                messages.add(msg4);
            }   
            
            JsonObject msg5 = new JsonObject();
            msg = "";
            if(lastRecord.getDs18b20temp() < StudyIndex.temperatureOptimalValue){
                msg += "Humidity is less than optimal.";                
            } else if (lastRecord.getDs18b20temp() > StudyIndex.temperatureOptimalValue){
                msg += "Humidity is above optimal.";
            } else {
                msg += "Humidity is optimal!";
            }
            msg5.addProperty("text", msg);
            messages.add(msg5);
            
            obj.add("messages", messages);
            
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
        } else if (urlPath.equalsIgnoreCase("/resources/bubbleindex")){            
            JsonObject obj = this.getCoreChartsJson("Environment Index Score");
            this.printJson(obj, response);            
        } else if (urlPath.equalsIgnoreCase("/resources/minmax")){            
            JsonObject obj = this.findMinMax();
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
                    row.add(v2);
                    c.add("c", row);
                    rows.add(c);
                    obj.add("rows", rows);
                } else if(property.equalsIgnoreCase("humidity")){
                    v2.addProperty("v", e.getDht11hum());      
                    row.add(v2);
                    c.add("c", row);
                    rows.add(c);
                    obj.add("rows", rows);
                } else if(property.equalsIgnoreCase("loudness")){
                    v2.addProperty("v", e.getArduinoloudness());                    
                    row.add(v2);
                    c.add("c", row);
                    rows.add(c);
                    obj.add("rows", rows);
                } else if(property.equalsIgnoreCase("light")){
                    v2.addProperty("v", e.getArduinolight());                    
                    row.add(v2);
                    c.add("c", row);
                    rows.add(c);
                    obj.add("rows", rows);
                } else if(property.equalsIgnoreCase("Environment Index Score")){
                    StudyIndex in = null;
                    double index = 0;
                    try{
                        in = new StudyIndex(e);  
                        index = in.getStudyIndex();
                    } catch (Exception exc){
                        //Logger.getLogger(StudyAssistant.class.getName()).log(Level.SEVERE, null, exc);                                                
                    }
                    v2.addProperty("v", index);
                    row.add(v2);
                    c.add("c", row);
                    rows.add(c);
                    obj.add("rows", rows);
                }
            }
            
            
            return obj;
    }
    
    private ArrayList<Environment> getEnvironmentResources(){
        URL url = null;        
        try {
            //url = new URL("https://192.168.2.33:8443/logs");
            url = new URL("https://demo3407181.mockable.io/logs");
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(StudyAssistant.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            String jstring = null;
            try {
                jstring = NetworkUtility.request(url, false, false);
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
            //url = new URL("https://192.168.2.33:8443/log");
            url = new URL("https://demo3407181.mockable.io/log");
        } catch (MalformedURLException ex) {
            Logger.getLogger(StudyAssistant.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            String jstring = null;
            try {
                jstring = NetworkUtility.request(url, false, false);
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
    
    private JsonObject findMinMax(){
        ArrayList<Environment> envs = this.getEnvironmentResources();
        
        Double minTemperature = Double.MAX_VALUE;
        Double maxTemperature = Double.MIN_NORMAL;
        
        Double minHumidity = Double.MAX_VALUE;
        Double maxHumidity = Double.MIN_NORMAL;
        
        Double minLoudness = Double.MAX_VALUE;
        Double maxLoudness = Double.MIN_NORMAL;
        
        Double minLight = Double.MAX_VALUE;
        Double maxLight = Double.MIN_NORMAL;
        
        Double minAlcohol = Double.MAX_VALUE;
        Double maxAlcohol = Double.MIN_NORMAL;
        
        Double minMethaine = Double.MAX_VALUE;
        Double maxMethaine = Double.MIN_NORMAL;
        
        Double minPressure = Double.MAX_VALUE;
        Double maxPressure = Double.MIN_NORMAL;
        
        for(Environment e: envs){
            if(e.getDs18b20temp()!= null && e.getDs18b20temp() < minTemperature){
                minTemperature = Double.parseDouble(e.getDs18b20temp()+"");
            }  
            
            if(e.getDs18b20temp() != null && e.getDs18b20temp() > maxTemperature){
                maxTemperature = Double.parseDouble(e.getDs18b20temp()+"");
            }
            
            if(e.getDht11hum()!= null && e.getDht11hum() < minHumidity){
                minHumidity = Double.parseDouble(e.getDht11hum()+"");
            }  
            
            if(e.getDht11hum() != null && e.getDht11hum() > maxHumidity){
                maxHumidity = Double.parseDouble(e.getDht11hum()+"");
            }
            
            if(e.getArduinolight()!= null && e.getArduinolight() < minLight){
                minLight = Double.parseDouble(e.getArduinolight()+"");
            }  
            
            if(e.getArduinolight() != null && e.getArduinolight() > maxLight){
                maxLight = Double.parseDouble(e.getArduinolight()+"");
            }
            
            if(e.getArduinoloudness()!= null && e.getArduinoloudness() < minLoudness){
                minLoudness = Double.parseDouble(e.getArduinoloudness()+"");
            }  
            
            if(e.getArduinoloudness() != null && e.getArduinoloudness() > maxLoudness){
                maxLoudness = Double.parseDouble(e.getArduinoloudness()+"");
            }
            
                        
            if(e.getArduinoalcohol()!= null && e.getArduinoalcohol() < minAlcohol){
                minAlcohol = Double.parseDouble(e.getArduinoalcohol()+"");
            }  
            
            if(e.getArduinoalcohol() != null && e.getArduinoalcohol() > maxAlcohol){
                maxAlcohol = Double.parseDouble(e.getArduinoalcohol()+"");
            }
            
            if(e.getArduinomethaine() != null && e.getArduinomethaine() < minMethaine){
                minMethaine = Double.parseDouble(e.getArduinomethaine()+"");
            }  
            
            if(e.getArduinomethaine() != null && e.getArduinomethaine() > maxMethaine){
                maxMethaine = Double.parseDouble(e.getArduinomethaine()+"");
            }
            
            if(e.getBmp180pressure() != null && e.getBmp180pressure() < minPressure){
                minPressure = Double.parseDouble(e.getBmp180pressure()+"");
            }  
            
            if(e.getBmp180pressure() != null && e.getBmp180pressure() > maxPressure){
                maxPressure = Double.parseDouble(e.getBmp180pressure()+"");
            }
            
        }
        
        ArrayList<String> types = new ArrayList<String>();
        types.add("Temperature");
        types.add("Humidity");
        types.add("Loudness");
        types.add("Luminance");
        types.add("Alcohol");
        types.add("Methane");
        types.add("Pressure");
        
            JsonObject obj = new JsonObject();
            
            // create an array called cols
            JsonArray cols = new JsonArray();
            JsonArray rows = new JsonArray();
            
            JsonObject col = new JsonObject();
            col.addProperty("id", "Variable");
            col.addProperty("label", "Variable");
            col.addProperty("type", "string");
            cols.add(col);
            
            JsonObject col2 = new JsonObject();
            col2.addProperty("id", "Minimum");
            col2.addProperty("label", "Minimum");
            col2.addProperty("type", "number");
            cols.add(col2);  
            
            JsonObject col3 = new JsonObject();
            col3.addProperty("id", "Maximum");
            col3.addProperty("label", "Maximum");
            col3.addProperty("type", "number");
            cols.add(col3); 
            
            obj.add("cols", cols);
            
            for(String s: types){
                JsonObject c = new JsonObject(); 
                JsonArray row = new JsonArray();

                JsonObject v1 = new JsonObject();
                v1.addProperty("v", s);
                row.add(v1);

                
                if(s.equalsIgnoreCase("temperature")){
                    JsonObject v2 = new JsonObject();
                    v2.addProperty("v", minTemperature);
                    row.add(v2);
                    
                    JsonObject v3 = new JsonObject();
                    v3.addProperty("v", maxTemperature);                
                    row.add(v3);
                    
                    c.add("c", row);
                    rows.add(c);
                } else if(s.equalsIgnoreCase("humidity")){
                    JsonObject v2 = new JsonObject();
                    v2.addProperty("v", minHumidity);
                    row.add(v2);
                    
                    JsonObject v3 = new JsonObject();
                    v3.addProperty("v", maxHumidity);                
                    row.add(v3);
                    
                    c.add("c", row); 
                    rows.add(c);
                } else if(s.equalsIgnoreCase("loudness")){
                    JsonObject v2 = new JsonObject();
                    v2.addProperty("v", minLoudness);
                    row.add(v2);
                    
                    JsonObject v3 = new JsonObject();
                    v3.addProperty("v", maxLoudness);                
                    row.add(v3);
                    
                    c.add("c", row); 
                    rows.add(c);
                } else if(s.equalsIgnoreCase("luminance")){
                    JsonObject v2 = new JsonObject();
                    v2.addProperty("v", minLight);
                    row.add(v2);
                    
                    JsonObject v3 = new JsonObject();
                    v3.addProperty("v", maxLight);                
                    row.add(v3);
                    
                    c.add("c", row); 
                    rows.add(c);
                } else if(s.equalsIgnoreCase("alcohol")){
                    JsonObject v2 = new JsonObject();
                    v2.addProperty("v", minAlcohol);
                    row.add(v2);
                    
                    JsonObject v3 = new JsonObject();
                    v3.addProperty("v", maxAlcohol);                
                    row.add(v3);
                    
                    c.add("c", row); 
                    rows.add(c);
                } else if(s.equalsIgnoreCase("methane")){
                    JsonObject v2 = new JsonObject();
                    v2.addProperty("v", minMethaine);
                    row.add(v2);
                    
                    JsonObject v3 = new JsonObject();
                    v3.addProperty("v", maxMethaine);                
                    row.add(v3);
                    
                    c.add("c", row); 
                    rows.add(c);
                } else if(s.equalsIgnoreCase("pressure")){
                    JsonObject v2 = new JsonObject();
                    v2.addProperty("v", minPressure);
                    row.add(v2);
                    
                    JsonObject v3 = new JsonObject();
                    v3.addProperty("v", maxPressure);                
                    row.add(v3);
                    
                    c.add("c", row); 
                    rows.add(c);
                }                         
            }
            
            obj.add("rows", rows);
            
            return obj;
        
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
