/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.greglturnquist.payroll;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Greg Turnquist
 */
// tag::code[]
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Goal {

	private @Id @GeneratedValue Long id;
	private ArrayList<Date> successes = new ArrayList<Date>();
	private ArrayList<Date> failures = new ArrayList<Date>();
	private String description;
	
	@Temporal(TemporalType.DATE)
	@CreatedDate
	private Date createdAt;
	
	@Temporal(TemporalType.DATE)
	@Column(insertable=false, updatable=true)
	@LastModifiedDate
	private Date updatedAt;

	private @Version @JsonIgnore Long version;

	private Goal() {}

	public Goal(String description, ArrayList<Date> successes, ArrayList<Date> failures, Date createdAt,  Date updatedAt ) {
		this.successes = successes;
		this.failures = failures;
		this.description = description;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
}
// end::code[]