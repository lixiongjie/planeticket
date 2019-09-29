package cus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ur name
 * @since 2019-09-29
 */
public class BdCustomerEducation implements Serializable {

    private static final long serialVersionUID=1L;


    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    private String cusid;

    private String degree;

    private LocalDateTime created;

    private LocalDateTime updated;

    private String creator;

    private String updator;

    private Integer deleted;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCusid() {
        return cusid;
    }

    public void setCusid(String cusid) {
        this.cusid = cusid;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "BdCustomerEducation{" +
        "id=" + id +
        ", cusid=" + cusid +
        ", degree=" + degree +
        ", created=" + created +
        ", updated=" + updated +
        ", creator=" + creator +
        ", updator=" + updator +
        ", deleted=" + deleted +
        "}";
    }
}
