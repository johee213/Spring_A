package com.example.remi.service;

import com.example.remi.Repository.MemoRepository;
import com.example.remi.dto.MemoDTO;
import com.example.remi.entity.Memo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemoService {
    private final MemoRepository memoRepository;

    //리포짓 호출해서 디비에있는거 싹다 읽어와서 >> Controller 에 준다
    public List<Memo> list(){
        return memoRepository.findAll();

    }
    //한줄만 반환하면 되서 phoneBook으로 반환함
    public Memo view(Long id) {
        Optional<Memo> optionalMemo = memoRepository.findById(id);
        Memo memo = null;
        //isPresent 존재하면
        if(optionalMemo.isPresent()) {
            memo = optionalMemo.get();
        }
        return memo;
    }
    //DTO >> entity 로 바꾸고
    public void chugaProc(MemoDTO memoDTO) {
        Memo memo = Memo.createEntity(memoDTO);
        memoRepository.save(memo);

    }

    public void sujungProc(MemoDTO memoDTO){
        Memo memo = Memo.createEntity(memoDTO);
        memoRepository.save(memo);
    }

    public  void sakjeProc(MemoDTO memoDTO){
        Memo memo = Memo.createEntity(memoDTO);
        memoRepository.delete(memo);
    }

}
