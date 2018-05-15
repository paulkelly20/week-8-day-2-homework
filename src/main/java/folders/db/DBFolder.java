package folders.db;

import folders.models.File;
import folders.models.Folder;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBFolder {
    private static Session session;
    private static Transaction transaction;

        public static List<File> findAllFiles(Folder folder){
                session = db.HibernateUtil.getSessionFactory().openSession();
                List<File> files = null;
                try{
                    Criteria cr = session.createCriteria(File.class);
                    cr.add(Restrictions.eq("folder", folder));
                    files = cr.list();

                }catch (HibernateException e){
                    transaction.rollback();
                    e.printStackTrace();
                }finally {
                    session.close();
                } return files;
            }
}
