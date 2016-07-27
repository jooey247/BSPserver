package cse.knu.ac.kr.daegu;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by juhee on 2016-07-15.
 */
@Entity
public class UserInfo {

	@Id
    private String userId;
    private String userPw;
    private String userName;
    private String plcName;
   

    public String getPlcName()
    {
    	return plcName;
    }
    
    public void setPlcName(String plcName){
    	this.plcName= plcName;
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

    public UserInfo(String userId, String userPw, String plcName,String userName) {
        this.userId = userId;
        this.userPw = userPw;
        this.plcName = plcName;
        this.userName= userName;
    }

    public UserInfo(String userId, String userPw) {
        this.userId = userId;
        this.userPw = userPw;
    }
    public UserInfo(){
    	
    }
}

