package pl.coderslab.author;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AuthorDao {
    @PersistenceContext
    private EntityManager entityManager;

    public Author findById(long id) {
        return entityManager.find(Author.class, id);
    }
}
