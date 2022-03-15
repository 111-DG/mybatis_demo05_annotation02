package org.db.soft.base.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Utils {

	public Utils() {

	}

	public static SqlSessionFactory sqlSessionFactory = null;

	public SqlSessionFactory getSqlSessionFactory() {
		if (sqlSessionFactory == null) {
			InputStream in = null;
			try {
				in = Resources.getResourceAsStream("mybatis_configuration.xml");
			} catch (IOException e) {
				e.printStackTrace();
			}
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		}
		return sqlSessionFactory;
	}
	
	public SqlSession getSqlSession() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		return  sqlSession;
	}
	
	public void commitAndClose(SqlSession sqlSession) {
		sqlSession.commit();
		sqlSession.close();
	}

}
