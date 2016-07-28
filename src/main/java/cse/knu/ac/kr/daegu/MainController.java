package cse.knu.ac.kr.daegu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {

	@Autowired
	private UserInfoRepository userInfoRepository;
	@Autowired
	private PlaceInfoRepository placeInfoRepository;

	
	//<login>
	// 2016.07.27 seulki
	// login_place
	@RequestMapping("/users_login/place")
	   public @ResponseBody String login(@RequestBody PlaceInfo place) {
	      PlaceInfo foundPlace = placeInfoRepository.findOne(place.getPlcId());

	      // Doesn't exist user info (플레이 정보가 없을 경우)
	      if (foundPlace == null){
	         System.out.println("place★★★★★★아이디 없음★★★★★★");
	         return "fail";
	      }
	      else {
	         // collect password (패스워드가 일치할 경우)
	         if (place.getPlcPw().equals(foundPlace.getPlcPw())){
	            System.out.println("place★★★★★★로그인 성공★★★★★★");
	            return "success";
	         }

	         // wrong password (패스워드를 틀렸을 경우)
	         else{
	            System.out.println("place★★★★★★비밀번호 없음★★★★★★");
	            return "fail";
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
	         return "fail";
	      }
	      else {
	         // collect password (패스워드가 일치할 경우)
	         if (user.getUserPw().equals(foundUser.getUserPw())){
	            System.out.println("user★★★★★★로그인 성공★★★★★★");
	            return "success";
	         }

	         // wrong password (패스워드를 틀렸을 경우)
	         else{
	            System.out.println("user★★★★★★비밀번호 없음★★★★★★");
	            return "fail";
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
	         return "success";
	      }
	      //exist same information (일치하는 정보가 존재한다면)
	      else {
	         System.out.println("user ★★★★★★아이디 중복★★★★★★");
	         return "duplicate";

	      }
	   }

	   // 2016.07.27 seulki
	   // add new place (새로운 place 추가)
	   @RequestMapping(value = "/users/place", method = RequestMethod.POST, consumes = "application/json")
	   public @ResponseBody String addUser(@RequestBody PlaceInfo place) {

	      //doesnt exist same information (일치하는 정보가 없다)
	      if (placeInfoRepository.findOne(place.getPlcId()) == null) {
	         System.out.println("place★★★★★★★회원가입 성공★★★★★");
	         
	         //save information (정보를 저장하고)
	         placeInfoRepository.save(place);

	         return "success";
	      }

	      //exist same information (일치하는 정보가 존재한다면)
	      else{
	         System.out.println("place★★★★★★아이디 중복★★★★★★");
	         return "duplicate";
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
	@RequestMapping("/mainscreen/bcon_sign/{plcId}")
	public @ResponseBody String bcon_sign(@PathVariable String plcId, @RequestBody BeaconInfo Bcon){
		
		PlaceInfo foundplace = placeInfoRepository.findOne(plcId);
		
		if(foundplace == null)
		{
			System.out.println("place ★★★★★★Plc Id 일치하는 정보 없★★★★★★");
			return "fail";
		}
		
		else
		{
			foundplace.setbeaconInfo(Bcon);
			
			placeInfoRepository.save(foundplace);
			
			System.out.println("place ★★★★★★PlaceInfo 정보 없데이★★★★★★");
			
			return "success";
		}
	}
	
}

