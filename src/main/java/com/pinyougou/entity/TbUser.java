package com.pinyougou.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TbUser implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 443459039884735965L;

	private Integer id;

    private String name;

    private String pwd;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createdatetime;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date modifydatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public Date getCreatedatetime() {
        return createdatetime;
    }

    public void setCreatedatetime(Date createdatetime) {
        this.createdatetime = createdatetime;
    }

    public Date getModifydatetime() {
        return modifydatetime;
    }

    public void setModifydatetime(Date modifydatetime) {
        this.modifydatetime = modifydatetime;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TbUser other = (TbUser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TbUser [id=" + id + ", name=" + name + ", pwd=" + pwd
				+ ", createdatetime=" + createdatetime + ", modifydatetime="
				+ modifydatetime + "]";
	}
    
}