package entity;/**
 * @author shkstart
 * @create 2021-01-18 22:10
 */

import java.util.Date;

/**
 * @program: wwqShop
 *
 * @description:user实体类
 *
 * @author: wwq
 *
 * @create: 2021-01-18 22:10
 **/
public class User {
    private String username;
    private String nickname;
    private String password;
    private String sex;
    private String mobile;
    private String birthday;
    private String address;
    private String code;
    private String email;
    private Integer status;

    public User() {
    }

    public User(String username, String nickname, String password, String sex, String mobile, String birthday, String address, String code, String email, int status) {
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.sex = sex;
        this.mobile = mobile;
        this.birthday = birthday;
        this.address = address;
        this.code = code;
        this.email = email;
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "username=" + username +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", mobile='" + mobile + '\'' +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                ", code='" + code + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
