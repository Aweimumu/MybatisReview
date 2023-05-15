package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.dao.DetailDAO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private int userId;
    private String userName;
    private String userPwd;
    private String userRealname;
    private String userImg;
    private  Detail detail;
    public User(int userId, String userName, String userPwd, String userRealname, String userImg) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userRealname = userRealname;
        this.userImg = userImg;
    }



}