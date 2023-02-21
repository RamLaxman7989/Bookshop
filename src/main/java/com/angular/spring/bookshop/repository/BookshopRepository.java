package com.angular.spring.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angular.spring.bookshop.model.Bookshop;

@Repository
public interface BookshopRepository extends JpaRepository<Bookshop, Long>{

}
