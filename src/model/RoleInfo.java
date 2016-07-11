package model;

public class RoleInfo {
	int roleId;
	String roleName;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public RoleInfo(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}
	public RoleInfo() {
	}
	@Override
	public String toString() {
		return "roleInfo [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
	
}
