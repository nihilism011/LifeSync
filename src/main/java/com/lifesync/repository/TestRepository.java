package com.lifesync.repository;

import com.lifesync.domain.entities.TestTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestTable,Long> {
}
