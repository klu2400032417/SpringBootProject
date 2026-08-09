package com.klef.soa.entity;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Team {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @Column(name="tname",length = 50)
 private String name;
 @Column(name="ttype",length =100)
 private String type;
 @Column(name="tstatus",length=10)
 private String status;
 private String location;
 @CreationTimestamp
 private Date createdAt;
 @UpdateTimestamp
 private Date UpdatedAt;
 public Long getId() {
	return id;
 }
 public void setId(Long id) {
	this.id = id;
 }
 public String getName() {
	return name;
 }
 public void setName(String name) {
	this.name = name;
 }
 public String getType() {
	return type;
 }
 public void setType(String type) {
	this.type = type;
 }
 public String getStatus() {
	return status;
 }
 public void setStatus(String status) {
	this.status = status;
 }
 public String getLocation() {
	return location;
 }
 public void setLocation(String location) {
	this.location = location;
 }
 public Date getCreatedAt() {
	return createdAt;
 }
 public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
 }
 public Date getUpdatedAt() {
	return UpdatedAt;
 }
 public void setUpdatedAt(Date updatedAt) {
	UpdatedAt = updatedAt;
 }
 @Override
 public String toString() {
	return "Team [id=" + id + ", name=" + name + ", type=" + type + ", status=" + status + ", location=" + location
			+ ", createdAt=" + createdAt + ", UpdatedAt=" + UpdatedAt + "]";
 }
 
 
}
