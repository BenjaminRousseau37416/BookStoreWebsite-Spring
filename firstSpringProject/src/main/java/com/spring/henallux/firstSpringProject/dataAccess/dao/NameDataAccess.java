package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.model.Name;

import java.util.ArrayList;

public interface NameDataAccess
{
    ArrayList<Name> getAllName();
    ArrayList<Name> getAllByLanguageId(int id);
}
