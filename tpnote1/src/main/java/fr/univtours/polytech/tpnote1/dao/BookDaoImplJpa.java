package fr.univtours.polytech.tpnote1.dao;
import java.util.List;

import fr.univtours.polytech.tpnote1.model.BookBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless 
public class BookDaoImplJpa implements BookDao {
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")//On utilise cette annotation, sinon un warning est levé
    @Override
    public List<BookBean> getBookList() {
        // Retourne la liste de tous les livres
        Query requete = em.createNativeQuery("select * from BOOK_JPA", NoteBean.class);
        return requete.getResultList();
    }

    @Override
    public void borrowBookDao(BookBean book) {
        // Marque le livre comme emprunté en mettant à jour son statut
        //book.setAvailable(false);  // On suppose que BookBean a un attribut "available"
        //entityManager.merge(book);
    }

    @Override
    public void returnBookDao(BookBean book) {
        // Marque le livre comme disponible
       // book.setAvailable(true);  // Mise à jour de l'attribut "available" à true
        //entityManager.merge(book);
    }

    
}


