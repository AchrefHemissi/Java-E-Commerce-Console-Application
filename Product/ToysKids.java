package Product;

public class ToysKids extends Product {
    private static ToysKids instance = null;

    // Constructeur privé pour empêcher l'instanciation directe depuis l'extérieur
    private ToysKids() {
        super("ToysKids");
    }

    // Méthode statique pour obtenir l'instance unique de la classe
    public static ToysKids getInstance() {
        if (instance == null) {
            instance = new ToysKids();
        }
        return instance;
    }

    @Override
    public void adddefaultarticle() {
        AllArticle.add(new Article(20, "Toy1", 100, "ToysKids", "Description for Toy1 in ToysKids"));
        AllArticle.add(new Article(25, "Toy2", 120, "ToysKids", "Description for Toy2 in ToysKids"));
    }
}
