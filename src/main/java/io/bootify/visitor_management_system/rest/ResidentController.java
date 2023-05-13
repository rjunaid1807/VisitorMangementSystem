package io.bootify.visitor_management_system.rest;

import io.bootify.visitor_management_system.domain.Visit;
import io.bootify.visitor_management_system.model.VisitDTO;
import io.bootify.visitor_management_system.model.VisitStatus;
import io.bootify.visitor_management_system.service.VisitService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resident")
public class ResidentController {
    @Autowired
    private VisitService visitService;

    @PutMapping("/approveVisit/{id}/{status}")
    public ResponseEntity<Void> approveVisit(@PathVariable(name = "id") final Long id) {
        visitService.updateStatus(id, VisitStatus.APPROVED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/rejectVisit/{id}/{status}")
    public ResponseEntity<Void> rejectVisit(@PathVariable(name = "id") final Long id) {
        visitService.updateStatus(id, VisitStatus.REJECTED);
        return ResponseEntity.ok().build();
    }

//        -----------Alternative to approve/ reject---------------
//    @PutMapping("/updateVisit/{id}/{status}")
//    public ResponseEntity<Void> updateVisit(@PathVariable(name = "id") final Long id,
//                                            @PathVariable(name = "status") final String status) {
//        return ResponseEntity.ok().build();
//    }

    @GetMapping("/visits/{status}")
    public ResponseEntity<List<VisitDTO>> getVisitsByStatus(@PathVariable(name = "status") final VisitStatus visitStatus, @RequestHeader Long userId){
        List<VisitDTO> visits = visitService.findAllByStatusAndUserId(visitStatus, userId);
        return ResponseEntity.ok(visits);
    }
}
