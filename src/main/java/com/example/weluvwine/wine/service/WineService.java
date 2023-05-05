package com.example.weluvwine.wine.service;

import com.example.weluvwine.util.Message;
import com.example.weluvwine.util.StatusEnum;
import com.example.weluvwine.wine.entity.Wine;
import com.example.weluvwine.wine.repository.WineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WineService {
    private final WineRepository wineRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<Message> searchWine(String searchKeyword){
        List<Wine> wineList = wineRepository.findByNameContaining(searchKeyword);
        Message message = Message.setSuccess(StatusEnum.OK,"검색 성공", wineList);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> readWine(Long reviewId){
        Wine wine = wineRepository.findById(reviewId).orElseThrow();
        Message message = Message.setSuccess(StatusEnum.OK,"상세 페이지 조회 성공", wine);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}