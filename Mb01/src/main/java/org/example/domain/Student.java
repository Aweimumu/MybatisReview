package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Tolerate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private  int stuId;
    private String stuNum;
    private String stuName;
    private String stuGender;
    protected int stuAge;
}
