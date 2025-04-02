package com.kh.start.token.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kh.start.token.model.vo.RefreshToken;

@Mapper
public interface TokenMapper {

	void saveToken(RefreshToken token);
	
	RefreshToken findByToken(String refreshToken);
	
	void deleteExpiredRefreshToken(Long now);

	
}
