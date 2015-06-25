/** 95-702 Distributed Systems 
Example database web service using JPA. */

package edu.cmu.andrew.kmakaew;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

@WebService(serviceName = "StudentListService")
public class StudentListService {    
    @PersistenceUnit EntityManagerFactory emf;
    /**
     * findAllStudentNames is a web service operation.
     * The service takes no arguments but queries the 
     * database and returns a list of names.
     */
    @WebMethod(operationName = "findAllStudentNames")
    public List findAllStudentNames() {
      // build an empty list
      List list = new ArrayList();
      // build a query based on find all records in the table
      Query query = 
                  emf.createEntityManager().createNamedQuery("Studenttable.findAll");
 
      // get the result of the query, a list of records
      List students = query.getResultList();
      // create an iterator over the list of records
      Iterator iter = students.listIterator();
      while(iter.hasNext()) {
          // take a Studenttable record
          Studenttable student = (Studenttable) iter.next();
          // add the students name to the list
          list.add(student.getStudentName());
      }
      // return the list of names
      return list;
    }
    
    @WebMethod(operationName = "createStudent")
    public boolean create(Short id, String name, Double amount) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Studenttable student = new Studenttable();
            student.setScholarshipAmount(new Double(amount));
            student.setStudentName(name);
            student.setStudentId(new Short(id + ""));
            em.persist(student);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            em.close();
        }

    }

    @WebMethod(operationName = "readStudent")
    public Studenttable read(Short id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Studenttable.class, id);
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @WebMethod(operationName = "updateStudent")
    public boolean update(Short id, String name, Double amount) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Studenttable student = em.find(Studenttable.class, id);
            student.setStudentName(name);
            student.setScholarshipAmount(amount);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            em.close();
        }
    }

    @WebMethod(operationName = "deleteStudent")
    public boolean delete(Short id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Studenttable student = em.find(Studenttable.class, id);
            em.remove(student);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            em.close();
        }
    }
}
