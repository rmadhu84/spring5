/**
 * 
 */
package com.springframework.spring5webapp.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springframework.spring5webapp.models.Book;
import com.springframework.spring5webapp.models.Contact;

/**
 * @author ramachandranm1
 *
 */
public interface BookRepository extends JpaRepository<Book, Long> {

}
