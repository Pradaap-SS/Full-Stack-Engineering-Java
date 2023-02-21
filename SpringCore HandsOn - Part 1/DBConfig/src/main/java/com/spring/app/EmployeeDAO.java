package com.spring.app;

public class EmployeeDAO {
	private DBConfig dbConfig;
	public DBConfig getdbConfig(){
	    return dbConfig;
	}
	public void setdbConfig(DBConfig dbConfig){
	    this.dbConfig=dbConfig;
	}
}
