package cn.hevttc.service.bean;

import com.blade.ioc.annotation.Bean;

/**
 * campus name table
 */
@Bean
public class CampusName {
    private int id;
    private String name;
    private String ip;

    public CampusName(){

    }
    public CampusName(int id, String name,String ip){
        this.id=id;
        this.name=name;
        this.ip=ip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
