package com.hby.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private Integer id;
	private String name;
	private String address;
	private String birth_date;
	private String create_date;
	public Integer getId() {
		return id;
	}
}
