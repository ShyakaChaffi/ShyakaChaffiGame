package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Borrow implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //TRAINER: use Strategy for your primary key
    private Integer id;
    //TRAINER:use join column
    @OneToOne (fetch = FetchType.EAGER) //TRAINER: https://www.baeldung.com/hibernate-initialize-proxy-exception
    @JoinColumn(name = "game_id")
    private Game game;
    //TRAINER:use join column
    @OneToOne (fetch = FetchType.EAGER) //TRAINER: if set to lazy the you get a LazyInitializationException
    // read this to solve this https://www.baeldung.com/hibernate-initialize-proxy-exception
    // or you could use a DTO
    @JoinColumn(name = "borrower_id")
    private Borrower borrower;

//    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    //TRAINER no snake casing, use camel casing for your field names
    private LocalDate borrow_date;

//    @Temporal(TemporalType.DATE)
    private LocalDate returnDate; //TRAINER: duplicate field see line 78 and use LocalDate

    public Borrow(Integer id, Game game, Borrower borrower, LocalDate borrowDate, LocalDate returnDate) {
        this.id = id;
        this.game = game;
        this.borrower = borrower;
        this.borrow_date = borrowDate;
        this.returnDate = returnDate;
    }

    public Borrow() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Game getGame_id() {
        return game;
    }

    public void setGame_id(Game game_id) {
        this.game = game_id;
    }

    public Borrower getBorrower_id() {
        return borrower;
    }

    public void setBorrower_id(Borrower borrower_id) {
        this.borrower = borrower_id;
    }

    public LocalDate getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(LocalDate borrow_date) {
        this.borrow_date = borrow_date;
    }

    public LocalDate getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDate return_date) {
        this.return_date = return_date;
    }

    private LocalDate return_date;  //TRAINER: duplicate field

}
