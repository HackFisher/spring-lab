package com.flybyu.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name="t_user_relation")
public class UserRelation {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="user_id") private int userId;
    @Column(name="follow_id") private int followId;
    @Column(name="type") private int relation;
    
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

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setFollowId(int followId) {
		this.followId = followId;
	}

	public int getFollowId() {
		return followId;
	}

	public void setRelation(int relation) {
		this.relation = relation;
	}

	public int getRelation() {
		return relation;
	}
}
