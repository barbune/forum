package dao;

import domain.Stone;

import java.util.List;

public interface StoneDao {
    public Stone findStoneByCategories(String categories) throws Exception;
    public List<Stone> findStoneByWeighingDate(String date) throws Exception;
    public void batchInsert(List list) throws  Exception;
    public List<Stone> findStone() throws Exception;
    public float addSumByCategories(String categories) throws Exception;
    public Float addSumByWeighingDate(String date) throws Exception;
}
