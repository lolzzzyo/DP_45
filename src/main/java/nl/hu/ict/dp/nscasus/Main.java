package nl.hu.ict.dp.nscasus;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    private static String orclcfg = "nl.hu.ict.jpa.oracle";
    private static EntityManagerFactory entityManagerFactory;

    public static void main(String[] args) {
        EntityManager em = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(orclcfg);
            em = entityManagerFactory.createEntityManager();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        OVChipkaart ov1 = new OVChipkaart();
        ov1.setKaartopdruk("kaart 1");
        ov1.setGeldigheid(java.sql.Date.valueOf("2018-07-07"));
        
        OVChipkaart ov2 = new OVChipkaart();
        ov2.setKaartopdruk("kaart 2");
        ov2.setGeldigheid(java.sql.Date.valueOf("2022-02-10"));
        
        OVChipkaart ov3 = new OVChipkaart();
        ov3.setKaartopdruk("kaart 3");
        ov3.setGeldigheid(java.sql.Date.valueOf("2099-01-01"));
        
        OVChipkaart ov4 = new OVChipkaart();
        ov4.setKaartopdruk("kaart 4");
        ov4.setGeldigheid(java.sql.Date.valueOf("1966-02-01"));
        
        Reiziger r1 = new Reiziger(); 
        r1.setAchternaam("Lok");
        r1.setVoorletters("C");
        r1.setTussenvoegsel("");   
        
        Reiziger r2 = new Reiziger(); 
        r2.setAchternaam("Bosman");
        r2.setVoorletters("M");
        r2.setTussenvoegsel("");
        
        Reiziger r3 = new Reiziger(); 
        r3.setAchternaam("Dijk");
        r3.setVoorletters("Jan");
        r3.setTussenvoegsel("van");
        
        r1.addKaart(ov4);
        r1.addKaart(ov1);
        r2.addKaart(ov3);
        r3.addKaart(ov2);
        
        em.getTransaction().begin();
        em.persist(r1);
        em.persist(r2);
        em.persist(r3);
        em.persist(ov1);
        em.persist(ov2);
        em.persist(ov3);
        em.persist(ov4);
       
        em.getTransaction().commit();
        System.out.println(em.find(Reiziger.class, 1).toString());
        System.out.println(em.find(Reiziger.class, 2).toString());
        System.out.println(em.find(Reiziger.class, 3).toString());
        em.close();
    }
}
