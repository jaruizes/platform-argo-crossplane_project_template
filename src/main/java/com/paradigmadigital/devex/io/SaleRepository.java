package com.paradigmadigital.devex.io;

import com.paradigmadigital.devex.io.model.dto.SaleEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public interface SaleRepository extends JpaRepository<SaleEntity, Long>, JpaSpecificationExecutor<SaleEntity> {

    List<SaleEntity> findAll(Specification<SaleEntity> spec);

    default List<SaleEntity> findByFilters(Long productId, Long shopId) {
        return findAll(applyProductIdFilter(productId).and(applyShopIdFilter(shopId)));
    }

    static Specification<SaleEntity> applyProductIdFilter(Long productId) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (Objects.nonNull(productId)) {
                predicates.add(builder.equal(root.get("productId"), productId));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }

    static Specification<SaleEntity> applyShopIdFilter(Long shopId) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (Objects.nonNull(shopId)) {
                predicates.add(builder.equal(root.get("shopId"), shopId));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
