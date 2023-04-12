package com.cpfanalyzer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpfanalyzer.models.RestrictedList;

@Repository
public interface CpfAnalyzerRepository extends JpaRepository <RestrictedList, Long> {
	RestrictedList findByCPF(String CPF);
}
