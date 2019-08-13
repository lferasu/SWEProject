package eShop.service.impl;

import eShop.model.user.Author;
import eShop.repository.AuthorRepository;
import eShop.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
       return authorRepository.findAll();
    }
}
