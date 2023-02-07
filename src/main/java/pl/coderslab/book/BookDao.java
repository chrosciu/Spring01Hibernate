package pl.coderslab.book;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Book book) {
        entityManager.persist(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void delete(Book book) {
        Book persistedBook = entityManager.contains(book) ? book : entityManager.merge(book);
        entityManager.remove(persistedBook);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public List<Book> findAll() {
        TypedQuery<Book> query = entityManager.createQuery("select b from Book b", Book.class);
        List<Book> books = query.getResultList();
        return books;
    }

    public List<Book> findAllByRating(int rating) {
        TypedQuery<Book> query = entityManager.createQuery(
                "select b from Book b where b.rating = :rating", Book.class);
        query.setParameter("rating", rating);
        List<Book> books = query.getResultList();
        return books;
    }
}
