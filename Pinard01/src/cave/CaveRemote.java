package cave;

import java.util.Collection;

import javax.ejb.Remote;

import vin.Vin;

@Remote
public interface CaveRemote {
    public Vin findByCodeProduit(Integer codeProduit);
    public Collection<Vin> findAll();
    public void ajoutVin(Vin vin);
    public Vin updateVin(Vin vin);
    public void deleteVin (Integer codeProduit);
    public void updateQuantite(Integer codeProduit,int quantite); 
}