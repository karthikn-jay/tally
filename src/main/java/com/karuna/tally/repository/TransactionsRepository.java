package com.karuna.tally.repository;

import com.karuna.tally.model.TransactionsVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends JpaRepository<TransactionsVO, Integer> {

}
