package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.Logement;
import entite.RendezVous;
import repository.RendezVousRepository;

public class Mutations implements GraphQLRootResolver {
    private final RendezVousRepository rdvRepo;

    public Mutations(RendezVousRepository rdvRepo) {
        this.rdvRepo = rdvRepo;
    }


    public RendezVous addRendezVous(String date, String heure, int refLogement, String numTel) {
        Logement logement = rdvRepo.getLogementByRDV(refLogement);
        RendezVous newRendezVous = new RendezVous(rdvRepo.getListeRendezVous().size() + 1, date, heure, logement, numTel);
        if (rdvRepo.addRendezVous(newRendezVous)) {
            return newRendezVous;
        }
        return null;
    }


    public RendezVous updateRendezVous(int id, String date, String heure, int refLogement, String numTel) {
        RendezVous rdv = new RendezVous(id, date, heure, rdvRepo.getLogementByRDV(refLogement), numTel);
        if (rdvRepo.updateRendezVous(rdv)) {
            return rdv;
        }
        return null;
    }


    public boolean deleteRendezVous(int id) {
        return rdvRepo.deleteRendezVous(id);
    }
}
