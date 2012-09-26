package com.flybyu.web.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name="ACTIVITIES")
public class Activity {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column private String name;
    @Column private Date timefrom;
    @Column private Date timeto;
    @Column private String type;
    
    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setTimefrom(Date timefrom) {
		this.timefrom = timefrom;
	}

	public Date getTimefrom() {
		return timefrom;
	}

	public void setTimeto(Date timeto) {
		this.timeto = timeto;
	}

	public Date getTimeto() {
		return timeto;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
