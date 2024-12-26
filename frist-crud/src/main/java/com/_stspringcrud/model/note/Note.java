package com._stspringcrud.model.note;
// Generated Dec 25, 2024, 5:30:14 PM by Hibernate Tools 6.2.6.Final


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Note generated by hbm2java
 */
@Entity
@Table(name="note"
    ,schema="dbo"
    ,catalog="SpringBootTest"
)
public class Note  implements java.io.Serializable {


     private Integer id;
     private String content;
     private String title;
     private Boolean isDelete;

    public Note() {
    }

    public Note(String content, String title, Boolean isDelete) {
       this.content = content;
       this.title = title;
       this.isDelete = isDelete;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="content", length=255)
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    
    @Column(name="title", length=255)
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    
    @Column(name="isDelete")
    public Boolean getIsDelete() {
        return this.isDelete;
    }
    
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }




}


