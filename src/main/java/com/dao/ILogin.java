package com.dao;

import javax.servlet.http.HttpServletRequest;

import com.entity.Operator;

public interface ILogin
{
	// 检验账号是否匹配
	public String login(HttpServletRequest request, Operator operator);
}
