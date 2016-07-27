package cse.knu.ac.kr.daegu;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PlaceInfo{
	
	@Id
    private String plcId;
    private String plcName;
    private String plcPw;
    private String plcAdrs;
    private String plcOption;
    private String userName;
    
    public PlaceInfo(){
    	
    }
    

    public PlaceInfo(String plcId, String plcPw) {
        this.plcId = plcId;
        this.plcPw = plcPw;
    }

    public PlaceInfo(String plcId, String plcName, String plcPw, String plcAdrs, String plcOption, String userName) {
        this.plcId = plcId;
        this.plcName = plcName;
        this.plcPw = plcPw;
        this.plcAdrs = plcAdrs;
        this.plcOption = plcOption;
        this.userName = userName;
    }
    
    public String getUserName()
    {
    	return userName;
    }
    
    public void setUserName(String userName){
    	this.userName = userName;
    }
    

    public String getPlcId() {
        return plcId;
    }

    public void setPlcId(String plcId) {
        this.plcId = plcId;
    }

    public String getplcName() {
        return plcName;
    }

    public void setplcName (String plcName) {
        this.plcName = plcName;
    }

    public String getPlcPw() {
        return plcPw;
    }

    public void setPlcPw(String plcPw) {
        this.plcPw = plcPw;
    }

    public String getPlcAdrs() {
        return plcAdrs;
    }

    public void setPlcAdrs(String plcAdrs) {
        this.plcAdrs = plcAdrs;
    }

    public String getPlcOption() {
        return plcOption;
    }

    public void setPlcOption(String plcOption) {
        this.plcOption = plcOption;
    }
    
    

}

/*package com.example;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class PlaceInfo {

   @Id
   // beacon mac address
   //PK
   private String plcId;
   private String plcName;
   private String plcPw;
   private String plcAdrs;
   private String plcOption;
   
   //FK
   @JoinColumn
   private String userName;
}
 */ 

