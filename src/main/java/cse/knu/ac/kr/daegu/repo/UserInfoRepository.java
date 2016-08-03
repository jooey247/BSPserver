package cse.knu.ac.kr.daegu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cse.knu.ac.kr.daegu.Info.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, String>{

}
