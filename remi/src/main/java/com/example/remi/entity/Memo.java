package com.example.remi.entity;


import com.example.remi.dto.MemoDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity // 이것만기억하기
@Getter // 이것만기억하기
@Setter // 이것만기억하기

@Table(name = "memo")
@ToString //안에 내용확인
@Builder //아직은 그냥 붙여놧다라고 생각
@AllArgsConstructor //아직은 그냥 붙여놧다라고 생각
@NoArgsConstructor //아직은 그냥 붙여놧다라고 생각
public class Memo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //저장후 수정못함
    @Column(name = "writer", insertable = true, updatable = false, length = 50, nullable = false)
    private String writer;

    private String content;

    // DTO받아서 Entity 로 만들어라
    // service에 chugaProc 사용하려고 만듬
    public static  Memo createEntity(MemoDTO memoDTO) {
        //DTO 자료를 Entity에 담는 과정
        Memo memo = new Memo();
        memo.setId(memoDTO.getId());
        //memoDTO.getWriter() dto에있는 name 읽어와서 memo.setWriter 저장해
        memo.setWriter(memoDTO.getWriter());
        memo.setContent(memoDTO.getContent());
        return memo;


    }


}
