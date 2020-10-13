import domain.Borrower;
import domain.Category;
import domain.Game;
import repositories.BorrowerRepository;
import repositories.CategoryRepository;
import repositories.GameReposity;

import java.sql.SQLException;
import java.util.Scanner;

public class main {
  public static Scanner scanner= new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        start();

    }

    public  static void start() throws SQLException {
        Display();
       boolean onGame=true;
       while(onGame){ //TRAINER: use the command pattern for this
           menu();
           switch (scanner.nextInt()){
                   case 1:
                       GetfirstCategory();
                   break;

                   case 2:
                       GetGameWithIdFive();
                       break;
               case 3:
                   GetFirstBorrower();
                   break;
               case 4:

                   GetGameOfYourChoice();
                   break;

               case 6:
                   System.out.println("------------GOODBYE------------");
                   onGame=false;
                   break;

           }
       }


    }


    public static void Display(){
        System.out.println("------------Game_______________");
        System.out.println("---------By Shyaka Chaffi------------");
    }


    public static void menu(){
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Make a choise");
        System.out.println("1. Show the first game category'");
        System.out.println("2. Show the fifth game");
        System.out.println("3. Show the first borrower");
        System.out.println("4. Show a game of your choice");
        System.out.println();
        System.out.println();
        System.out.println("6. Exit de Program");
    }

    public static void GetfirstCategory() throws SQLException {
        CategoryRepository categoryRepository= CategoryRepository.getInstance();
       Category category= categoryRepository.getfirstCategory();
        System.out.println("------------------First Category----------------");
        System.out.println(category);
        System.out.println("-------------------------------------------------");
    }

    public static  void GetGameWithIdFive() throws SQLException{
        GameReposity gameReposity= GameReposity.getInstance();
        Game game=  gameReposity.getGameWithIdFive();
        System.out.println("-------------------------------------------------");
        System.out.println(game);

    }

    public static  void GetFirstBorrower() throws SQLException{
        BorrowerRepository borrowerRepository= BorrowerRepository.getInstance();
        Borrower game=  borrowerRepository.getfirstBorrower();
        System.out.println("-------------------------------------------------");
        System.out.println("Name: "+game.getBorrower_name() + "- City: "+game.getCity());

    }

    public static  void GetGameOfYourChoice() throws SQLException{
        GameReposity gameReposity= GameReposity.getInstance();
        Game game=  gameReposity.GetGameOfYourChoice(scanner.next().toLowerCase());
        System.out.println("-------------------------------------------------");
        System.out.println(game);

    }
}
