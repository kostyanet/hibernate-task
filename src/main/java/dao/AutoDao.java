package dao;

import entity.Auto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.Collections;
import java.util.List;

/*
delete auto
delete all autos
 */


public class AutoDao {
    public void deleteById(int id) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Auto auto = session.get(Auto.class, id);

            if (auto != null) {
                String hql = "DELETE FROM Auto " + "WHERE id = :id";
                Query query = session.createQuery(hql);
                query.setParameter("id", id);
                query.executeUpdate();
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteAll() {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "DELETE FROM Auto";
            Query query = session.createQuery(hql);
            query.executeUpdate();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Auto> listAll() {
        Transaction transaction = null;
        List<Auto> results = Collections.emptyList();;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = " FROM Auto";
            Query<Auto> query = session.createQuery(hql);
            results = query.getResultList();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return results;
    }

    public List<Auto> listByPriceRange(float min, float max) {
        Transaction transaction = null;
        List<Auto> results = Collections.emptyList();;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = " FROM Auto a WHERE a.price BETWEEN :min AND :max";

            Query<Auto> query = session.createQuery(hql);
            query.setParameter("min", min);
            query.setParameter("max", max);
            results = query.getResultList();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return results;
    }

    public Auto getByTitle(String title) {
        Transaction transaction = null;
        Auto auto = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = " FROM Auto a WHERE a.title = :title";
            Query query = session.createQuery(hql);
            query.setParameter("title", title);
            List results = query.getResultList();

            if (results != null && !results.isEmpty()) {
                auto = (Auto) results.get(0);
            }
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return auto;
    }

    public Auto getById(int id) {
        Transaction transaction = null;
        Auto auto = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = " FROM Auto a WHERE a.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            List results = query.getResultList();

            if (results != null && !results.isEmpty()) {
                auto = (Auto) results.get(0);
            }
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return auto;
    }

    public void create(Auto auto) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(auto);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void update(Auto auto) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "UPDATE Auto as a " +
                    "SET title = :title, " +
                    "price = :price, " +
                    "manufactureDate = :manufactureDate, " +
                    "cellDate = :cellDate, " +
                    "gearType = :gearType, " +
                    "fuelVolume = :fuelVolume " +
                    "WHERE id = :id";

            Query query = session.createQuery(hql);
            query.setParameter("id", auto.getId());
            query.setParameter("title", auto.getTitle());
            query.setParameter("price", auto.getPrice());
            query.setParameter("manufactureDate", auto.getManufactureDate());
            query.setParameter("cellDate", auto.getCellDate());
            query.setParameter("gearType", auto.getGearType());
            query.setParameter("fuelVolume", auto.getFuelVolume());

            query.executeUpdate();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
