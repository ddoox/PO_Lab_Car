package samochod.model;

public interface Obserwowany {

    public void subskrybuj(Obserwator o);

    public void odsubskrybuj(Obserwator o);

    public void inform();
}

