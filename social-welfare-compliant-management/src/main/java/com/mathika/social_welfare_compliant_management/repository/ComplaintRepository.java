package com.mathika.social_welfare_compliant_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mathika.social_welfare_compliant_management.entity.Complaint;
import com.mathika.social_welfare_compliant_management.entity.User;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    List<Complaint> findByUser(User user);

    List<Complaint> findByStatus(String status);

}