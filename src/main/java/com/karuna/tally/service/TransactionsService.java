package com.karuna.tally.service;

import com.karuna.tally.model.TransactionsVO;
import com.karuna.tally.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionsService {

    @Autowired
    private TransactionsRepository transactionsRepository;

    public List<TransactionsVO> getAllTransactions() {
        return transactionsRepository.findAll();
    }

}
