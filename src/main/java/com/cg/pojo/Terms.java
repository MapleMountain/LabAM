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
 * @TableName terms
 */
@TableName(value ="terms")
@Data
public class Terms implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer termId;

    /**
     * 
     */
    private String termName;

    /**
     * 
     */
    private Date startDate;

    /**
     * 
     */
    private Date endDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Terms other = (Terms) that;
        return (this.getTermId() == null ? other.getTermId() == null : this.getTermId().equals(other.getTermId()))
            && (this.getTermName() == null ? other.getTermName() == null : this.getTermName().equals(other.getTermName()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTermId() == null) ? 0 : getTermId().hashCode());
        result = prime * result + ((getTermName() == null) ? 0 : getTermName().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", termId=").append(termId);
        sb.append(", termName=").append(termName);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}