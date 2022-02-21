package sadyath.grocery;

public class grocery {
    String nom;
    int qteRest;
    String image;

    public grocery(String nom, int qteRest,String image) {
        this.nom = nom;
        this.qteRest = qteRest;
        this.image = image;

    }

    public String getImage() {
        return image;
    }

    public String getNom() {
        return nom;
    }

    public int getQteRest() {
        return qteRest;
    }
}
