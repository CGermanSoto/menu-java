package com.online.menu.repository;

import com.online.menu.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductDAOHbn extends JpaRepository<ProductoEntity, Long> {
}
