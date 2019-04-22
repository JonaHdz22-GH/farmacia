package sv.edu.uesocc.ingenieria.tpi135.farmacia.control.IT;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.mockito.internal.util.reflection.Whitebox;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.AbstractFacade;

/**
 *
 * @author luis
 */
public class EntityManagerProvider implements TestRule {

    public static EntityManagerProvider emp;
    private final EntityTransaction transaction;
    private final EntityManager em;
    private final AbstractFacade facade;

    private EntityManagerProvider(String puName, AbstractFacade facade) {
        this.facade = facade;
        this.em = Persistence.createEntityManagerFactory(puName).createEntityManager();
        Whitebox.setInternalState(facade, "em", this.em);
        this.transaction = this.em.getTransaction();
    }

    public static EntityManagerProvider getInstance(String puName, AbstractFacade facade) {
        return new EntityManagerProvider(puName, facade);
    }

    @Override
    public Statement apply(Statement arg0, Description arg1) {

        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                getEm().clear();
                getEm().close();
            }
        };
    }

    public static EntityManagerProvider getEmp() {
        return emp;
    }

    public EntityTransaction getTransaction() {
        return transaction;
    }

    public EntityManager getEm() {
        return em;
    }

    public AbstractFacade getFacade() {
        return facade;
    }

}
