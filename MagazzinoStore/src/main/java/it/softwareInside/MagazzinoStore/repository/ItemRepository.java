package it.softwareInside.MagazzinoStore.repository;

import org.springframework.data.repository.CrudRepository;

import it.softwareInside.MagazzinoStore.models.Item;

public interface ItemRepository extends CrudRepository<Item, Integer>{

}
