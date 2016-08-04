package cse.knu.ac.kr.daegu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cse.knu.ac.kr.daegu.Info.MngInfo;
import cse.knu.ac.kr.daegu.Info.PlcInfo;

public interface MngInfoRepository extends JpaRepository<MngInfo, String>{
	

}
