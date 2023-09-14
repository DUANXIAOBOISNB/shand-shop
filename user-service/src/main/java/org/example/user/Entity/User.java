package org.example.user.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName(value ="User")
@Data
public class User {
	/**
	 *
	 */
	@TableId(type = IdType.AUTO)
	private Integer userid;

	/**
	 *
	 */
	private String username;

	/**
	 *
	 */
	private String email;

	/**
	 *
	 */
	private String password;

	/**
	 *
	 */
	private String fullname;

	/**
	 *
	 */
	private String address;

	/**
	 *
	 */
	private String phonenumber;
	private  String profile;
	private Date createDate;
	private Integer roleid;
	private String salt;


}
