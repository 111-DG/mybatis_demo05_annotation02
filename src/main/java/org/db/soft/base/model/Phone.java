package org.db.soft.base.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Phone {
    private int phoneId;
    private String phoneName;
    private int personId;
}
