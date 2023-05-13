package io.bootify.visitor_management_system.repos;

import io.bootify.visitor_management_system.domain.Flat;
import io.bootify.visitor_management_system.domain.Visit;
import io.bootify.visitor_management_system.model.VisitStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;


public interface VisitRepository extends JpaRepository<Visit, Long> {
    List<Visit> findByStatusAndFlat(VisitStatus visitStatus, Flat flat);

//    @Query("Select * from Visit where dateCreated < :dateTime")
//    List<Visit> findAllVisitsBeforeDateTime(OffsetDateTime dateTime);
}
