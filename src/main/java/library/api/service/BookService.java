package library.api.service;

import library.api.entity.Book;
import library.api.exception.ApiRequestException;
import library.api.exception.bookexception.AllFieldOfBookIsNotNullException;
import library.api.exception.bookexception.BookIsExistException;
import library.api.exception.bookexception.BookNotFoundException;
import library.api.exception.generalexception.ServerErrorException;
import library.api.exception.headbookexception.HeadBookNotFoundException;
import library.api.repository.BookRepository;
import library.api.repository.HeadBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {
    private final BookRepository bookRepository;
    private final HeadBookRepository headBookRepository;

    @Autowired
    public BookService(BookRepository bookRepository,
                       HeadBookRepository headBookRepository) {
        this.bookRepository = bookRepository;
        this.headBookRepository = headBookRepository;
    }

    public List<Book> getAllBook() {
        try {
            if (bookRepository.count() == 0) {
                throw new BookNotFoundException();
            }
            return bookRepository.findAll();
        } catch (ServerErrorException serverErrorException) {
            throw new ServerErrorException();
        }
    }

    public Book getById(Long id) {
        return bookRepository.getOne(id);
    }

    public Optional<Book> getBookById(Long id) {
        try {
            if (!isExist(id)) {
                throw new BookNotFoundException();
            }
            return bookRepository.findById(id);
        } catch (ServerErrorException serverErrorException) {
            throw new ServerErrorException();
        }

    }

    public Book addBook(Book book) {
        try {
            if (book.getHeadBookId() == null && book.getHeadBook() == null) {
                throw new AllFieldOfBookIsNotNullException();
            } else if (book.getHeadBook() != null) {
                headBookRepository.save(book.getHeadBook());
            } else if (isExist(book.getId())) {
                throw new BookIsExistException();
            } else if (!headBookRepository.existsById(book.getHeadBookId())) {
                throw new HeadBookNotFoundException();
            }

            book.setStatus("binh thuong");
            book.setAddedDate(new Timestamp(System.currentTimeMillis()));
            bookRepository.save(book);
            return book;
        } catch (ServerErrorException serverErrorException) {
            throw new ServerErrorException();
        }

    }

    public Book updateBook(Book book, Long id) {
        try {
            if (!isExist(id)) {
                throw new BookNotFoundException();
            }
            Book book1 = bookRepository.getOne(book.getId());
            book1.set(book);
            bookRepository.save(book1);
            return book1;
        } catch (ServerErrorException serverErrorException) {
            throw new ServerErrorException();
        }

    }

    public void deleteBookById(Long id) {
        try {
            if (!isExist(id)) {
                throw new ApiRequestException("this id is not exist");
            }
            bookRepository.deleteById(id);
        } catch (ServerErrorException serverErrorException) {
            throw new ServerErrorException();
        }

    }

    public boolean isExist(Long id) {
        return bookRepository.findById(id).isPresent();
    }
}
