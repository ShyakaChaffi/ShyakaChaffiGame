package restServices;

import domain.Borrow;
import services.BorrowService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import java.util.List;

@Path("borrows")
public class BorrowRestService {

    @Inject
    private BorrowService borrowService;

    @GET
    @Produces("application/json")
    public List<Borrow> findAllBorrows(){
        //Without this casting, the application has trouble ton serialize/deserialize the List of Borrow
        //TRAINER: casting is not needed, maybe you get a LazyInitializationException ?
        //TRAINER: this means that some fields are set to lazy loading
        // read this to solve this https://www.baeldung.com/hibernate-initialize-proxy-exception
        // or you could use a DTO
        return borrowService.findAllBorrow();

    }
}