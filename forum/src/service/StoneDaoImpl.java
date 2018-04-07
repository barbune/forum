package service;

import dao.StoneDao;
import domain.Stone;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class StoneDaoImpl extends SqlSessionDaoSupport implements StoneDao {
    @Override
    public Stone findStoneByCategories(String categories) throws Exception {
        SqlSession sqlSession = this.getSqlSession();
        Stone stone = sqlSession.selectOne("content.findStoneByCategories",categories);
        return stone;
    }

    @Override
    public List<Stone> findStoneByWeighingDate(String date) throws Exception {
        SqlSession sqlSession = this.getSqlSession();
        List<Stone> stone = sqlSession.selectList("content.findStoneByWeighingDate",date);
        return stone;
    }

    @Override
    public void batchInsert(List list) throws Exception {
        SqlSession sqlSession = this.getSqlSession();
        sqlSession.insert("content.batchInsert",list);
    }

    @Override
    public List<Stone> findStone() throws Exception {
        SqlSession sqlSession = this.getSqlSession();
        List<Stone> listStone = sqlSession.selectList("content.findStone");
        return listStone;
    }

    @Override
    public float addSumByCategories(String categories) throws Exception {
        SqlSession sqlSession = this.getSqlSession();
        float sum = sqlSession.selectOne("content.addSumByCategories",categories);
        return sum;
    }

    @Override
    public Float addSumByWeighingDate(String date) throws Exception {
        SqlSession sqlSession = this.getSqlSession();
        Float sum = sqlSession.selectOne("content.addSumByWeighingDate",date);
        return sum;
    }
}
