package pl.coderslab.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.category.Category;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByRating(int rating);

    //@Query("select b from Book b where b.title = ?1")
    @Query("select b from Book b where b.title = :title")
    List<Book> findByTitle(@Param("title") String title);

    //@Query("select b from Book b where b.category = ?1")
    @Query("select b from Book b where b.category = :category")
    List<Book> findByCategory(@Param("category") Category category);

    @Query(value = "select * from books b where b.category_id = ?1", nativeQuery = true)
    List<Book> findByCategoryId(long categoryId);

    @Modifying
    @Transactional
    @Query("update Book b set b.rating = b.rating + 1 where b.id = :id")
    int increaseRating(@Param("id") long id);
}
