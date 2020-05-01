package com.practice.spring.batchprocessing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class JobCompletionNotficationListener extends JobExecutionListenerSupport {

    private static final Logger log =
            LoggerFactory.getLogger(JobCompletionNotficationListener.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobCompletionNotficationListener(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


}
