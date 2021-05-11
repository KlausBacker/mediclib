package App.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public abstract class AbstractDaoHibernate<T> {

    private static EntityManagerFactory emf;
    protected EntityManager em;
    private Class<T> clz;

    public AbstractDaoHibernate(Class<T> clz) {
        this.clz = clz;

        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("EShopUnit");
        }

        this.em = emf.createEntityManager();
    }

    public List<T> findAll() {
        return this.em
                .createQuery("select e from " + this.clz.getSimpleName() + " e", this.clz)
                .getResultList();
    }

}
