package com.example.springboot.bean;

import javax.persistence.*;

@Entity
@Table(name="lost")
public class Lost {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String lost_id;
    private String lost_name;
    private String lost_position;
    private String lost_description;
    private String claim_position;
    private String lost_date;
    private Integer is_returned;
    public String getLost_id(){
        return lost_id;
    }
    public String getLost_name(){
        return lost_name;
    }
    public String getLost_position(){
        return lost_position;
    }
    public String getLost_description(){
        return lost_description;
    }
    public String getClaim_position(){
        return claim_position;
    }
    public String getLost_date() {
        return lost_date;
    }
    public Integer getIs_returned(){return is_returned;}
    public void setLost_id(String lost_id) {
        this.lost_id=lost_id;
    }
    public void setLost_name(String lost_name) {
        this.lost_name = lost_name;
    }
    public void setLost_position(String lost_position) {
        this.lost_position = lost_position;
    }
    public void setClaim_position(String claim_positionn){
        this.claim_position=claim_positionn;
    }
    public void setLost_date(String lost_date) {
        this.lost_date = lost_date;
    }
    public void setLost_description(String lost_description){this.lost_description=lost_description;}
    public void setIs_returned(Integer is_returned) {
        this.is_returned = is_returned;
    }
    public Lost(){}
    public Lost(String lost_id,String lost_name,String lost_position,String lost_description,String claim_position,String lost_date,Integer is_returned){
        this.lost_id = lost_id;
        this.lost_name=lost_name;
        this.lost_position=lost_position;
        this.lost_description=lost_description;
        this.claim_position=claim_position;
        this.lost_date=lost_date;
        this.is_returned=is_returned;
    }
}
