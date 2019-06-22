package com.akhambir.dao;

import com.akhambir.model.MoneyTransfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyTransferHistoryDao extends JpaRepository<MoneyTransfer, Long> {
}
