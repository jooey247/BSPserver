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
import cse.knu.ac.kr.daegu.Info.PlcInfo;
import cse.knu.ac.kr.daegu.Info.UserInfo;
import cse.knu.ac.kr.daegu.repo.PlcInfoRepository;
import cse.knu.ac.kr.daegu.repo.UserInfoRepository;


@RestController
public class MainController {

	@Autowired
	private UserInfoRepository userInfoRepository;
	@Autowired
	private PlcInfoRepository placeInfoRepository;

	
	//<login>
	// 2016.07.27 seulki
	// login_place
	@RequestMapping("/users_login/place")
	   public @ResponseBody String login(@RequestBody PlcInfo place) {
	      PlcInfo foundPlace = placeInfoRepository.findOne(place.getPlcId());

	      // Doesn't exist user info (플레이 정보가 없을 경우)
	      if (foundPlace == null){
	         System.out.println("place★★★★★★아이디 없음★★★★★★");
	         return "login_fail";
	      }
	      else {
	         // collect password (패스워드가 일치할 경우)
	         if (place.getPlcPw().equals(foundPlace.getPlcPw())){
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
	   // login_user
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

	   // 2016.07.27 seulki
	   // add new user (새로운 유저 추가)
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
	   // add new place (새로운 place 추가)
	   @RequestMapping(value = "/users/place", method = RequestMethod.POST, consumes = "application/json")
	   public @ResponseBody String addUser(@RequestBody PlcInfo place) {

	      //doesnt exist same information (일치하는 정보가 없다)
	      if (placeInfoRepository.findOne(place.getPlcId()) == null) {
	         System.out.println("place★★★★★★★회원가입 성공★★★★★");
	         
	         //save information (정보를 저장하고)
	         placeInfoRepository.save(place);

	         return "signup_success";
	      }

	      //exist same information (일치하는 정보가 존재한다면)
	      else{
	         System.out.println("place★★★★★★아이디 중복★★★★★★");
	         return "signup_duplicate";
	      }

	}

	// 2016.07.25 seulki
	// return all user list (모든 유저 리스트 반환)
	@RequestMapping("/users")
	public @ResponseBody List<UserInfo> getUserList() {
		return userInfoRepository.findAll();
	}

	// 2016.07.25 seulki
	// search userId and return (userId로 검색해서 반환)
	@RequestMapping("/users/{userId}")
	public @ResponseBody UserInfo getUser(@PathVariable String userId) {
		return userInfoRepository.findOne(userId);
	}

	
	//2016.07.28 seulki
	@RequestMapping("/mainscreen")
	public @ResponseBody void main_screen(){
		return ;
	}
	
	//2016.07.28 seulki
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
	
	//2016.07.29 seulki
	//search placeId and return (플레이스 아이디로 검색 후 해당하는 플레이스 정보를 반환)
	@RequestMapping("/users/{plcId}")
	public @ResponseBody PlcInfo getPlace(@PathVariable String plcId){
		return placeInfoRepository.findOne(plcId);
	}
	
	//2016.07.29 seulki
//	@RequestMapping("/뭘 써야 할까....")
//	public @ResponseBody 

}

