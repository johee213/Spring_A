package com.example.masil.service;


import com.example.masil.entity.Question;
import com.example.masil.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public page<Question> list(){
        return QuestionRepository.findAll();
    }



}
