package db;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Moe on 2/10/18.
 */
public class InvestorDAO extends AbstractDAO<Investor> {

    public InvestorDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Investor> getInvestors() {
        return currentSession().createCriteria(Investor.class).list();
    }

    public Investor getInvestor(String name) {
        Criteria cr = criteria().add(Restrictions.eq("name", name));
        return (Investor) cr.list().get(0);
    }

    public void addInvestor(Investor investor) {
        persist(investor);
    }

    public void removeInvestor(int investorId) {
        Investor investorToBeRemoved = get(investorId);
        currentSession().delete(investorToBeRemoved);
    }

    public void updateInvestor(Investor investor) {
        Investor inv = get(investor.getId());
        inv.setAddress(investor.getAddress());
        inv.setName(investor.getName());
        inv.setSsn(investor.getSsn());
        persist(inv);
    }

}
