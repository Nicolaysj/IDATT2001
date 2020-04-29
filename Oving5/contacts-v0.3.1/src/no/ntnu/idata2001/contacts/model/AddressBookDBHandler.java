package no.ntnu.idata2001.contacts.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.Iterator;

public class AddressBookDBHandler implements AddressBook{

    private EntityManagerFactory entity_manager_factory =
            Persistence.createEntityManagerFactory("contacts-idi");

    private EntityManager em = entity_manager_factory.createEntityManager();

    @Override
    public void addContact(ContactDetails contact) {

        EntityTransaction et = null;
        try{
            et = em.getTransaction();
            et.begin();
            em.persist(contact);
            et.commit();
        } catch(Exception e) {
            if (et != null) et.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void removeContact(String phoneNumber) {
        EntityTransaction et = null;
        try{
            et = em.getTransaction();
            et.begin();
            ContactDetails cd = em.createQuery("select object(p) from ContactDetails p where p.phone =:phone", ContactDetails.class).setParameter("phone", phoneNumber).getSingleResult();
            em.remove(cd);
            et.commit();
        } catch (Exception e) {
            if (et != null) et.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Collection<ContactDetails> getAllContacts() {
        try{
            return em.createQuery("select object(p) from ContactDetails p", ContactDetails.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Iterator<ContactDetails> iterator() {
        return getAllContacts().iterator();
    }

    @Override
    public void close() {
        em.close();
        entity_manager_factory.close();
    }
}
