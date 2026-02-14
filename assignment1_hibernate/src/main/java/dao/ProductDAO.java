package dao;

import entity.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class ProductDAO {

    // Create
    public void save(Product product) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(product);
            transaction.commit();

            System.out.println("Product added successfully! ID = " + product.getId());
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error adding product");
            e.printStackTrace();
        }
    }

    // Get product by id
    public Product getById(Long id) {
        Transaction transaction = null;
        Product product = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            product = session.get(Product.class, id);
            transaction.commit();

            if (product != null)
                System.out.println("Product found: " + product.getName());
            else
                System.out.println("Product not found");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error getting product");
            e.printStackTrace();
        }
        return product;
    }

    // Get all products
    public List<Product> getAll() {
        Transaction transaction = null;
        List<Product> products = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            products = session.createQuery("from Product", Product.class).list();
            transaction.commit();

            System.out.println("Total products: " + products.size());
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error getting products");
            e.printStackTrace();
        }
        return products;
    }

    // Update
    public void update(Product product) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(product);
            transaction.commit();

            System.out.println("Product updated successfully!");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error updating product");
            e.printStackTrace();
        }
    }

    // Delete
    public void delete(Long id) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Product product = session.get(Product.class, id);
            if (product != null) {
                session.remove(product);
                System.out.println("Product deleted successfully!");
            } else {
                System.out.println("Product not found");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error deleting product");
            e.printStackTrace();
        }
    }
}
