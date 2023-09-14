package org.example.user.service;

import org.example.user.Dto.LoginDto;

import org.example.user.Dto.RegisterDto;
import org.example.user.Entity.User;

import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【User】的数据库操作Service
* @createDate 2023-09-12 10:32:08
*/
public interface UserService extends IService<User> {
   String login(LoginDto loginDto);

   String register(RegisterDto registerDto);

}
