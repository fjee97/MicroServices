package com.user.unittest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.user.entity.User;
import com.user.repository.Repository;
import com.user.service.UserServiceImpl;


@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class ApplicationTest {

		@InjectMocks
		private UserServiceImpl userService;

		@Mock
		private Repository repo;

		@Test
		public void test() throws Exception {
			userService.addnewUser(new User());
			userService.updateUser(new User());
			userService.getUser(231L);
			

		}
	
}
