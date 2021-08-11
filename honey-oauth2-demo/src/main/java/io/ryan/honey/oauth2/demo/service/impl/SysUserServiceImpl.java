package io.ryan.honey.oauth2.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.ryan.honey.oauth2.demo.mapper.SysUserMapper;
import io.ryan.honey.oauth2.demo.model.SysUser;
import io.ryan.honey.oauth2.demo.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * SysUserServiceImpl
 *
 * @author hkc
 * @version 1.0.0
 * @date 2021-08-11 16:55
 */
@Service
@Transactional(rollbackFor = Exception.class, timeout = 5000)
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
