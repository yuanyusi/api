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
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Greg Turnquist
 */
// tag::code[]
@Component
public class DatabaseLoader implements CommandLineRunner {

	private final GoalRepository repository;

	@Autowired
	public DatabaseLoader(GoalRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception {
		ArrayList<Date> myStringArray = new ArrayList<Date>();
		ArrayList<Date>  myFailureArray = new ArrayList<Date>();
		

		this.repository.save(new Goal("Frodo", myStringArray, myFailureArray, null, null));
		this.repository.save(new Goal("Bilbo", myStringArray, myFailureArray, null, null));
		this.repository.save(new Goal("Gandalf", myStringArray, myFailureArray, null, null));
		this.repository.save(new Goal("Samwise", myStringArray, myFailureArray, null, null));
		this.repository.save(new Goal("Meriadoc", myStringArray, myFailureArray, null, null));
		this.repository.save(new Goal("Peregrin", myStringArray, myFailureArray, null, null));
	}
}
// end::code[]