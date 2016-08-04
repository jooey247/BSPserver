package cse.knu.ac.kr.daegu.Info;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="MngInfo")
public class MngInfo {
	
	@Id
	@Column(name="mngId",nullable=false)
	private String mngId;
	@Column(name="mngPw",nullable=false)
	private String mngPw;
	@Column(name="mngName")
	private String mngName;
	@Column(name="mngAdrs")
	private String mngAdrs;
	
	@OneToMany(mappedBy="mngInfo")
	private List<PlcInfo> plcinfos = new ArrayList<>();
	

	public MngInfo(String mngId, String mngPw) {
		super();
		this.mngId = mngId;
		this.mngPw = mngPw;
	}

	public MngInfo() {
		super();
	}

	public MngInfo(String mngId, String mngPw, String mngName, String mngAdrs, List<PlcInfo> plcinfos) {
		super();
		this.mngId = mngId;
		this.mngPw = mngPw;
		this.mngName = mngName;
		this.mngAdrs = mngAdrs;
		this.plcinfos = plcinfos;
	}

	public String getMngId() {
		return mngId;
	}

	public void setMngId(String mngId) {
		this.mngId = mngId;
	}

	public String getMngPw() {
		return mngPw;
	}

	public void setMngPw(String mngPw) {
		this.mngPw = mngPw;
	}

	public String getMngName() {
		return mngName;
	}

	public void setMngName(String mngName) {
		this.mngName = mngName;
	}

	public String getMngAdrs() {
		return mngAdrs;
	}

	public void setMngAdrs(String mngAdrs) {
		this.mngAdrs = mngAdrs;
	}

	public List<PlcInfo> getPlcinfos() {
		return plcinfos;
	}

	public void setPlcinfos(List<PlcInfo> plcinfos) {
		this.plcinfos = plcinfos;
	}

	public void addPlcinofs(PlcInfo plcinfo){
		plcinfos.add(plcinfo);
	}
	
	

}
