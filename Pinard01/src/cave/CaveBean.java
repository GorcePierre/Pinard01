package cave;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import vin.Vin;

@Stateless
public class CaveBean implements CaveRemote {
	
	// ici on précise le gestionnaire de persistance qui nous
	// permet de manipuler des EJB3 Entity
	@PersistenceContext(unitName="persistenceUnit") 
	private EntityManager manager;
	/**
	 * Recherche d'un produit par le code
	 */
	public Vin findByCodeProduit(Integer codeProduit){
		return manager.find(Vin.class, codeProduit);
	}
	/**
	 * Retourne tous les produits dans une liste
	 */
	public Collection findAll(){
	
	// ici, nous verrons que la structure de la requête est particulière
	// et différente d’une requête SQL habituelle
	return manager.createQuery("SELECT v FROM Vin AS v").getResultList();
	}	
	/**
	 * Ajoute un vin
	 */
	public void ajoutVin(Vin vin){
	// la méthode persist() reçoit une référence d’objet en paramètre
		manager.persist(vin);
	}
	/**
	 * Met un jour un enregistrement
	 */
	public Vin updateVin(Vin vin){
		return manager.merge(vin);
	}
	
	/**
	 * détruit un vin en fonction de son code
	 */
	public void deleteVin (Integer codeProduit){
		manager.remove(manager.find(Vin.class, codeProduit));
	}
	
	/**
	 * Met à jour la quantité d'un vin
	 */
	public void updateQuantite(Integer codeProduit,int quantite){
		Vin v=manager.find(Vin.class, codeProduit);
		v.setQuantite(quantite);
	}
}