package cse.knu.ac.kr.daegu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cse.knu.ac.kr.daegu.Info.BeaconInfo;

public interface BeaconInfoRepository extends JpaRepository<BeaconInfo, String>{
	
	//placeInfo에 저장되어 있는 BeaconInfo를 찾는다
//	BeaconInfo findByPlaceInfoPlcIdAndBeamcadr(String plcId,String beaMcadr);

}
