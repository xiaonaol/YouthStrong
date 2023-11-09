package xyz.zrxjuly.dao.entity;

import java.util.Date;

public class VolunteerEntity {
    private String volunteer_account; // 志愿者用户名
    private String volunteer_password; // 密码
    private String volunteer_name; // 姓名
    private String volunteer_gender; // 性别
    private String volunteer_email; // 邮箱
    private Date volunteer_creation_date; // 创建日期
    private Date volunteer_birthday; // 生日
    private String volunteer_age; // 年龄
    private String volunteer_picture; // 头像
    private String volunteer_description; // 个人描述
    private String volunteer_school; // 学校
    private String volunteer_address; // 地址
    private String volunteer_identity; // 身份
    private String volunteer_created_by;//管理员创建

    public String getVolunteer_created_by() {
        return volunteer_created_by;
    }

    public void setVolunteer_created_by(String volunteer_created_by) {
        this.volunteer_created_by = volunteer_created_by;
    }

    public String getVolunteer_account() {
        return volunteer_account;
    }

    public void setVolunteer_account(String volunteer_account) {
        this.volunteer_account = volunteer_account;
    }

    public String getVolunteer_password() {
        return volunteer_password;
    }

    public void setVolunteer_password(String volunteer_password) {
        this.volunteer_password = volunteer_password;
    }

    public String getVolunteer_name() {
        return volunteer_name;
    }

    public void setVolunteer_name(String volunteer_name) {
        this.volunteer_name = volunteer_name;
    }

    public String getVolunteer_gender() {
        return volunteer_gender;
    }

    public void setVolunteer_gender(String volunteer_gender) {
        this.volunteer_gender = volunteer_gender;
    }

    public String getVolunteer_email() {
        return volunteer_email;
    }

    public void setVolunteer_email(String volunteer_email) {
        this.volunteer_email = volunteer_email;
    }

    public Date getVolunteer_creation_date() {
        return volunteer_creation_date;
    }

    public void setVolunteer_creation_date(Date volunteer_creation_date) {
        this.volunteer_creation_date = volunteer_creation_date;
    }

    public Date getVolunteer_birthday() {
        return volunteer_birthday;
    }

    public void setVolunteer_birthday(Date volunteer_birthday) {
        this.volunteer_birthday = volunteer_birthday;
    }

    public String getVolunteer_age() {
        return volunteer_age;
    }

    public void setVolunteer_age(String volunteer_age) {
        this.volunteer_age = volunteer_age;
    }

    public String getVolunteer_picture() {
        return volunteer_picture;
    }

    public void setVolunteer_picture(String volunteer_picture) {
        this.volunteer_picture = volunteer_picture;
    }

    public String getVolunteer_description() {
        return volunteer_description;
    }

    public void setVolunteer_description(String volunteer_description) {
        this.volunteer_description = volunteer_description;
    }

    public String getVolunteer_school() {
        return volunteer_school;
    }

    public void setVolunteer_school(String volunteer_school) {
        this.volunteer_school = volunteer_school;
    }

    public String getVolunteer_address() {
        return volunteer_address;
    }

    public void setVolunteer_address(String volunteer_address) {
        this.volunteer_address = volunteer_address;
    }

    public String getVolunteer_identity() {
        return volunteer_identity;
    }

    public void setVolunteer_identity(String volunteer_identity) {
        this.volunteer_identity = volunteer_identity;
    }

    @Override
    public String toString() {
        return "VolunteerEntity{" +
                "volunteer_account='" + volunteer_account + '\'' +
                ", volunteer_password='" + volunteer_password + '\'' +
                ", volunteer_name='" + volunteer_name + '\'' +
                ", volunteer_gender='" + volunteer_gender + '\'' +
                ", volunteer_email='" + volunteer_email + '\'' +
                ", volunteer_creation_date=" + volunteer_creation_date +
                ", volunteer_birthday=" + volunteer_birthday +
                ", volunteer_age='" + volunteer_age + '\'' +
                ", volunteer_picture='" + volunteer_picture + '\'' +
                ", volunteer_description='" + volunteer_description + '\'' +
                ", volunteer_school='" + volunteer_school + '\'' +
                ", volunteer_address='" + volunteer_address + '\'' +
                ", volunteer_identity='" + volunteer_identity + '\'' +
                ", volunteer_created_by='" + volunteer_created_by + '\'' +
                '}';
    }


}
