package in.ineuron;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import in.ineuron.hibernateutil.*;
import in.ineuron.model.Student;


public class GetRecordApp 
{
	
    public static void main( String[] args )
    {
    	Session session = null;
    	Student student = null;
    	int id = 1;
    
    	
    	try {
    		session = HibernateUtil.getSession();
    		
    		if(session != null) {
    			student = session.get(Student.class, id);
    		}
    		
    		if(student != null) {
    			System.out.println(student);
    		}
    		else {
    			System.out.println("Student ID is invalid");
    		}
    		
    	}
    	catch(HibernateException he) {
    		he.printStackTrace();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	finally {
    		HibernateUtil.closeSession(session);
    		HibernateUtil.closeSessionFactory();
		}
    	
    }
}
