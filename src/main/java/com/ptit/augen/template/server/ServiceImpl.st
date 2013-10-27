package $packageName$.business.impl;

import $packageName$.business.$tableName$Service;
import $packageName$.dao.$tableName$DAO;
import $packageName$.entity.$tableName$;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: Nguyen Tuan Anh
 * Company: QSoftVietNam
 * Dev: JAVA
 */

@Component("$tableName$Service")
public class $tableName$ServiceImpl implements $tableName$Service
{
    @Autowired
    $tableName$DAO _$tableName$DAO;

    @Override
    public $tableName$ findById(Long id)
    {
        return _$tableName$DAO.findOne(id);
    }

    @Override
    public void save($tableName$ _$tableName$)
    {
        _$tableName$DAO.saveAndFlush(_$tableName$);
    }

    @Override
    public void remove($tableName$ _$tableName$)
    {
        _$tableName$DAO.delete(_$tableName$);
    }

    @Override
    public void remove(Long id)
    {
        _$tableName$DAO.delete(id);
    }

    @Override
    public List<$tableName$> getAll()
    {
        return _$tableName$DAO.findAll();
    }
}