package day64task.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order_entity") // 테이블 명 order로 하면 안됨
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OrderEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_index;

    // 주문 개수
    @Column(columnDefinition = "int", nullable = false)
    private int product_number;

    // 주문에 담긴 제품 정보를 가져옴
    @ManyToOne
    @JoinColumn(name = "product_index")
    private ProductEntity productEntity;
}
