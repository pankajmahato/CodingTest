package com.mindtree.test;

public class InstanceStatus {
	private int passCount;
	private int failCount;





	public int getPassCount() {
		return passCount;
	}





	public void setPassCount(int passCount) {
		this.passCount = passCount;
	}





	public int getFailCount() {
		return failCount;
	}





	public void setFailCount(int failCount) {
		this.failCount = failCount;
	}





	public InstanceStatus(int passCount, int failCount) {
		this.passCount = passCount;
		this.failCount = failCount;
	}

}
