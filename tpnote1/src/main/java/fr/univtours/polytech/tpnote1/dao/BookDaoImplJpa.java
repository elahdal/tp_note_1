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
        Query requete = em.createNativeQuery("select * from BOOK_JPA", BookBean.class);
        return requete.getResultList();
    }

    public BookBean insertBookDao(BookBean book){
        em.persist(book);
        return book;
    }

    @Override
    public void borrowBookDao(BookBean book) {
        book.setAvailable(false);  // On suppose que BookBean a un attribut "available"
        em.merge(book);
        /* 
        if (book.getAvailable()) {
            // Compter les livres empruntés
            int borrowedCount = countBorrowedBooks();
            if (borrowedCount < 3) {
                book.setAvailable(false);  // Le livre devient emprunté
                em.merge(book);
            }
        }
        */
    }

    @Override
    public void returnBookDao(BookBean book) {
        // Marque le livre comme disponible
        book.setAvailable(true);  // Mise à jour de l'attribut "available" à true
        em.merge(book);
    }

    public int countBorrowedBooks() {
        Query query = em.createQuery("SELECT COUNT(b) FROM BookBean b WHERE b.available = false");
        return ((Number) query.getSingleResult()).intValue(); // Conversion du résultat en int
    }

    public BookBean getBookById(Integer idBook) {
        return em.find(BookBean.class, idBook);
    }
    
    
}


