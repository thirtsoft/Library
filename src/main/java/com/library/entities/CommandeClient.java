package com.library.entities;
import java.time.LocalDate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "commandeClient")
/*@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString */
public class CommandeClient implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numCommande;
	
	/*@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd") */
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
	private Date dateCommande;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy = "commande", fetch=FetchType.EAGER)
	@Valid
	private List<LigneCmdClient> ligneCmdClients = new ArrayList<>();
	
	private double totalCommande;
	
	private String status;

	public CommandeClient() {
		super();
	}

	public CommandeClient(Long id, String numCommande, Date dateCommande, Client client, @Valid List<LigneCmdClient> ligneCmdClients, double totalCommande, String status) {
		this.id = id;
		this.numCommande = numCommande;
		this.dateCommande = dateCommande;
		this.client = client;
		this.ligneCmdClients = ligneCmdClients;
		this.totalCommande = totalCommande;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumCommande() {
		return numCommande;
	}

	public void setNumCommande(String numCommande) {
		this.numCommande = numCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<LigneCmdClient> getLigneCmdClients() {
		return ligneCmdClients;
	}

	public void setLigneCmdClients(List<LigneCmdClient> ligneCmdClients) {
		this.ligneCmdClients = ligneCmdClients;
	}

	public double getTotalCommande() {
		return totalCommande;
	}

	public void setTotalCommande(double totalCommande) {
		this.totalCommande = totalCommande;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
