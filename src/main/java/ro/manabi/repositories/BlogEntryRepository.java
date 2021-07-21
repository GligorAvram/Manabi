package ro.manabi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ro.manabi.entities.BlogEntry;

@Repository
public interface BlogEntryRepository extends JpaRepository<BlogEntry, Long>{
	
	//select * is implicit
	@Query("from BlogEntry b WHERE b.grammarStructure like %?1%")
	List<BlogEntry> findByQuery(String query);

}
