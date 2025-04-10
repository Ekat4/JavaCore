package ru.innopolis.springaop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.springaop.model.Book;
import ru.innopolis.springaop.repository.BookRepository;
import ru.innopolis.springaop.util.CustomResponse;
import ru.innopolis.springaop.util.CustomStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class BookService {

    @Autowired
    private final BookRepository bookRepository;

//    public BookService(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }

    public CustomResponse<Book> getAll() {
        List<Book> books = bookRepository.findAll();

        return new CustomResponse<>(
                books,
                CustomStatus.SUCCESS
        );
    }

    public CustomResponse<Book> getBookByTitle(String title) {
        Book book = bookRepository.findBookByTitle(title).orElseThrow();

        return new CustomResponse<>(
                Stream.of(book).toList(),
                CustomStatus.SUCCESS
        );
    }

    public CustomResponse<Book> addBook(Book book) {
        Book newBook = bookRepository.save(book);

        return new CustomResponse<>(
                Stream.of(newBook).toList(),
                CustomStatus.SUCCESS
        );
    }
}
