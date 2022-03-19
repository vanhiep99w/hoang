package hoangdang.bookstore.service;

import java.util.List;


import hoangdang.bookstore.entity.Contact;
import hoangdang.bookstore.model.ContactModel;

public interface ContactService {
	ContactModel createContact(ContactModel contactModel);

	List<Contact> getListContactPending();

	Contact getContactByContactId(Integer id);

	void approveContact(Integer id);

	void delete(Integer id);

	List<Contact> getListContactChecked();
	
	List<Contact> findAll();
}
