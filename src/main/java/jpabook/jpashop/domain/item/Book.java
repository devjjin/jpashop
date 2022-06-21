package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B") // 싱글테이블이니까 구분할수 있도록 넣는 값
@Getter @Setter
public class Book extends Item{

    private String author;
    private String isbn;

}
