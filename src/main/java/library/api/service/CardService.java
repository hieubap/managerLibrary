package library.api.service;

import library.api.entity.Book;
import library.api.entity.CardLibrary;
import library.api.entity.Session;
import library.api.exception.ApiRequestException;
import library.api.exception.cardlibraryexception.CardLibraryNotFoundException;
import library.api.exception.generalexception.ServerErrorException;
import library.api.exception.studentexception.StudentNotFoundException;
import library.api.repository.CardRepository;
import library.api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class CardService {
    private final CardRepository repositoryCard;
    private final StudentRepository studentRepo;
    private final BookService bookService;
    private final SessionService sessionService;

    @Autowired
    public CardService(CardRepository repositoryCard,
                       StudentRepository studentRepo,
                       BookService bookService,
                       SessionService sessionService) {
        this.repositoryCard = repositoryCard;
        this.studentRepo = studentRepo;
        this.bookService = bookService;
        this.sessionService = sessionService;
    }

    public CardLibrary getByMssv(String mssv) {
        try {
            if (!isExist(mssv)) {
                throw new StudentNotFoundException();
            }
            return repositoryCard.findByMssv(mssv);
        } catch (ServerErrorException serverErrorException) {
            throw new ServerErrorException();
        }

    }

    public CardLibrary getbyID(Long id) {
        try {
            if (!isExist(id)) {
                throw new CardLibraryNotFoundException();
            }
            return repositoryCard.getOne(id);
        } catch (ServerErrorException serverErrorException) {
            throw new ServerErrorException();
        }

    }

    public List<CardLibrary> getAll() {
        try {
            List<CardLibrary> cardLibraries = repositoryCard.findAll();
            if (cardLibraries == null) {
                throw new CardLibraryNotFoundException();
            }
            return cardLibraries;
        } catch (ServerErrorException serverErrorException) {
            throw new ServerErrorException();
        }

    }

    public boolean isExist(String mssv) {
        return repositoryCard.existsByMssv(mssv);
    }

    public boolean isExist(Long id) {
        return repositoryCard.existsById(id);
    }

    //************************
    public void add(CardLibrary cardLibrary) {
        if (cardLibrary.getMssv() == null) {
            throw new ApiRequestException("mssv cant null.");// ve viet sau
        }

        if (!studentRepo.existsByMssv(cardLibrary.getMssv()))
            throw new StudentNotFoundException();

        if (isExist(cardLibrary.getMssv())) {
            //System.out.println("This student already has a library card ( mssv : " + cardLibrary.getMssv() + ")");
            throw new ApiRequestException("This student already has a library card ( mssv : " + cardLibrary.getMssv() + ")");
        }

        cardLibrary.setStatus("con han");
        long year = TimeUnit.MILLISECONDS.convert(365, TimeUnit.DAYS);
        cardLibrary.setExpiration_date(new Timestamp(System.currentTimeMillis() + year));
        String idStudent = cardLibrary.getMssv();
        cardLibrary.setStudentId(studentRepo.getByMssv(idStudent).getId());

        repositoryCard.save(cardLibrary);
    }

    public CardLibrary update(CardLibrary cardLibrary, Long id) {
        if (!isExist(id)) {
            throw new CardLibraryNotFoundException();
        }
        CardLibrary cardLibrary1 = repositoryCard.getOne(id);
        cardLibrary1.set(cardLibrary);
        repositoryCard.save(cardLibrary1);

        return cardLibrary1;
    }

    public void back(Long id) {
        Session session = sessionService.getbyID(id);
        session.setStatus("da tra");
        sessionService.update(session, id);

        Book book = bookService.getById(session.getIdBook());
        book.setStatus("binh thuong");
    }

    public void delete(long id) {
        try {
            if (!isExist(id)) {
                throw new CardLibraryNotFoundException();
            }
            repositoryCard.deleteById(id);
        } catch (ServerErrorException serverErrorException) {
            throw new ServerErrorException();
        }

    }
}
