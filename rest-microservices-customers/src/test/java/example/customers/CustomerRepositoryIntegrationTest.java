package example.customers;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/*
 * Copyright 2014 the original author or authors.
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

/**
 * @author Oliver Gierke
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryIntegrationTest {

	@Autowired CustomerRepository repository;

	@Test
	public void testname() {

		Customer customer = new Customer();
		customer.setFirstname("Dave"); //Origin : Dave
		customer.setLastname("Matthews"); //Origin : Matthews
		customer.setAddress(new Address("street", "zipCode", "city", new Location(55.349451, -131.673817)));

		//customer = repository.save(customer);
		
		//assertThat(repository.findById(customer.id), is(customer));
		Customer savedCustomer = repository.save(customer);
        Optional<Customer> retrievedCustomer = repository.findById(savedCustomer.getId());

        // Then
        assertThat(retrievedCustomer.isPresent(), is(true));
        assertThat(retrievedCustomer.get(), is(customer));
	}
}
