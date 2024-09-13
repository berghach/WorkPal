package enums;

public enum Role {
    ADMIN("admin"),
    MEMBER("member"),
    MANAGER("manager");

    private final String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }
    public String getRoleName(){
        return roleName;
    }
}
