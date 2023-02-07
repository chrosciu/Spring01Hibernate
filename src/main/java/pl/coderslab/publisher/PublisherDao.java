package pl.coderslab.publisher;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Publisher publisher) {
        entityManager.persist(publisher);
    }

    public List<Publisher> findAll() {
        return entityManager
                .createQuery("select p from Publisher p", Publisher.class)
                .getResultList();
    }

    public Publisher findById(long id) {
        return entityManager.find(Publisher.class, id);
    }
}
