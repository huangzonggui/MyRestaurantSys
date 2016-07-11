package model;

public class Userinfo {
	int userId,role,locked;
	String userAccount,userPass,faceimg;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getLocked() {
		return locked;
	}

	public void setLocked(int locked) {
		this.locked = locked;
	}

	public String getFaceimg() {
		return faceimg;
	}

	public void setFaceimg(String faceimg) {
		this.faceimg = faceimg;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}


	public Userinfo(int userId, int role, int locked, String faceimg,
			String userAccount, String userPass) {
		super();
		this.userId = userId;
		this.role = role;
		this.locked = locked;
		this.faceimg = faceimg;
		this.userAccount = userAccount;
		this.userPass = userPass;
	}

	public Userinfo() {
	}

	@Override
	public String toString() {
		return "userinfo [userId=" + userId + ", role=" + role + ", locked="
				+ locked + ", faceimg=" + faceimg + ", userAccount="
				+ userAccount + ", userPass=" + userPass + ", faceing="
				 + "]";
	}



}
