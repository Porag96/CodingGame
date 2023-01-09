package com.crio.codingame.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.crio.codingame.entities.Level;
import com.crio.codingame.entities.Question;

public class QuestionRepository implements IQuestionRepository {

    private final Map<String,Question> questionMap;
    private Integer autoIncrement = 0;

    public QuestionRepository(){
        questionMap = new HashMap<String,Question>();
    }

    public QuestionRepository(Map<String, Question> questionMap) {
        this.questionMap = questionMap;
        this.autoIncrement = questionMap.size();
    }

    @Override
    public Question save(Question entity) {
        if( entity.getId() == null ){
            autoIncrement++;
            Question q = new Question(Integer.toString(autoIncrement),entity.getTitle(),entity.getLevel(),entity.getScore());
            questionMap.put(q.getId(),q);
            return q;
        }
        questionMap.put(entity.getId(),entity);
        return entity;
    }

    // Find all the list of Question Present in the Repository

    @Override
    public List<Question> findAll() {
        List<Question> questions = questionMap.values().stream().collect(Collectors.toList());
        return questions;
    }

    @Override
    public Optional<Question> findById(String id) {
        return Optional.ofNullable(questionMap.get(id));
    }

    @Override
    public boolean existsById(String id) {
        return false;
    }

    @Override
    public void delete(Question entity) {        
    }

    @Override
    public void deleteById(String id) {        
    }

    @Override
    public long count() {
        return 0;
    }

    // Find all the list of Question Present in the Repository provided Level

    @Override
    public List<Question> findAllQuestionLevelWise(Level level) {
        List<Question> questions = questionMap.entrySet().stream().filter(l->l.getValue().getLevel()==level).map(Map.Entry::getValue).collect(Collectors.toList());
        return questions;
    }
}
