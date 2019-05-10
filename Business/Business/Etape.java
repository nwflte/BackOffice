package Business;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Etape {
	private int etape_id;
	private Employe employe;
	private String etape_nom;
	private LocalDateTime date_creation;
	private LocalDateTime date_modification;
	private boolean archived;
	private int nbr_documents;
	private ArrayList<Document> documents;
}
