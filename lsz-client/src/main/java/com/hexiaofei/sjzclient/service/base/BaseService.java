package com.hexiaofei.sjzclient.service.base;

import org.apache.ibatis.session.SqlSession;

/**
 * 所有Service的基类，用来注入sqlSession
 *
 */
public class BaseService
{
	/**
	 * 可写的sqlSession
	 */
	protected SqlSession writableSQLSession;
	
	/**
	 * 只读的sqlSession
	 */
	protected SqlSession readonlySQLSession;

	public void setWritableSQLSession(SqlSession writableSQLSession)
	{
		this.writableSQLSession = writableSQLSession;
	}

	public void setReadonlySQLSession(SqlSession readonlySQLSession)
	{
		this.readonlySQLSession = readonlySQLSession;
	}

}
