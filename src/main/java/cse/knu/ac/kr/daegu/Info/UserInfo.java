package cse.knu.ac.kr.daegu.Info;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Created by juhee on 2016-07-15.
 */
@Entity(name="UserInfo")
public class UserInfo {
	
	@Id
	@Column(nullable = false)
	private String userId;
	@Column(nullable = false)
	private String userPw;
	private String userName;

	@ManyToMany
	@JoinTable(name = "USER_PLC", joinColumns=@JoinColumn(name="PLCINFO_plcid"),
   				inverseJoinColumns=@JoinColumn(name="USERINFO_userId"))
   private List<PlcInfo> plcInfos = new ArrayList<>();

   public void addPlcinofs(PlcInfo plcinfo){
	   plcInfos.add(plcinfo);
   }
   
    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserInfo(String userId, String userPw,String userName) {
        this.userId = userId;
        this.userPw = userPw;

        this.userName= userName;
    }

    public UserInfo(String userId, String userPw) {
        this.userId = userId;
        this.userPw = userPw;
    }
    public UserInfo(){
    	
    }
}

