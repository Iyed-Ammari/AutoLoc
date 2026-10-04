package tn.esprit.autoloc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.math.BigDecimal;
import java.util.List;

@Configuration
@Profile("dev") // Ce code ne s'exécutera que si le profil "dev" est actif
public class DataInitializer {

    @Bean
    public CommandLineRunner initVehicules(VehiculeRepository vehiculeRepository) {
        return args -> {
            // On vérifie d'abord si la table est vide pour éviter d'insérer des doublons à chaque redémarrage
            if (vehiculeRepository.count() == 0) {

                Vehicule v1 = new Vehicule(null, "123-TU-4567", "Peugeot", "208",
                        CategorieVehicule.CITADINE, new BigDecimal("80.00"), StatutVehicule.DISPONIBLE);

                Vehicule v2 = new Vehicule(null, "987-TU-6543", "Renault", "Clio",
                        CategorieVehicule.CITADINE, new BigDecimal("75.00"), StatutVehicule.DISPONIBLE);

                Vehicule v3 = new Vehicule(null, "111-TU-2222", "Volkswagen", "Tiguan",
                        CategorieVehicule.SUV, new BigDecimal("150.00"), StatutVehicule.LOUE);

                // Sauvegarde en base
                vehiculeRepository.saveAll(List.of(v1, v2, v3));

                System.out.println("==========================================================");
                System.out.println("=> 3 véhicules de démonstration ont été insérés en base !");
                System.out.println("==========================================================");
            } else {
                System.out.println("=> Les véhicules de démonstration existent déjà.");
            }
        };
    }
}