package com.cg.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName laboratories
 */
@TableName(value ="laboratories")
@Data
@NoArgsConstructor
public class Laboratories implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer labId;

    /**
     * 
     */

    private String labName;
    @TableField(exist = false)
    private String status;
    /**
     * 
     */
    private Integer collegeId;
    @TableField(exist = false)
    private String collegeName;
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public Laboratories(String labName, Integer collegeId) {
        this.labName=labName;
        this.collegeId=collegeId;
    }

}