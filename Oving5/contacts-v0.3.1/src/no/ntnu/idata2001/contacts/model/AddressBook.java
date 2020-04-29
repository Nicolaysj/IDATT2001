package no.ntnu.idata2001.contacts.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

public interface AddressBook extends Iterable<ContactDetails> {

    void addContact(ContactDetails contact);
    void removeContact(String phoneNumber);
    Collection<ContactDetails> getAllContacts();
    Iterator<ContactDetails> iterator();
    void close();
}
