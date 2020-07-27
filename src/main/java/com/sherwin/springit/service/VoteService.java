package com.sherwin.springit.service;

import com.sherwin.springit.domain.Vote;
import com.sherwin.springit.repository.VoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private VoteRepository voteRepository;

    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public void save(Vote vote){
        voteRepository.save(vote);
    }


}
