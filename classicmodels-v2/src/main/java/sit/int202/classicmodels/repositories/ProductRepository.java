package sit.int202.classicmodels.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sit.int202.classicmodels.entities.Office;
import sit.int202.classicmodels.entities.Product;

import java.util.List;

public class ProductRepository {
    private EntityManager entityManager;

    private EntityManager getEntityManager() {
        if
        (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }
    private static int PAGE_SIZE = 10;

    public int getDefaultPageSize() {
        return PAGE_SIZE;
    }

    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }

    public List<Product> findAll(int page, int pageSize) {
        int startPosition = (page - 1) * pageSize;
        Query query = getEntityManager().createNamedQuery("PRODUCT.FIND_ALL");
        query.setFirstResult(startPosition);
        query.setMaxResults(pageSize);
        List<Product> productList = query.getResultList();
        return productList;
    }

    public int countAll() {
        int number = ((Number) getEntityManager().createNamedQuery("PRODUCT.COUNT").getSingleResult()).intValue();
        return number;
    }

    public Product findProduct(String productCode) {
        return getEntityManager().find(Product.class, productCode);
    }

}
