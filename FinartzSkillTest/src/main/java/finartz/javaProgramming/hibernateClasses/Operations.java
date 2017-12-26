package finartz.javaProgramming.hibernateClasses;

import java.util.List;

public interface Operations {
    public void save(Object object) throws Exception;

    public void update(Object object) throws Exception;

    public void saveOrUpdate(Object object) throws Exception;

    public void delete(Object object) throws Exception;

    public boolean isValueInDatabase(Object object) throws Exception;
    public List allValues() throws Exception;
    public List findById(String id) throws Exception;

}
