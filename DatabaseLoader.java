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
package org.gotprint;

import java.util.Date;

import org.gotprint.model.User;
import org.gotprint.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * @author dheeraj
 *
 */
@Component
public class DatabaseLoader implements CommandLineRunner {

	private final UserRepository userRepository;

	@Autowired
	public DatabaseLoader(UserRepository userRepository) {
		this.userRepository = userRepository;

	}

	@Override
	public void run(String... strings) throws Exception {

		if (null == userRepository.findById(Long.valueOf(1))) {
			User userObject1 = new User("dheeraj25in@gmail.com", "abc@1234",
					new Date(), new Date());
			this.userRepository.save(userObject1);
		}

		if (null == userRepository.findById(Long.valueOf(2))) {
			User userObject2 = new User("dheeraj237357in@gmail.com",
					"xyz@1234", new Date(), new Date());
			this.userRepository.save(userObject2);
		}
		if (null == userRepository.findById(Long.valueOf(3))) {
			User userObject3 = new User("vinayak@gmail.com", "vinayak@123",
					new Date(), new Date());
			this.userRepository.save(userObject3);
		}
		if (null == userRepository.findById(Long.valueOf(4))) {
			User userObject4 = new User("Sudheer@gmail.com", "sudheer@123",
					new Date(), new Date());
			this.userRepository.save(userObject4);
		}
	}
}
