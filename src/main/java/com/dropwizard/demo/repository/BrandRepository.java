package com.dropwizard.demo.repository;

import com.dropwizard.demo.domain.Brand;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class BrandRepository {
    private final DataSource datasource;
    private QueryRunner queryRunner;

    public BrandRepository(DataSource datasource) {
        this.datasource = datasource;
        this.queryRunner = new QueryRunner(datasource);
    }
    public Optional<Brand> findById(Long id) throws SQLException {
       Brand brand = null;
       ResultSetHandler<Brand> result = new BeanHandler<Brand>(Brand.class);
       String query = "SELECT * FROM brand where id =?";
       brand = queryRunner.query(query,result,id);
        return Optional.ofNullable(brand);
    }
    public List<Brand> findAll() throws SQLException {
        List<Brand> brands = new ArrayList<>();
        ResultSetHandler<List<Brand>> result = new BeanListHandler<Brand>(Brand.class);
        String query = "SELECT * FROM brand";
        brands = queryRunner.query(query,result);

        return brands;
    }
    public String insert(Brand brand) throws SQLException {
        String query = "insert into brand (name) values (?)";
        this.queryRunner.update(query,brand.getName());
        return "Success";
    }
    public String delete(Brand brand) throws SQLException {
        String query = "DELETE FROM brand WHERE id=?";
        this.queryRunner.update(query,brand.getId());
        return "Success";
    }
    public String update(Brand brand) throws SQLException {
        String query = "UPDATE brand SET name =? WHERE id=?";
        this.queryRunner.update(query,brand.getName(),brand.getId());
        return "Success";
    }
}