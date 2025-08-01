package com.next.app.api.user.service;

import com.next.app.api.user.entity.Business;
import com.next.app.api.user.repository.BusinessRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BusinessService {
    @Autowired
    private BusinessRepository businessRepository;

    // 전체 조회
    public List<Business> getAllBusiness() {
        return businessRepository.findAll();
    }

    // 단건 조회
    public Business getBusinessById(Long id) {
        return businessRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Business not found with id: " + id));
    }
    // 생성
    public Business createBusiness(Business business) {
        return businessRepository.save(business);
    }
    // 수정
    public Business updateBusiness(Long id, Business updateBusiness) {
        Business business = businessRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        business.setBusinessNumber(updateBusiness.getBusinessNumber());
        business.setCompanyName(updateBusiness.getCompanyName());
        business.setRepresentativeName(updateBusiness.getRepresentativeName());
        return businessRepository.save(business);
    }
    // 삭제
    public void deleteBusiness(Long id) {
        businessRepository.deleteById(id);
    }
}
