package com.online.menu.repository;

import com.online.menu.entity.CategoriaEntity;
import com.online.menu.entity.ProductoEntity;
import com.online.menu.services.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaDAOHbn extends JpaRepository<CategoriaEntity, Long> {

}
