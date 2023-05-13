package io.bootify.visitor_management_system.rest;

import io.bootify.visitor_management_system.model.VisitDTO;
import io.bootify.visitor_management_system.model.VisitorDTO;
import io.bootify.visitor_management_system.service.VisitService;
import io.bootify.visitor_management_system.service.VisitorService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/api/gatekeeper")
public class GateKeeperController {

    static private Logger LOGGER = LoggerFactory.getLogger(GateKeeperController.class);
    @Autowired
    private VisitorService visitorService;
    @Autowired
    private VisitService visitService;
    @Value("${static.dir.path}")
    private String staticDir;

    @GetMapping("/{id}")
    public ResponseEntity<VisitorDTO> getVisitor(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(visitorService.get(id));
    }

    @PostMapping("/createVisitor")
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createVisitor(@RequestBody @Valid final VisitorDTO visitorDTO) {
        return new ResponseEntity<>(visitorService.create(visitorDTO), HttpStatus.CREATED);
    }

    @PostMapping("/createVisit")
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createVisit(@RequestBody @Valid final VisitDTO visitDTO) {
        return new ResponseEntity<>(visitService.create(visitDTO), HttpStatus.CREATED);
    }

    @PutMapping("/markEntry/{visitId}")
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> markEntryVisit(@RequestBody final Long visitId) {
        // approved
        // update in-time
        return null;
    }
    @PutMapping("/markExit/{visitId}")
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> markExitVisit(@RequestBody final Long visitId) {
        // approved
        // update out-time
        // mark completed
        return null;
    }

    // upload image file
    @PostMapping("/image/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            String uploadPath = staticDir+"testfile_"+System.currentTimeMillis()+"_"+file.getOriginalFilename();
            file.transferTo(new File(uploadPath));
            message = "Image URL : " + uploadPath;
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            LOGGER.error("Exception occurred: {}",e);
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }

    }
}
