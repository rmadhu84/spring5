/**
 * 
 */
package com.springframework.spring5webapp.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springframework.spring5webapp.models.Publisher;

/**
 * @author Madhu
 *
 */
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
