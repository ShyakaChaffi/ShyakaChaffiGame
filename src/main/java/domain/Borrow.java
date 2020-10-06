package domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Borrow implements Serializable {
    @Id @GeneratedValue
    private Integer Id;
    @Column(nullable = false,length = 200)
    private Game  game;
    @Column(nullable = false,length = 200)
    @OneToOne (fetch = FetchType.LAZY)
    private Borrower borrower;

    @Temporal(TemporalType.DATE)
    @Column( nullable = false)
    private Date borrow_date;

    @Temporal(TemporalType.DATE)
    private Date returnDate;

    public Borrow(Integer id, Game game, Borrower borrower, Date borrowDate, Date returnDate) {
        this.Id = id;
        this.game = game;
        this.borrower = borrower;
        this.borrow_date = borrowDate;
        this.returnDate = returnDate;
    }

    public Borrow() {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public Date getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(Date borrow_date) {
        this.borrow_date = borrow_date;
    }

    public LocalDate getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDate return_date) {
        this.return_date = return_date;
    }

    private LocalDate return_date;

}
