package cse.knu.ac.kr.daegu.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cse.knu.ac.kr.daegu.Info.BeaconInfo;
import cse.knu.ac.kr.daegu.Info.MngInfo;
import cse.knu.ac.kr.daegu.Info.PlcInfo;
import cse.knu.ac.kr.daegu.Info.UserInfo;
import cse.knu.ac.kr.daegu.repo.BeaconInfoRepository;
import cse.knu.ac.kr.daegu.repo.MngInfoRepository;
import cse.knu.ac.kr.daegu.repo.PlcInfoRepository;
import cse.knu.ac.kr.daegu.repo.UserInfoRepository;

@RestController
public class MainController {

	@Autowired
	private UserInfoRepository userInfoRepository;
	@Autowired
	private PlcInfoRepository placeInfoRepository;
	@Autowired
	private MngInfoRepository mngInfoRepository;
	@Autowired
	private BeaconInfoRepository beaconInfoRepository;

	
	//<login>
	//2016.08.03 seulki
	//login_BUser
	@RequestMapping("/users_login/mng")
	   public @ResponseBody String login(@RequestBody MngInfo Buser) {
	     //PlcInfo foundPlace = placeInfoRepository.findOne(place.getPlcId());
		MngInfo foundBuser = mngInfoRepository.findOne(Buser.getMngId());
		
	      // Doesn't exist user info (플레이 정보가 없을 경우)
	      if (foundBuser == null){
	         System.out.println("place★★★★★★아이디 없음★★★★★★");
	         return "login_fail";
	      }
	      else {
	         // collect password (패스워드가 일치할 경우)
	         if (Buser.getMngPw().equals(foundBuser.getMngPw())){
	            System.out.println("place★★★★★★로그인 성공★★★★★★");
	            return "login_success";
	         }

	         // wrong password (패스워드를 틀렸을 경우)
	         else{
	            System.out.println("place★★★★★★비밀번호 없음★★★★★★");
	            return "login_fail";
	         }

	      }
	   }

	   // 2016.07.27 seulki
	   // login_Nuser
	   @RequestMapping("/users_login/user")
	   public @ResponseBody String login(@RequestBody UserInfo user) {
	      UserInfo foundUser = userInfoRepository.findOne(user.getUserId());

	      // Doesn't exist user info (사용자 정보가 없을 경우)
	      if (foundUser == null){
	         System.out.println("user★★★★★★아이디 없음★★★★★★");
	         return "login_fail";
	      }
	      else {
	         // collect password (패스워드가 일치할 경우)
	         if (user.getUserPw().equals(foundUser.getUserPw())){
	            System.out.println("user★★★★★★로그인 성공★★★★★★");
	            return "login_success";
	         }

	         // wrong password (패스워드를 틀렸을 경우)
	         else{
	            System.out.println("user★★★★★★비밀번호 없음★★★★★★");
	            return "login_fail";
	         }

	      }
	   }

	   // 2016.08.03 seulki
	   // add new Nuser (새로운 Nuser 추가)
	   @RequestMapping(value = "/users/user", method = RequestMethod.POST, consumes = "application/json")
	   public @ResponseBody String addUser(@RequestBody UserInfo user) {
	      //doesnt exist same information (일치하는 정보가 없다)
	      if (userInfoRepository.findOne(user.getUserId()) == null) {
	         System.out.println("user ★★★★★★★회원가입 성공★★★★★");
	         
	         //save information (정보를 저장하고)
	         userInfoRepository.save(user);
	         return "signup_success";
	      }
	      //exist same information (일치하는 정보가 존재한다면)
	      else {
	         System.out.println("user ★★★★★★아이디 중복★★★★★★");
	         return "signup_duplicate";

	      }
	   }

	   // 2016.07.27 seulki
	   // add new Buser (새로운 Buser 추가)
	   @RequestMapping(value = "/users/mng", method = RequestMethod.POST, consumes = "application/json")
	   public @ResponseBody String addUser(@RequestBody MngInfo Buser) {

	      //doesnt exist same information (일치하는 정보가 없다)
	      if (mngInfoRepository.findOne(Buser.getMngId()) == null) {
	         System.out.println("place★★★★★★★회원가입 성공★★★★★");
	         
	         //save information (정보를 저장하고)
	         mngInfoRepository.save(Buser);

	         return "signup_success";
	      }

	      //exist same information (일치하는 정보가 존재한다면)
	      else{
	         System.out.println("place★★★★★★아이디 중복★★★★★★");
	         return "signup_duplicate";
	      }

	}

	// 2016.07.25 seulki
	// return all user list (모든 user 리스트 반환)
	@RequestMapping("/users/a_users")
	public @ResponseBody List<UserInfo> getUserList() {
		return userInfoRepository.findAll();
	}
	
