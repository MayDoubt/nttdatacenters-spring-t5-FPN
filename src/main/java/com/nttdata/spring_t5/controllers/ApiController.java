package com.nttdata.spring_t5.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.spring_t5.repositories.Client;

/**
 * Taller 5 Spring
 * 
 * Rest Controller
 * 
 * @author Fernando Pérez Nieto
 *
 */
@RestController
@RequestMapping("/springRest")
public class ApiController {

/** Simula repositorio */
private static Map<String, Client> clientList;

	/**
	 * Constructor simula repositorio.
	 */
	public ApiController() {
	
		clientList = new HashMap<>();
	
		final Client client1 = new Client("1", "Juan", "Nose", "13-11-1971", "32323232J");
		clientList.put("1", client1);
	
		final Client client2 = new Client("2", "Angustia", "Naranjo", "01-02-2003", "12312312P");
		clientList.put("2", client2);

		final Client client3 = new Client("3", "François", "LePupu", "14-05-1994", "45454545T");
		clientList.put("3", client3);
		
		final Client client4 = new Client("4", "TolMont", "Olalá", "20-08-1984", "84848484L");
		clientList.put("4", client4);
	}
	
	/**
	 * Retorna todos los clientes.
	 * 
	 * @return List<Client>
	 */
	@GetMapping()
	public Map<String, Client> showClients() {
		System.out.println("showClients");
		return 	clientList;
	}
	
	/**
	 * Añade un nuevo cliente.
	 * 
	 * @param newClient
	 */
	@PostMapping
	public void addClient(final @RequestBody Client newClient) {
		
		clientList.put(newClient.getClientId(), newClient);
	}
	
	/**
	 * Elimina un cliente.
	 * 
	 * @param id
	 */
	@DeleteMapping(value = "/{id}")
	public void deleteClient(final @PathVariable String id) {
		
		clientList.remove(id);
	}
	
	/**
	 * Búsqueda por atributos (ID)
	 * 
	 * @param client
	 * @return Client
	 */
	@RequestMapping(path = "/client", method = RequestMethod.GET, consumes = "application/json")
	public Client searchBy(@RequestBody Client client) {
		
		return 	clientList.get(client.getClientId());
	}
}