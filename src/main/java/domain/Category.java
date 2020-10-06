package domain;

import javax.persistence.*;

import java.io.Serializable;

@Entity
public  class Category  implements Serializable {

    @Id @GeneratedValue
    private Integer Id;

    @Column(nullable = false,length = 200)
    private String category_name;


  public Category(int id, String category_name){
      this.Id= id;
      this.category_name=category_name;
  }

    public Category() {
    }

    public Category(String category_name) { this.category_name=category_name; }

    public int getId() {
        return Id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return  "ID: "+ this.getId()+" - category_name='" + getCategory_name() + '\'';
    }
}
