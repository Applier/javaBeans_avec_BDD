/**
 * 
 */
package intergiciels.beans;

import java.util.Set;

import javax.persistence.*;

/**
 * @author Jade BOUMAZA
 *
 */

@Entity
public class User {
	
	/* Constructeur */
	
	public User(){
	}
	
	/* Attributs */
	
	// relatifs au compte
	
	@Id
	private String mail;

	private String password;
	
	// infos personnelles relatives au CV
	
	@OneToOne(mappedBy = "user")
	private InfosCV infos;
	
	// offres 
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<Offre> offres;
	
	/* Getters et Setters */
		
	// mail
	public String getMail() {
		return this.mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	// password
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	// infos personnelles relatives au CV
	public InfosCV getInfos() {
		return infos;
	}
	public void setInfos(InfosCV infos) {
		this.infos = infos;
	}
	
	// offres
	public Set<Offre> getOffres() {
		return this.offres;
	}
	public void setOffres(Set<Offre> offres) {
		this.offres = offres;
	}
	
	
	/* M�thodes compl�mentaires sur la Set d'offres */
	public void addOffre(Offre offre) {
		this.offres.add(offre);
	}	
	public void removeOffre(Offre offre) {
		this.offres.remove(offre);
	}
	public void removeAll() {
		this.offres.clear();
	}
	

}
