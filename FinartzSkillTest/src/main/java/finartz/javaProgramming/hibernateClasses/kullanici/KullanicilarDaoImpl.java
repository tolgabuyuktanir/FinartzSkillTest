package finartz.javaProgramming.hibernateClasses.kullanici;


import finartz.javaProgramming.configurations.CustomHibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("kullanicilarDaoImpl")
@Transactional
public class KullanicilarDaoImpl extends CustomHibernateDaoSupport implements KullanicilarDao {
    @Override
    public void save(Object object) throws Exception {
        getHibernateTemplate().save(object);
    }

    @Override
    public void update(Object object) throws Exception {
        getHibernateTemplate().save(object);
    }

    @Override
    public void saveOrUpdate(Object object) throws Exception {
        getHibernateTemplate().saveOrUpdate(object);
    }

    @Override
    public void delete(Object object) throws Exception {
        getHibernateTemplate().delete(object);
    }

    @Override
    public boolean isValueInDatabase(Object object) throws Exception {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public List allValues() throws Exception {
        List kullanicilar=getHibernateTemplate().find("from Kullanicilar");
        return kullanicilar;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List findById(String id) throws Exception {
        System.out.println(id);
        List kullanicilar=getHibernateTemplate().find("from Kullanicilar where id=?",Integer.parseInt(id));
        return kullanicilar;
    }
}
