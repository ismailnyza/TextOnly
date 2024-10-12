package cheapDrugs.Repositories;

import cheapDrugs.Entitys.Job;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


@Repository
public interface jobRepository extends JpaRepository<Job, Long> {


    //    my first fuzzy search woooo
    @Query("select j from Job j where lower(j.jobTitle) like lower(concat('%', :searchTerm , '%')) or lower(j.jobDescription) like lower(concat('%', :searchTerm , '%'))")
    List<Job> fuzzyFind(@Param("searchTerm") String searchTerm);
}