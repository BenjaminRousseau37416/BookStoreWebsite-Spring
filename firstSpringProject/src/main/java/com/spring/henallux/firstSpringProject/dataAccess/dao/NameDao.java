package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.NameEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.NameRepository;
import com.spring.henallux.firstSpringProject.dataAccess.utils.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NameDao implements NameDataAccess
{
    private final NameRepository nameRepository;
    private final ProviderConverter providerConverter;

    @Autowired
    public NameDao(NameRepository nameRepository,ProviderConverter providerConverter)
    {
        this.nameRepository = nameRepository;
        this.providerConverter = providerConverter;
    }

    public ArrayList<Name> getAllName()
    {
        List<NameEntity> nameEntities = nameRepository.findAll();
        ArrayList<Name> names = new ArrayList<>();
        for(NameEntity entity : nameEntities)
        {
            Name name = providerConverter.nameEntityToNameModel(entity);
            names.add(name);
        }
        return names;
    }

    public ArrayList<Name> getAllByLanguageId(int id)
    {
        List<NameEntity> nameEntities = nameRepository.findAllByLanguage_Id(id);
        ArrayList<Name> names = new ArrayList<>();
        for(NameEntity entity : nameEntities)
        {
            Name name = providerConverter.nameEntityToNameModel(entity);
            names.add(name);
        }
        return names;
    }
}
