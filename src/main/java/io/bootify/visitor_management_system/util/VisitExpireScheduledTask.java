package io.bootify.visitor_management_system.util;

import io.bootify.visitor_management_system.domain.Visit;
import io.bootify.visitor_management_system.model.VisitStatus;
import io.bootify.visitor_management_system.repos.VisitRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.OffsetDateTime;
import java.util.List;

@Configuration
@EnableScheduling
public class VisitExpireScheduledTask {

    static private Logger logger = LoggerFactory.getLogger(VisitExpireScheduledTask.class);
    @Autowired
    private VisitRepository visitRepository;

    @Scheduled(fixedDelay = 1000)
    public void markVisitsExpire() {
//        OffsetDateTime dateTime = new OffsetDateTime();
//        List<Visit> visitList = visitRepository.findAllVisitsBeforeDateTime(dateTime);
//        for (Visit visit : visitList){
//            visit.setStatus(VisitStatus.EXPIRE);
//        }
//        visitRepository.saveAll(visitList);
    }
}
