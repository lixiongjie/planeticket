package cus.entity;

import java.io.Serializable;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author ur name
 * @since 2019-09-29
 */
public class VCustomer implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    private String empname;

    private String empcode;

    private String degree;

    private String eid;

    private String cusid;

    private String creator;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getEmpcode() {
        return empcode;
    }

    public void setEmpcode(String empcode) {
        this.empcode = empcode;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getCusid() {
        return cusid;
    }

    public void setCusid(String cusid) {
        this.cusid = cusid;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "VCustomer{" +
        "id=" + id +
        ", empname=" + empname +
        ", empcode=" + empcode +
        ", degree=" + degree +
        ", eid=" + eid +
        ", cusid=" + cusid +
        ", creator=" + creator +
        "}";
    }
}
