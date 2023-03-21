package it.softwareInside.MagazzinoStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.softwareInside.MagazzinoStore.models.Item;
import it.softwareInside.MagazzinoStore.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;

	
	/**
	 * Prende in input un oggetto di tipo Item e , se l'oggetto non è nullo,
	 * lo aggiunge al Database ritornando true, altrimenti ritorna false.
	 * @param item
	 * @return
	 */
	public boolean creaOggetto(Item item) {

		if (item == null)
			return false;

		try {

			itemRepository.save(item);
			return true;

		} catch (Exception e) {

			return false;

		}

	}

	
	/**
	 * Prende in input un id e rimuove dal Database l'Item che si trova a quel id
	 * ritornando l'oggetto cancellato.
	 * @param id
	 * @return
	 */
	public Item rimuoviOggetto(int id) {
		
		try {
			
			Item deleteItem = itemRepository.findById(id).get();
			itemRepository.deleteById(id);
			return deleteItem;
			
		} catch (Exception e) {
			
			return null;
		}

	}

	
	/**
	 * Prende in input una password di tipo String, se la password risulta corretta
	 * rimuove tutti gli oggetti dal Database e torna true, altrimenti ritorna false.
	 * @param password
	 * @return
	 */
	public boolean rimuoviTutto(String password) {

		String myPassword = "1234";

		if (password.equals(myPassword)) {
			itemRepository.deleteAll();
			return true;
		} else
			return false;
	}

	
	/**
	 * Prende in input un id e torna l'oggetto che si trova in quell'id
	 * nel database.
	 * @param id
	 * @return
	 */
	public Item getItembyId (int id) {
		
		try {
			
			return itemRepository.findById(id).get();
			
		} catch (Exception e) {

			return null;
		}
	}
	
	
	
	
	
	/**
	 * Metodo che da la somma del costo di tutti gli oggetti
	 * presenti nel Database.
	 * @return
	 */
	public int somma() {

		int somma = 0;

		for (Item item : itemRepository.findAll()) {
			somma += item.getCosto();
		}

		return somma;
	}

}
