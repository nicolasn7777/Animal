package animal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class AnimalHelper {

    EntityManagerFactory emf;
    EntityManager em;

    public AnimalHelper() {
        emf = Persistence.createEntityManagerFactory("mohr");
        em = emf.createEntityManager();
    }

    public Animal getById(int id) {
        em.getTransaction().begin();
        Animal animal = em.find(Animal.class, id);
        em.getTransaction().commit();
        emf.close();
        return animal;
    }

    public void add(Animal a) {
        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
        emf.close();
    }

    public void remove(Animal a) {
        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
        emf.close();
    }

    @SuppressWarnings("unchecked")
    public List<Animal> getAll() {
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT animals FROM Animal animals");
        List<Animal> animals = query.getResultList();
        em.getTransaction().commit();
        emf.close();
        return animals;
    }

}
