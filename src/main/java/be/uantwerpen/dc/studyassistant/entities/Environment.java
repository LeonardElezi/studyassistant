/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.uantwerpen.dc.studyassistant.entities;

import java.util.Date;

/**
 *
 * @author leonardelezi
 */
public class Environment {

    private Integer id;
    private Integer ds18b20temp;
    private Integer dht11temp;
    private Integer dht11hum;
    private Integer cpufreq;
    private Integer thermalzone;
    private Date created;
    private String imagename;
    private Double bmp180temp;
    private Double bmp180pressure;

    public Environment() {

    }

    public Environment(Integer id, Integer ds18b20temp, Integer dht11temp, Integer dht11hum, Integer thermalzone, Date created, String imagename, Double bmp180temp, Double bmp180pressure) {
        this.id = id;
        this.ds18b20temp = ds18b20temp;
        this.dht11temp = dht11temp;
        this.dht11hum = dht11hum;
        this.thermalzone = thermalzone;
        this.created = created;
        this.imagename = imagename;
        this.bmp180temp = bmp180temp;
        this.bmp180pressure = bmp180pressure;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDs18b20temp() {
        return ds18b20temp;
    }

    public void setDs18b20temp(Integer ds18b20temp) {
        this.ds18b20temp = ds18b20temp;
    }

    public Integer getDht11temp() {
        return dht11temp;
    }

    public void setDht11temp(Integer dht11temp) {
        this.dht11temp = dht11temp;
    }

    public Integer getDht11hum() {
        return dht11hum;
    }

    public void setDht11hum(Integer dht11hum) {
        this.dht11hum = dht11hum;
    }

    public Integer getCpufreq() {
        return cpufreq;
    }

    public void setCpufreq(Integer cpufreq) {
        this.cpufreq = cpufreq;
    }

    public Integer getThermalzone() {
        return thermalzone;
    }

    public void setThermalzone(Integer thermalzone) {
        this.thermalzone = thermalzone;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    public Double getBmp180temp() {
        return bmp180temp;
    }

    public void setBmp180temp(Double bmp180temp) {
        this.bmp180temp = bmp180temp;
    }

    public Double getBmp180pressure() {
        return bmp180pressure;
    }

    public void setBmp180pressure(Double bmp180pressure) {
        this.bmp180pressure = bmp180pressure;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("***** Environment Details *****\n");
        sb.append("ID="+this.getId()+"\n");
        sb.append("ds18b20temp="+this.getDs18b20temp()+"\n");
        sb.append("dht11temp="+this.getDht11temp()+"\n");
        sb.append("dht11hum="+this.getDht11hum()+"\n");
        sb.append("cpufreq Numbers="+this.getCpufreq()+"\n");
        sb.append("thermalzone="+this.getThermalzone()+"\n");
        sb.append("created="+this.getCreated()+"\n");
        sb.append("imagename="+this.getImagename()+"\n");
        sb.append("bmp180temp="+this.getBmp180temp()+"\n");
        sb.append("bmp180pressure="+this.getBmp180pressure()+"\n");
        sb.append("*****************************");
         
        return sb.toString();
    }
}
