package folders.db;

import folders.models.Folder;
import folders.models.Owner;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBOwner {
    private static Session session;
    private static Transaction transaction;

        public static List<Folder> allFoldersByOwner(Owner owner){
                session = db.HibernateUtil.getSessionFactory().openSession();
                List<Folder> result = null;
                try{
                    Criteria cr = session.createCriteria(Folder.class);
                    cr.add(Restrictions.eq("owner", owner));
                    result = cr.list();


                }catch (HibernateException e){
                    transaction.rollback();
                    e.printStackTrace();
                }finally {
                    session.close();
                } return result;
            }
}
