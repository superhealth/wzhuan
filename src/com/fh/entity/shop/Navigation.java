package com.fh.entity.shop;

import java.util.Date;

/** 
 * 类名称：Navigation
 * 创建人：MAMY 
 * 创建时间：2015-4-14
 */
public class Navigation{
	private String NAVIGATION_ID;
	private Date CREATE_DATE;
	private Date MODIFY_DATE;
	private Integer ORDERS;
	/** 名称 */
	private String NAME;
	/** 位置 */
	private Integer  POSITION;
	/** 链接地址 */
	private String URL;
	/** 是否新窗口打开 */
	private int ISBLANKTARGET;

	public String getNAVIGATION_ID() {
		return NAVIGATION_ID;
	}

	public void setNAVIGATION_ID(String nAVIGATIONID) {
		NAVIGATION_ID = nAVIGATIONID;
	}

	public Date getCREATE_DATE() {
		return CREATE_DATE;
	}

	public void setCREATE_DATE(Date cREATEDATE) {
		CREATE_DATE = cREATEDATE;
	}

	public Date getMODIFY_DATE() {
		return MODIFY_DATE;
	}

	public void setMODIFY_DATE(Date mODIFYDATE) {
		MODIFY_DATE = mODIFYDATE;
	}

	public Integer getORDERS() {
		return ORDERS;
	}

	public void setORDERS(Integer oRDERS) {
		ORDERS = oRDERS;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public Integer getPOSITION() {
		return POSITION;
	}

	public void setPOSITION(Integer pOSITION) {
		POSITION = pOSITION;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public int getISBLANKTARGET() {
		return ISBLANKTARGET;
	}

	public void setISBLANKTARGET(int iSBLANKTARGET) {
		ISBLANKTARGET = iSBLANKTARGET;
	}


}