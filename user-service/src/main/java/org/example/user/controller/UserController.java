package org.example.user.controller;

import com.springcloud.common.Exception.BusinessException;
import com.springcloud.common.Exception.ErrorCodeimpl;
import com.springcloud.common.Vo.CommonResult;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.feign.result.Result;
import org.example.feign.util.ResultUtil;
import org.example.user.Dto.LoginDto;

import org.example.user.Dto.RegisterDto;
import org.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.UUID;

@RestController
@RequestMapping("user")
// @Api(tags = "Userloginmodel ")
public class UserController {
	@Autowired
	private UserService userService;
	@Resource
	MinioClient minioClient;

	@Value("${minio.endPoint}")
	String endPoint;

	@Value("${minio.bucketName}")
	String bucketName;
	@PostMapping("/login")
	// @ApiOperation("用户注册接口")
	public CommonResult<String> login(@RequestBody LoginDto loginDto)
	{
		return CommonResult.<String>builder()
				.data(userService.login(loginDto))
				.build();
	}
	@PostMapping("/register")
	public CommonResult<String> register(@RequestBody RegisterDto registerDto)
	{
		return CommonResult.<String>builder()
				.data(userService.register(registerDto))
				.build();
	}
	@PostMapping("/uploadprofile")
	public CommonResult<String> uploadCover(@RequestPart("file") MultipartFile coverFile) {
		// 获得用户上传的原始文件名
		String coverOrgFileName = coverFile.getOriginalFilename();
		assert coverOrgFileName != null;
		String coverExt = coverOrgFileName.substring(coverOrgFileName.lastIndexOf(".") + 1).toLowerCase();
		String coverPikId = UUID.randomUUID().toString().replaceAll("-", "");
		String coverPath = "/userprofile/" + coverPikId + "." + coverExt;

		try {
			// 开始上传封面
			InputStream in = coverFile.getInputStream();
			minioClient.putObject(
					PutObjectArgs.builder()
							.bucket(bucketName)
							.object(coverPath)
							.stream(in, coverFile.getSize(), -1)
							.contentType(coverFile.getContentType())
							.build());
			in.close();
			// return ResultUtil.buildSuccessResult("上传成功", endPoint + bucketName + coverPath);
			return CommonResult.<String>builder()
					.data(endPoint + bucketName + coverPath)
					.build();

		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorCodeimpl.UNKNOWN);
			// return ResultUtil.buildFailResult("上传失败", null);
		}
	}
}
