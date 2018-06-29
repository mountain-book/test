package com.internousdev.ecsite2.action;

import com.opensymphony.xwork2.ActionSupport;

public class GoHomeAction extends ActionSupport /*implements SessionAware*/{
	/*private Map<String,Object> session;*/

	public String execute() {
		return SUCCESS;
	}

	/*@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}*/
}

//sessionを実装しなくても、sessionは消滅しない？