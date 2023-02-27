package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.PromotionEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.PromotionRepository;
import com.spring.henallux.firstSpringProject.dataAccess.utils.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromotionDao implements PromotionDataAccess
{
    private final PromotionRepository promotionRepository;
    private final ProviderConverter providerConverter;

    @Autowired
    public PromotionDao(PromotionRepository promotionRepository,ProviderConverter providerConverter)
    {
        this.promotionRepository = promotionRepository;
        this.providerConverter = providerConverter;
    }

    public ArrayList<Promotion> getAllPromotion()
    {
        List<PromotionEntity> promotionEntities = promotionRepository.findAll();
        ArrayList<Promotion> promotions = new ArrayList<>();
        for(PromotionEntity entity : promotionEntities)
        {
            Promotion promotion = providerConverter.promotionEntityToPromotionModel(entity);
            promotions.add(promotion);
        }
        return promotions;
    }
}
