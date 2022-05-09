package com.javaDemo.crm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaDemo.crm.model.Client;

@Repository
public interface ClientDao extends JpaRepository<Client, Long> {

    @EntityGraph(value = "client.company")
	List<Client> findAll();

}