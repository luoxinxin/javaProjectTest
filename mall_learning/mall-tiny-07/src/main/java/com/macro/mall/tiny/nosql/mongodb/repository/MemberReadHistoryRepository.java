package com.macro.mall.tiny.nosql.mongodb.repository;

import com.macro.mall.tiny.nosql.mongodb.document.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory,String> {
    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);
}
