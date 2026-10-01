package ec.edu.epn.objetos.dao;

import ec.edu.epn.objetos.modelo.ObjetoEncontrado;
import jakarta.persistence.EntityManager;

import java.util.List;

/**
 * Acceso a datos de los objetos encontrados mediante JPA.
 */
public class ObjetoEncontradoDAO {

    public void guardar(ObjetoEncontrado objeto) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<ObjetoEncontrado> listar() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT o FROM ObjetoEncontrado o ORDER BY o.fecha DESC, o.id DESC",
                    ObjetoEncontrado.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void eliminar(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            ObjetoEncontrado objeto = em.find(ObjetoEncontrado.class, id);
            if (objeto != null) {
                em.remove(objeto);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
