package com.springcloud.store.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName Product
 */
@Data
public class Product implements Serializable {
    /**
     * 产品ID（主键）
     */
    private Integer productid;

    /**
     *  产品标题
     */
    private String title;

    /**
     * 产品描述
     */
    private String description;

    /**
     * 产品原价格
     */
    private BigDecimal oldprice;

    /**
     * 产品价格
     */
    private BigDecimal price;

    /**
     * 产品类别ID（外键，关联到Category表）
     */
    private Integer categoryid;

    /**
     * 卖家ID（外键，关联到User表
     */
    private Integer sellerid;

    /**
     *  创建时间
     */
    private Date createdat;

    /**
     * 更新时间
     */
    private Date updatedat;

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
        Product other = (Product) that;
        return (this.getProductid() == null ? other.getProductid() == null : this.getProductid().equals(other.getProductid()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getOldprice() == null ? other.getOldprice() == null : this.getOldprice().equals(other.getOldprice()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getCategoryid() == null ? other.getCategoryid() == null : this.getCategoryid().equals(other.getCategoryid()))
            && (this.getSellerid() == null ? other.getSellerid() == null : this.getSellerid().equals(other.getSellerid()))
            && (this.getCreatedat() == null ? other.getCreatedat() == null : this.getCreatedat().equals(other.getCreatedat()))
            && (this.getUpdatedat() == null ? other.getUpdatedat() == null : this.getUpdatedat().equals(other.getUpdatedat()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProductid() == null) ? 0 : getProductid().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getOldprice() == null) ? 0 : getOldprice().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getCategoryid() == null) ? 0 : getCategoryid().hashCode());
        result = prime * result + ((getSellerid() == null) ? 0 : getSellerid().hashCode());
        result = prime * result + ((getCreatedat() == null) ? 0 : getCreatedat().hashCode());
        result = prime * result + ((getUpdatedat() == null) ? 0 : getUpdatedat().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productid=").append(productid);
        sb.append(", title=").append(title);
        sb.append(", description=").append(description);
        sb.append(", oldprice=").append(oldprice);
        sb.append(", price=").append(price);
        sb.append(", categoryid=").append(categoryid);
        sb.append(", sellerid=").append(sellerid);
        sb.append(", createdat=").append(createdat);
        sb.append(", updatedat=").append(updatedat);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}