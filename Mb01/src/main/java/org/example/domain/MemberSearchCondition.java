package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberSearchCondition {
    private  String gender;
    private Integer maxAge;
    private  Integer minAge;
    private String city;

    }

