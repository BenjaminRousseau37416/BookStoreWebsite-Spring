package com.spring.henallux.firstSpringProject.dataAccess.repository;

import com.spring.henallux.firstSpringProject.dataAccess.entity.NameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface NameRepository extends JpaRepository<NameEntity,Integer>
{
    ArrayList<NameEntity> findAllByName(String name);
    ArrayList<NameEntity> findAllByLanguage_Id(int id);
}
