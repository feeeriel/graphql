package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.Logement;
import entite.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

import java.util.List;

public class Querries implements GraphQLRootResolver {
    private final RendezVousRepository rdvRepo;
    private final LogementRepository logementRepo;

    public Querries(RendezVousRepository rdvRepo, LogementRepository logementRepo) {
        this.rdvRepo = rdvRepo;
        this.logementRepo = logementRepo;
    }

    public List<RendezVous> listRendezVous() {
        return rdvRepo.getListeRendezVous();
    }

    public List<Logement> listLogements() {
        return logementRepo.getAllLogements();
    }

    public List<Logement> logementsByType(Logement.Type type) {
        return logementRepo.getLogementsByType(type);
    }

    public RendezVous rendezVousById(int id) {
        return rdvRepo.getListeRendezVous().stream()
                .filter(r -> r.getId() == id)
                .findFirst()
                .orElse(null);
    }


    public List<RendezVous> rendezVousByLogementRef(int reference) {
        return rdvRepo.getListeRendezVousByLogementRef(reference);
    }
}
