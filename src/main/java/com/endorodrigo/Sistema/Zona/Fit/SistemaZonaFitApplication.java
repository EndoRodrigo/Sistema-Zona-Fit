package com.endorodrigo.Sistema.Zona.Fit;

import com.endorodrigo.Sistema.Zona.Fit.model.Customer;
import com.endorodrigo.Sistema.Zona.Fit.service.CustomerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


@SpringBootApplication
public class SistemaZonaFitApplication implements CommandLineRunner {

	@Autowired
	private CustomerServiceImpl customerService;

	private final static Logger log = LoggerFactory.getLogger(SistemaZonaFitApplication.class);


	public static void main(String[] args) {
		log.info("Iniciando servicio de customer servicio");
		SpringApplication.run(SistemaZonaFitApplication.class, args);
		log.info("Finalizando servicio de customer servicio");
	}

	@Override
	public void run(String... args) throws Exception {

		ZonaFitApp();
	}

	private void ZonaFitApp() {
		log.info("*** Aplicacion Zona Fit ***");
		var salir = false;
		var consola = new Scanner(System.in);

		while (!salir) {
			var opcion = showMenu(consola);
			salir = processOption(consola, opcion);
			log.info("");
		}
	}

	private boolean processOption(Scanner consola, int opcion) {
		switch (opcion) {
			case 1 -> {
				log.info("Lista de customers: ");
				var customers = customerService.getCustomers();
				for (var customer : customers) {
					log.info(customer.toString());
				}
			}
			case 2 -> {
				log.info("Busca cliente: ");
				var id = Integer.parseInt(consola.nextLine());
				var customer = customerService.getCustomer(id);
				log.info(customer.toString());
			}
			case 3 -> {
				Customer customer = new Customer();
				log.info("Agregar cliente: ");
				log.info("Nombre: ");
				customer.setName(consola.nextLine());
				log.info("Apellido: ");
				customer.setLastName(consola.nextLine());
				log.info("Staus: ");
				customer.setMenber(consola.nextInt());
				customerService.saveCustomer(customer);
				log.info(customer.toString());

			}
			case 4 -> {
				log.info("Actualiza cliente: ");
				log.info("ID: ");
				var id = consola.nextInt();
				var findCustomer = customerService.getCustomer(id);
				if (findCustomer != null) {
					log.info("Agregar cliente: ");
					log.info("Nombre: ");
					findCustomer.setName(consola.nextLine());

					log.info("Apellido: ");
					findCustomer.setLastName(consola.nextLine());
					log.info("Staus: ");
					findCustomer.setMenber(consola.nextInt());
					customerService.saveCustomer(findCustomer);
					log.info(findCustomer.toString());

				}
			}
			case 5 -> {
				log.info("Eliminar cliente: ");
				log.info("id: ");
				var id = consola.nextInt();
				var findCustomer = customerService.getCustomer(id);
				if (findCustomer != null) {
					customerService.deleteCustomer(id);
				}
				log.info(findCustomer.toString());
			}
			default -> {
				return false;
			}
		}

		return false;
	}

	private int showMenu(Scanner consola) {
		log.info("** Iniciando Menu ***" +
				"\n 1. Listar clientes" +
				"\n 2. Buscar cliente" +
				"\n 3. Agregar cliente" +
				"\n 4. Modificar cliente" +
				"\n 5. Eliminar cliente" +
				"\n 6. Salir" +
				"\n Eleguir una opcion: ");
        return Integer.parseInt(consola.nextLine());
	}


}
