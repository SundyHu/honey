package io.ryan.honey.upms.api.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * SysRole
 *
 * @author hkc
 * @version 1.0.0
 * @date 2021-08-10 11:13
 */
@TableName("sys_role")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRole extends Model<SysRole> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer roleId;

    private String roleName;

    private String roleCode;

    private String roleDesc;

    private LocalDateTime createdDate;

    private LocalDateTime updateDate;

    private Integer status;

    private Integer sortNum;

    @TableLogic(value = "0", delval = "1")
    private Integer deletedFlag;
}
