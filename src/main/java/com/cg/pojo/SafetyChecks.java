package com.cg.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName safety_checks
 */
@TableName(value ="safety_checks")
@Data
public class SafetyChecks implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer checkId;

    /**
     * 
     */
    private Integer termId;

    /**
     * 
     */
    private Integer labId;

    /**
     * 
     */
    private Integer managerId;


    /**
     * 
     */
    private Integer windowCheck;

    /**
     * 
     */
    private Integer electricalCheck;

    /**
     * 
     */
    private Integer fireSafetyCheck;

    /**
     * 
     */
    private Integer equipmentCheck;

    /**
     * 
     */
    private Integer itemsPlacementCheck;

    /**
     * 
     */
    private Integer cleanlinessCheck;

    /**
     * 
     */
    private String otherHazards;

    /**
     * 
     */
    private String status;

    /**
     * 
     */
    private Date reportTime;

    /**
     * 
     */
    private Date resolvedTime;

    @TableField(exist = false)
    private String termName;
    @TableField(exist = false)
    private String labName;
    @TableField(exist = false)
    private String username;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}