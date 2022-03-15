package org.db.soft.base.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonInfo {
    private int personInfoId;
    private String personInfoDescribe;
    private int personId;
}
