package com.example.accnummvc.repository;

//import com.example.accnumdatabase.entity.LabId;
import com.example.accnummvc.entity.LabId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//import java.util.Optional;

@Repository
public interface LabIdRepository extends JpaRepository<LabId,Long> {
//    Optional<LabId> findById(Integer[] integers);

    @Query(nativeQuery=true, value = " select value from lab_id ORDER BY value DESC LIMIT 1")
    String findAllUsers();
}
