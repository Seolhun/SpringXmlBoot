package com.shun.blog.model.user;

import java.sql.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

public class UserRoleVO {
	@Pattern(regexp="(^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$)" ,message="올바른 이메일 형식이 아닙니다.")
	private String account_role_idx;
	
	@Pattern(regexp="([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9]){8,12}" ,message="숫자와 영문자, 특수문자를 포함한 8 ~ 12자를 입력하세요.")
	private String account;
	private String userRole;
	public String getAccount_role_idx() {
		return account_role_idx;
	}
	public void setAccount_role_idx(String account_role_idx) {
		this.account_role_idx = account_role_idx;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
}