package application;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {

    public static void main(String[] args) {

        /*
        Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
        Pessoa p2 = new Pessoa(null, "Joaquina Torres", "joaquina@gmail.com");
        Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
        */

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        // Procura pessoa
        Pessoa p = em.find(Pessoa.class, 2);

        System.out.println(p);

        // Remove pessoa
        Pessoa p1 = em.find(Pessoa.class, 3);
        em.getTransaction().begin(); //usar sempre que fazer uma ação
        em.remove(p1);
        em.getTransaction().commit(); //usar sempre que fazer uma ação

        /*
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();
        */


        System.out.println("Pronto!");
        em.close();
        emf.close();
    }
}
