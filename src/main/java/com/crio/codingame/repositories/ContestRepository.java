package com.crio.codingame.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.crio.codingame.entities.Contest;
import com.crio.codingame.entities.Level;

public class ContestRepository implements IContestRepository {

    private final Map<String,Contest> contestMap;
    private Integer autoIncrement = 0;

    
    
    public ContestRepository() {
        contestMap = new HashMap<String,Contest>();
    }

    public ContestRepository(Map<String, Contest> contestMap) {
        this.contestMap = contestMap;
        this.autoIncrement = contestMap.size();
    }

    @Override
    public Contest save(Contest entity) {
        if( entity.getId() == null ){
            autoIncrement++;
            Contest c = new Contest(Integer.toString(autoIncrement),entity.getName(),entity.getQuestions(),entity.getLevel(),entity.getCreator(),entity.getContestStatus());
            contestMap.put(c.getId(),c);
            return c;
        }
        contestMap.put(entity.getId(),entity);
        return entity;
    }

    // Find all the list of Contest Present in the Repository

    @Override
    public List<Contest> findAll() {
        List<Contest> contests = contestMap.values().stream().collect(Collectors.toList());
        return contests;
    }

    @Override
    public Optional<Contest> findById(String id) {
        return Optional.ofNullable(contestMap.get(id));
    }

    @Override
    public boolean existsById(String id) {
        return false;
    }

    @Override
    public void delete(Contest entity) {        
    }

    @Override
    public void deleteById(String id) {        
    }

    @Override
    public long count() {
        return 0;
    }

    // Find all the list of Contest Present in the Repository provided Level

    @Override
    public List<Contest> findAllContestLevelWise(Level level) {
        List<Contest> contests = contestMap.entrySet().stream().filter(l->l.getValue().getLevel()==level).map(Map.Entry::getValue).collect(Collectors.toList());
        return contests;
    }

    
}
