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

    public List<Book> findAllByRating(int rating) {
        TypedQuery<Book> query = entityManager.createQuery(
                "select b from Book b where b.rating = :rating", Book.class);
        query.setParameter("rating", rating);
        List<Book> books = query.getResultList();
        return books;
    }
}
