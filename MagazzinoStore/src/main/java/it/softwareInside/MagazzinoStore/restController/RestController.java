package it.softwareInside.MagazzinoStore.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import it.softwareInside.MagazzinoStore.models.Item;
import it.softwareInside.MagazzinoStore.service.ItemService;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	ItemService itemService;

	@PostMapping("/crea-oggetto")
	public boolean createItem(@RequestBody Item item) {

		return itemService.creaOggetto(item);
	}

	@DeleteMapping("/cancella-oggetto")
	public Item deleteItem(@RequestParam(name = "id") int id) {

		return itemService.rimuoviOggetto(id);
	}

	@GetMapping("rimuovi-tutto")
	public boolean removeAll(@RequestParam(name = "pass") String password) {

		return itemService.rimuoviTutto(password);
	}

	@PostMapping("/update")
	public boolean uptadeItem(@RequestBody Item item) {

		return itemService.creaOggetto(item);
	}
	
	
	@GetMapping("/oggetto-per-id")
	public Item getItemById (@RequestParam(name = "id") int id) {
		
		return itemService.getItembyId(id);
	}
		

	@GetMapping("/somma-costi")
	public int costiTotali() {

		return itemService.somma();
	}

}
