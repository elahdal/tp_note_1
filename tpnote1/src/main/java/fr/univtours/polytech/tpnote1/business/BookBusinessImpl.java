package fr.univtours.polytech.tpnote1.business;

import java.util.List;

import fr.univtours.polytech.tpnote1.dao.BookDao;
import fr.univtours.polytech.tpnote1.model.BookBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class BookBusinessImpl implements BookBusiness {

    @Inject
    private BookDao bookDao;

    public void borrowBook(Integer idBook) {
        BookBean book = bookDao.getBookById(idBook);
        book.setAvailable(false);
        bookDao.borrowBookDao(book);
    }

    public void returnBook(Integer idBook) {
        BookBean book = bookDao.getBookById(idBook);
        book.setAvailable(true);
        bookDao.returnBookDao(book);
    }

    /*public List<BookBean> listFreeBooks() {
        return bookDao.getBooksList();
    }

    public List<BookBean> listBorrowedBooks() {
        
    }*/

    @Override
    public List<BookBean> getBooksList() {
        /*List<BookBean> livres = new ArrayList<BookBean>();
        livres = bookDao.getBookList();
        System.out.println("Nb de livres : " + livres.size());
        for (BookBean bookBean : livres) {
            BookBean bookBean2 = new BookBean();
            bookBean2.setTitle(bookBean.getTitle());
            bookBean2.setAuthor(bookBean.getAuthor());
            bookBean2.setAvailable(bookBean.getAvailable());
            livres.add(bookBean);
        }
        return  livres;*/
        return bookDao.getBookList();
    }

    public BookBean getBookById(Integer idBook) {
        return bookDao.getBookById(idBook);
    }

    public BookBean insertBook(BookBean book) {
        return bookDao.insertBookDao(book);
    }

}
