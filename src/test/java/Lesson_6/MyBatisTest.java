package Lesson_6;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {
    static SqlSession session = null;

    @BeforeAll
   static void MyBatTest() throws IOException {
       // SqlSession session = null;
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        session = sqlSessionFactory.openSession();

    }

    @Test
    void MyBatisDeleteTest() {

        db.dao.CategoriesMapper categoriesMapper = session.getMapper(db.dao.CategoriesMapper.class);
        categoriesMapper.deleteByPrimaryKey(7);
        session.commit();
        Assertions.assertNotEquals(7, categoriesMapper.selectByPrimaryKey(7));
    }

    @Test
    void MyBatisInsertTest() {
        db.dao.CategoriesMapper categoriesMapper = session.getMapper(db.dao.CategoriesMapper.class);
        db.model.Categories categories = new db.model.Categories();
        db.model.CategoriesExample categoriesExample = new db.model.CategoriesExample();
      //  db.model.CategoriesExample example = new db.model.CategoriesExample();
        categories.setTitle("chemicals");
        categoriesMapper.insert(categories);
        session.commit();
        Assertions.assertNotNull(categoriesExample);
    }

    @Test
    void MyBatisProductTest() {
        db.dao.ProductsMapper productsMapper = session.getMapper(db.dao.ProductsMapper.class);
        db.model.Products products = new db.model.Products();
        products.setTitle("Powder");
        products.setCategory_id(12);
        products.setPrice(60);
        productsMapper.insert(products);
        session.commit();
        Assertions.assertEquals("Powder",products.getTitle());
    }

    @Test
    void MyBatisProductsDeleteTest() {
        db.dao.ProductsMapper productsMapper = session.getMapper(db.dao.ProductsMapper.class);
        productsMapper.deleteByPrimaryKey(7);
        session.commit();
        Assertions.assertNotEquals(7, productsMapper.selectByPrimaryKey(7));

    }
}
