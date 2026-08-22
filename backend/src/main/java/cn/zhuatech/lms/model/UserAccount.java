/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.lms.model;
import jakarta.persistence.*;
@Entity @Table(name="lms_user")
public class UserAccount extends BaseEntity {
    public enum Role { ADMIN, LMS_MANAGER, LEARNER, QUALITY }
    @Column(nullable=false,unique=true,length=32) private String username; @Column(nullable=false) private String password;
    @Column(nullable=false,length=50) private String fullName; @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private Role role;
    @Column(name="academy_code",length=32) private String academyCode; @Column(nullable=false) private boolean enabled=true;
    protected UserAccount(){}
    public UserAccount(String username,String password,String fullName,Role role,String academyCode){this.username=username;this.password=password;this.fullName=fullName;this.role=role;this.academyCode=academyCode;}
    public String getUsername(){return username;} public String getPassword(){return password;} public String getFullName(){return fullName;} public Role getRole(){return role;} public String getAcademyCode(){return academyCode;} public boolean isEnabled(){return enabled;}
}
