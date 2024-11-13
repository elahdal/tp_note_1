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
    private EntityManager entityManager;

    @Override
    public List<BookBean> getBookList() {
        // Retourne la liste de tous les livres
        String jpql = "SELECT b FROM BookBean b";
        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public void borrowBookDao(BookBean book) {
        // Marque le livre comme emprunté en mettant à jour son statut
        book.setAvailable(false);  // On suppose que BookBean a un attribut "available"
        entityManager.merge(book);
    }

    @Override
    public void returnBookDao(BookBean book) {
        // Marque le livre comme disponible
        book.setAvailable(true);  // Mise à jour de l'attribut "available" à true
        entityManager.merge(book);
    }

    @Override
    public void deleteBookbyIdDao(int idbook) {
        // Supprime un livre par son ID
        BookBean book = entityManager.find(BookBean.class, idbook);
        if (book != null) {
            entityManager.remove(book);
        }
    }

    @Override
    public void updateBookbyIdDao(int idbook, String titre, String auteur) {
        // Met à jour les informations du livre par son ID
        BookBean book = entityManager.find(BookBean.class, idbook);
        if (book != null) {
            book.setTitre(titre);
            book.setAuteur(auteur);
            entityManager.merge(book);
        }
    }
    
}


