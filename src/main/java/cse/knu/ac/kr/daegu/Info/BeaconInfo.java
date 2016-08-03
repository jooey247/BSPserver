package cse.knu.ac.kr.daegu.Info;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class BeaconInfo {
	@Id
	@Column(nullable=false)
	private String beaMcadrs;

	@Column(nullable=false)
	private String beaAdr;
	
	@ManyToOne
	@JoinColumn(name="plcId")
	private PlcInfo plcInfo;
	

	public BeaconInfo(){

		
	}

	public BeaconInfo(String beaMcadrs, String beaOption, String beaAdr,PlcInfo PlcInfo) {
		this.beaMcadrs = beaMcadrs;
	
		this.beaAdr = beaAdr;
		this.plcInfo=PlcInfo;
	}
	
	

	public PlcInfo getPlcInfo() {
		return plcInfo;
	}

	/*
	 * DAN:InF loop
	 * 
	public void setPlcInfo(PlcInfo plcInfo) {
		this.plcInfo = plcInfo;
	}
	*/

	public String getbeaMcadrs() {
		return beaMcadrs;
	}

	public void setbeaMcadrs(String beaMcadrs) {
		this.beaMcadrs = beaMcadrs;
	}

	public String getBeaAdr() {
		return beaAdr;
	}

	public void setBeaAdr(String beaAdr) {
		this.beaAdr = beaAdr;
	}
	
	@Override
	public String toString(){
		return beaMcadrs;
	}
}