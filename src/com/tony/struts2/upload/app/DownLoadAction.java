package com.tony.struts2.upload.app;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownLoadAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String contentType;
	private long contentLength;
	private String contentDisposition;
	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public long getContentLength() {
		return contentLength;
	}

	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentType() {

		return null;
	}

	@Override
	public String execute() throws Exception {

		// Values of fields
		contentType = "text/js";
		contentDisposition = "attachment;filename=ajax.js";

		ServletContext servletContext = ServletActionContext.getServletContext();
		String fileName = servletContext.getRealPath("/files/ajax.js");

		inputStream = new FileInputStream(fileName);
		contentLength = inputStream.available();

		return SUCCESS;
	}

}
