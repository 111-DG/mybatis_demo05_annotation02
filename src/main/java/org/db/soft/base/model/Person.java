package org.db.soft.base.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	private int personId;
	private String personName;
	private String personEmail;
	private PersonInfo personInfo;
	private List<Phone> phones;
}
