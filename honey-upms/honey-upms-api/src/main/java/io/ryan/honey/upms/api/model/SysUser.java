package io.ryan.honey.upms.api.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

/**
 * SysUser
 *
 * @author hkc
 * @version 1.0.0
 * @date 2021-08-10 10:04
 */
@TableName("sys_user")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 真实名称
     */
    private String realityName;

    /**
     * 密码
     */
    private String password;

    /**
     * 随机盐
     */
    private String salt;

    /**
     * 创建时间
     */
    private LocalDateTime createdDate;

    /**
     * 更新时间
     */
    private LocalDateTime updateDate;

    /**
     * 用户状态(1正常,0锁定)
     */
    private Integer status;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 部门id(可以存在多个)
     */
    private List<Integer> deptId;

    /**
     * 删除标记
     */
    @TableLogic(value = "0", delval = "1")
    private Integer deletedFlag;
}
