package com.tuandang.ecommerce_api.infrastructure.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tuandang.ecommerce_api.core.Enum.Scope;
import com.tuandang.ecommerce_api.core.Enum.VoucherType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VouchersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String code;
    private VoucherType  type;
    private Float value;
    private Float maxDiscountAmount;
    private Float minOrderValue;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private Integer usageLimit;
    private Integer usedCount;
    private Boolean isActive;
    private Scope scope;

    @ManyToOne()
    @JsonBackReference
    private ShopsEntity shops;

    @OneToMany(
            mappedBy = "platformVoucher"
    )
    @JsonManagedReference
    private List<OrdersEntity> platformOrders;

    @OneToMany(
            mappedBy = "shippingVoucher"
    )
    @JsonManagedReference
    private List<OrdersEntity> shippingOrders;

    @OneToMany(
            mappedBy = "shopVoucher"
    )
    @JsonManagedReference
    private List<OrderItemEntity> shopOrders;

    @ManyToMany()
    @JoinTable(
            name = "productVoucher",
            joinColumns = {
                    @JoinColumn(name = "voucherId",
                    referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "productId",
                    referencedColumnName = "id")
            }
    )
    private Set<ProductsEntity> products;

    @ManyToMany
    @JoinTable(
            name = "categoryVoucher",
            joinColumns = {
                    @JoinColumn(name = "voucherId")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "categoryId")
            }
    )
    private Set<CategoryEntity> categories;
}
