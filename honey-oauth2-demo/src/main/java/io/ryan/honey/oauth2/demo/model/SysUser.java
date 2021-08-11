package io.ryan.honey.oauth2.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * SysUser
 *
 * @author Ryan
 * @version 1.0.0
 * @date 2021-08-11 16:51
 */
@TableName("tb_user")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer userId;

    private String username;

    private String realityName;

    private String password;

    private String mobile;

    private LocalDateTime createdDate;

    @Override
    public Serializable pkVal() {
        return this.userId;
    }
}
