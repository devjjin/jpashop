package repository;

import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    //상품저장
    public void save(Item item){
        if (item.getId() == null){
            em.persist(item);   // 신규등록
        }else{
            em.merge(item); // update 있으면
        }
    }

    // 파라미터 null이면 안되고, 리턴값 못찾으면 null 리턴
    public Item findOne(Long id){
        return em.find(Item.class, id);
    }

    public List<Item> findAll(){
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }


}
