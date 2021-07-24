package com.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.repository.Repository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private Repository repo;

	@Override
	public User getUser(Long id) {

		User userentity = null;
		try {
			if (id != null && id > 0) {
				userentity = repo.findById(id).orElseThrow(() -> new AttributeNotFoundException(" data not found"));

			} else {
				throw new Exception("No Data Found");
			}
		} catch (AttributeNotFoundException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return userentity;
		// return ;

	}

	@Override
	public List getAllEmployee() {

		List<User> user = repo.findAll();

		if (user != null && !user.isEmpty()) {
			return user.stream().collect(Collectors.toList());
		}
		return new ArrayList<>();

	}

	@Override
	public User addnewUser(User user) {
		User user1 = null;

		try {

			if (user != null) {

				repo.save(user);
				// employeedto.setEmpId(empEntity.getEmpId());
			} else {
				throw new Exception("No User id found");
			}
			return user1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user1;
	}

	@Override
	public void updateUser(User user) throws Exception {

		if (user != null) {

			repo.save(user);
		} else {
			throw new Exception("data not found");
		}

	}

	@Override
	public void deleteUser(Long userid) throws Exception {
		
		if (userid != null && userid > 0) {
			User user = repo.findById(userid)
					.orElseThrow(() -> new Exception("User id Not found"));
			if (user != null && user.getUserId() != null) {
				repo.delete(user);
			}
		} else {
			throw new Exception("Unable to Delete Data");
		}

	}

}