	//2016.08.04 seulki
	//return all mng list (모든 mng리스트 반환)
	@RequestMapping("/users/a_mng")
	public @ResponseBody List<MngInfo> getMngList()
	{
		return mngInfoRepository.findAll();
	}
	
	//2016.08.04 seulki
	//return all place list
	@RequestMapping("/place/a_plc")
	public @ResponseBody List<PlcInfo> getPlcList()
	{
		return placeInfoRepository.findAll();
	}
	
	
	// 2016.07.25 seulki
	// search userId and return (userId로 검색해서 반환)
	@RequestMapping("/users/{userId}")
	public @ResponseBody UserInfo getUser(@PathVariable String userId) {
		return userInfoRepository.findOne(userId);
	}
	
	//2016.08.04
	//search mngId and return (mngId로 검색해서 반환)
	@RequestMapping("/users/{mngId}")
	public @ResponseBody MngInfo getMng(@PathVariable String mngId){
		return mngInfoRepository.findOne(mngId);
	}
	
	//2016.08.03 seulki
	//search plcId and return (plcId로 검색해서 반환)
	@RequestMapping("/place/{plcId}")
	public @ResponseBody PlcInfo getPlace(@PathVariable String plcId)
	{
		return placeInfoRepository.findOne(plcId);
	}
	
	//2016.08.03 seulki
	//join place (Nuser가 플레이스에 가입) 
	/*@RequestMapping("/place/sing_in")
	public @ResponseBody String signin_place(@RequestBody UserInfo user, @RequestBody PlcInfo place)
	{
		UserInfo founduser = userInfoRepository.findOne(user.getUserId());
		PlcInfo foundplace = placeInfoRepository.findOne(place.getPlcId());
		
		founduser.addPlcinofs(place);
		
		
		return "Success!";
	}*/
	
	
	//2016.08.03 seulki
	//register place,update mnginfo using plcId 
	@RequestMapping(value = "/place/register" ,method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody String register_place(@RequestBody PlcInfo newplace, @RequestBody MngInfo manager)
	{
		MngInfo foundmanager = mngInfoRepository.findOne(manager.getMngId());

		if(foundmanager==null)
		{
			System.out.println("------------manager 정보 없음~--------------");
			return "fail";
		}
		
		//register place
		foundmanager.addPlcinofs(newplace);
		placeInfoRepository.save(newplace);
		
		//update mnginfo
		mngInfoRepository.save(foundmanager);

		if (placeInfoRepository.findOne(newplace.getPlcId()) != null) {
			
			System.out.println("------------------장소 등록 성공!-----------------");

			return "success";
		}

		else
			return "fail";

	}
	
	//2016.08.03 seulki
	//Register Beacon and update placeinfo
	@RequestMapping(value="place/register/bcon",method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody String register_bcon(@RequestBody BeaconInfo beacon, @RequestBody PlcInfo place)
	{
		BeaconInfo newBeacon = beacon;
		PlcInfo foundplace = placeInfoRepository.findOne(place.getPlcId());
		
		
		if(foundplace==null)
		{
			System.out.println("-------플레이스 정보 없음!-------------");
			return "fail";
		}
		
		//register beacon
		foundplace.addBeaconInfos(newBeacon);
		beaconInfoRepository.save(beacon);
		
		//update placeinfo
		placeInfoRepository.save(foundplace);
		
		
		if(beaconInfoRepository.findOne(beacon.getbeaMcadrs()) != null){
			System.out.println("------------------비콘 등록 성공!-----------------");
			
			return "success";
			
		}
		else
			return "fail";
		
	}
	
	

	
	//2016.07.28 seulki
	@RequestMapping("/mainscreen")
	public @ResponseBody void main_screen(){
		return ;
	}
	
	/*//2016.07.28 seulki
	//place가 비콘등록
	@RequestMapping("/mainscreen/{plcId}/bcon_sign")
	public @ResponseBody String bcon_sign(@PathVariable String plcId, @RequestBody BeaconInfo Bcon){
		BeaconInfo beaconInfo = new BeaconInfo();
		PlcInfo foundplace = placeInfoRepository.findOne(plcId);
		
		beaconInfo=Bcon;
		
		//dosent exist plcId(해당 plcId가 없으면)
		if(foundplace == null)
		{
			System.out.println("bcon_sign ★★★★★★Plc 아이디 없음 ★★★★★★");
			return "fail";
		}
		
		//exist plcId(해당 plcId가 존재하면)
		else
		{
			//해당하는 placeInfo에 비콘 정보를 업데이트 하고 
			foundplace.setbeaconInfos(Bcon);
			
			//다시 테이블에 저장
			placeInfoRepository.save(foundplace);
			
			System.out.println("bcon_sign ★★★★★★PlcInfo 업데이트 ★★★★★★");
			
			return "success";
		}
	}
	*/

	//2016.07.29 seulki
//	@RequestMapping("/뭘 써야 할까....")
//	public @ResponseBody 

}

