package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A") // 싱글테이블이니까 구분할수 있도록 넣는 값
@Getter @Setter
public class Album extends Item{

    private String artist;
    private String etc;

}
