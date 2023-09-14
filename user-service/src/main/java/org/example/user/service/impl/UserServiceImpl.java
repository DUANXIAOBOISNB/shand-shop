package org.example.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.common.Exception.BusinessException;
import com.springcloud.common.Exception.ErrorCodeimpl;
import lombok.RequiredArgsConstructor;
import org.example.user.Dto.LoginDto;

import org.example.user.Dto.RegisterDto;
import org.example.user.Entity.User;
import org.example.user.Utils.JwtUtil;
import org.example.user.Utils.SaltEncryption;
import org.example.user.Vo.TokenVo;
import org.example.user.service.UserService;
import org.example.user.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @author Administrator
 * @description 针对表【User】的数据库操作Service实现
 * @createDate 2023-09-12 10:32:08
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

	private final UserMapper userMapper;

	public String login(LoginDto loginDto) {
		User user = userMapper.selectOne(new QueryWrapper<User>().eq("Username", loginDto.getUsername()));
		if (user == null) {
			throw new BusinessException(ErrorCodeimpl.E_100102);
		}
		String finalpassword = SaltEncryption.saltEncryption(loginDto.getPassword(),user.getSalt() );
        if(user.getPassword().equals(finalpassword))
        {
			return JwtUtil.createtoken(user);
        }
		else {
			throw  new BusinessException(ErrorCodeimpl.E_100101);
        }

	}

	@Override
	public String register(RegisterDto registerDto) {
		if (!checkusername(registerDto.getUsername())) {
			throw new BusinessException(ErrorCodeimpl.E_100103);
		}
		String salt = UUID.randomUUID().toString().substring(0, 6);
		String finalpassword = SaltEncryption.saltEncryption(registerDto.getPassword(), salt);
		User user = new User();
		BeanUtils.copyProperties(registerDto, user);
		user.setPassword(finalpassword);
		user.setCreateDate(new Date());
		user.setSalt(salt);
		userMapper.insert(user);
		String logintoken = JwtUtil.createtoken(user);
		return logintoken;
	}

	public Boolean checkusername(String username) {
		return userMapper.selectCount(new QueryWrapper<User>().eq("Username", username)) < 1;
	}

}




