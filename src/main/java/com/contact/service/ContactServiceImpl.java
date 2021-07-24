package com.contact.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.contact.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService{
	
	// fake List of contacts
	List<Contact> list= List.of(
			new Contact(1L,"faizan@gmail.com","Faizan",11L),
	new Contact(2L,"Saif@gmail.com","Saif",11L),
	new Contact(3L,"kareem@gmail.com","Kareem",12L),
	new Contact(4L,"Tushar@gmail.com","Tushar",13L));

	@Override
	public List<Contact> getContactsOfUser(Long userId) {
		
		return list.stream().filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());
	}

}
