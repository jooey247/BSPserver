package cse.knu.ac.kr.daegu;

import javax.persistence.ManyToOne;



public class BeaconInfo {
	private String beaMcadr;
	private String beaOption;
	private String beaAdr;
	
	//@ManyToOne
	private PlaceInfo placeInfo;
	

	public BeaconInfo(){

		
	}

	public BeaconInfo(String beaMcadr, String beaOption, String beaAdr) {
		this.beaMcadr = beaMcadr;
		this.beaOption = beaOption;
		this.beaAdr = beaAdr;
	}

	public String getBeaMcadr() {
		return beaMcadr;
	}

	public void setBeaMcadr(String beaMcadr) {
		this.beaMcadr = beaMcadr;
	}

	public String getBeaOption() {
		return beaOption;
	}

	public void setBeaOption(String beaOption) {
		this.beaOption = beaOption;
	}

	public String getBeaAdr() {
		return beaAdr;
	}

	public void setBeaAdr(String beaAdr) {
		this.beaAdr = beaAdr;
	}
}