/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.uantwerpen.dc.studyassistant.index;

import be.uantwerpen.dc.studyassistant.entities.Environment;

/**
 *
 * @author madks_000
 */
public class StudyIndex {
    
    // Constant factors
    // =(0.3*B9+0.1*B10+0.01*B11+0.01*B12+0.01*B13+0.1*B14+0.47*B15)*100
    private static final double temperatureMultiplier = 0.3;
    private static final double humidityMultiplier = 0.1;
    private static final double pressureMultiplier = 0.01;
    private static final double alcoholMultiplier = 0.01;
    private static final double methaneMultiplier = 0.01;
    private static final double loudnessMultiplier = 0.1;
    private static final double lightMultiplier = 0.47;
    
    // Optimal values
    /*
        23.5 = 1 - abs(tanh((C9-D1)/(D1 * 1.25)))
        50 = 1 - abs(tanh((C10-D2)/(D2 * 1.6)))
        1013 = = 1 - abs(tanh((C11-D3)/(D3 * 20)))
        120 = 1 - abs(tanh((C12-D4)/(D4 * 1.5)))
        60 = 1 - abs(tanh((C13-D5)/(D5 * 3)))
        10 = 1 - abs(tanh((C14-D6)/(D6 * 42)))
        300 = log((C15/6.5), 50)* 1.3
    */
    private static final double temperatureOptimalValue = 23.5;
    private static final double humidityOptimalValue = 50;
    private static final double pressureOptimalValue = 1013;
    private static final double alcoholOptimalValue = 120;
    private static final double methaneOptimalValue = 60;
    private static final double loudnessOptimalValue = 10;
    private static final double lightOptimalValue = 300;

    // Variables
    private double temperature = 0.0;
    private double humidity = 0.0;
    private double pressure = 0.0;
    private double alcohol = 0.0;
    private double methane = 0.0;
    private double loudness = 0.0;
    private double light = 0.0;
    
    // Calculatable indices
    private double studyIndex = 0.0;
    public double temperatureIndex = 0.0;
    public double humidityIndex = 0.0;
    public double pressureIndex = 0.0;
    public double alcoholIndex = 0.0;
    public double methaneIndex = 0.0;
    public double loudnessIndex = 0.0;
    public double lightIndex = 0.0;
    
    public StudyIndex(int temperature, int humidity, int pressure, int alcohol, int methane, int loudness, int light) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.alcohol = alcohol;
        this.methane = methane;
        this.loudness = loudness;
        this.light = light;
    }
    
    public StudyIndex(Environment env) {
        this.temperature = env.getDs18b20temp();
        this.temperature = this.temperature/1000.0;
        this.humidity = env.getDht11hum();
        this.pressure = env.getBmp180pressure();
        this.alcohol = env.getArduinoalcohol();
        this.methane = env.getArduinomethaine();
        this.loudness = env.getArduinoloudness();
        this.light = env.getArduinolight();
    }
    
    
    private void calculateAllIndices() {
        // do all the Math "stuff"
        /*
            23.5 = 1 - abs(tanh((C9-D1)/(D1 * 1.25)))
            50 = 1 - Math.abs(Math.tanh((C10-D2)/(D2 * 1.6)));
            1013 = = 1 - Math.abs(Math.tanh((C11-D3)/(D3 * 20)));
            120 = 1 - Math.abs(Math.tanh((C12-D4)/(D4 * 1.5)));
            60 = 1 - Math.abs(Math.tanh((C13-D5)/(D5 * 3)));
            10 = 1 - Math.abs(Math.tanh((C14-D6)/(D6 * 42)));
            300 = Math.log((C15/6.5), 50)* 1.3;
         */
        
        // 23.5 = 1 - abs(tanh((C9-D1)/(D1 * 1.25)))
        this.temperatureIndex = 1 - Math.abs(Math.tanh((temperature -
                temperatureOptimalValue)/(temperatureOptimalValue * 1.25)));
        
        // 50 = 1 - abs(tanh((C10-D2)/(D2 * 1.6)))
        this.humidityIndex = 1 - Math.abs(Math.tanh((humidity - 
                humidityOptimalValue)/(humidityOptimalValue * 1.6)));
        
        // 1013 = = 1 - Math.abs(Math.tanh((C11-D3)/(D3 * 20)));
        this.pressureIndex = 1 - Math.abs(Math.tanh((pressure -
                pressureOptimalValue)/(pressureOptimalValue * 20)));
        
        // 120 = 1 - Math.abs(Math.tanh((C12-D4)/(D4 * 1.5)));
        this.alcoholIndex = 1 - Math.abs(Math.tanh((alcohol - 
                alcoholOptimalValue)/(alcoholOptimalValue * 1.5)));
                
        // 60 = 1 - Math.abs(Math.tanh((C13-D5)/(D5 * 3)));
        this.methaneIndex = 1 - Math.abs(Math.tanh((methane -
                methaneOptimalValue)/(methaneOptimalValue * 3)));
        
        // 10 = 1 - Math.abs(Math.tanh((C14-D6)/(D6 * 42)));
        this.loudnessIndex = 1 - Math.abs(Math.tanh((loudness - 
                loudnessOptimalValue)/(loudnessOptimalValue * 42)));
        
        // 300 = log((C15/6.5), 50)* 1.3
        this.lightIndex = logBase((light/6.5), 50)* 1.3;
    }
    
    public double logBase(double num, double base) {
        return Math.log(num) / Math.log(base);
    }
    
    public double getStudyIndex(){
        
        // Calculate each of the indices
        this.calculateAllIndices();
        
        // Calculate the overall index
        this.studyIndex = temperatureIndex * temperatureMultiplier
            + humidityIndex * humidityMultiplier
            + pressureIndex * pressureMultiplier
            + alcoholIndex * alcoholMultiplier
            + methaneIndex * methaneMultiplier
            + loudnessIndex * loudnessMultiplier
            + lightIndex * lightMultiplier;
        
        return this.studyIndex;
    }
}
