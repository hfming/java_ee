package com.hfm.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
public class UploadAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private List<File> ppt;
	private List<String> pptContentType;
	private List<String> pptFileName;
	
	private List<String> pptDesc;

	public List<File> getPpt() {
		return ppt;
	}

	public void setPpt(List<File> ppt) {
		this.ppt = ppt;
	}

	public List<String> getPptContentType() {
		return pptContentType;
	}

	public void setPptContentType(List<String> pptContentType) {
		this.pptContentType = pptContentType;
	}

	public List<String> getPptFileName() {
		return pptFileName;
	}

	public void setPptFileName(List<String> pptFileName) {
		this.pptFileName = pptFileName;
	}

	public List<String> getPptDesc() {
		return pptDesc;
	}

	public void setPptDesc(List<String> pptDesc) {
		this.pptDesc = pptDesc;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(ppt);
		System.out.println(pptContentType);
		System.out.println(pptFileName);
		System.out.println(pptDesc);
		return "input";
	}
}
