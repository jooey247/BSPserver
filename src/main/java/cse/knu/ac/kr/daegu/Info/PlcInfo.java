package cse.knu.ac.kr.daegu.Info;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="PlcInfo")
public class PlcInfo{
	
	@Id
	@Column(name="plcId",nullable=false)
    private String plcId;
	@Column(name="plcName",nullable=false)
    private String plcName;
	@Column(name="plcOption",nullable=false)
    private int plcOption;   
	
	@ManyToMany
	private List<UserInfo> userinfos;
    
    @ManyToOne
    @JoinColumn(name="mngId")
    private MngInfo mngInfo;
    
    @OneToMany(mappedBy = "plcInfo")
    private List<BeaconInfo> beaconInfos = new ArrayList<>();
     
    
    
    public PlcInfo(String plcId, String plcName, int plcOption, MngInfo mngInfo) {
		super();
		this.plcId = plcId;
		this.plcName = plcName;
		this.plcOption = plcOption;
		this.mngInfo = mngInfo;
	}


	public PlcInfo(String plcId, String plcName, int plcOption, List<BeaconInfo> beaconInfos) {
		super();
		this.plcId = plcId;
		this.plcName = plcName;
		this.plcOption = plcOption;
		this.beaconInfos = beaconInfos;
	}


	public PlcInfo(String plcId, String plcName, int plcOption) {
		super();
		this.plcId = plcId;
		this.plcName = plcName;
		this.plcOption = plcOption;
	}
	
	public void addBeaconInfos(BeaconInfo beaconInfo){
		beaconInfos.add(beaconInfo);
	}


	public MngInfo getMngInfo() {
		return mngInfo;
	}


	/*
	 * DAN:INF LOOP
	 * 
	public void setMngInfo(MngInfo mngInfo) {
		this.mngInfo = mngInfo;
	}
	*/


	public String getPlcId() {
		return plcId;
	}


	public void setPlcId(String plcId) {
		this.plcId = plcId;
	}


	public String getPlcName() {
		return plcName;
	}


	public void setPlcName(String plcName) {
		this.plcName = plcName;
	}


	public int getPlcOption() {
		return plcOption;
	}


	public void setPlcOption(int plcOption) {
		this.plcOption = plcOption;
	}


	public List<BeaconInfo> getBeaconInfos() {
		return beaconInfos;
	}


	public void setBeaconInfos(List<BeaconInfo> beaconInfos) {
		this.beaconInfos = beaconInfos;
	}


	public PlcInfo(){
    	
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
   private String beaconInfo;
   
   //FK
   @JoinColumn
   private String userName;
}
 */ 

