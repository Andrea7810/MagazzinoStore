package it.softwareInside.MagazzinoStore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Item {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;

	private double costo;
	private String marca;
	private String tipologia;

	public Item(double costo, String marca, String tipologia) {

		setCosto(costo);
		setMarca(marca);
		setTipologia(tipologia);
	}
}
