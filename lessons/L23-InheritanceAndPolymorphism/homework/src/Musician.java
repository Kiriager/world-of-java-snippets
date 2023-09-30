public class Musician extends Person {
  private String instrument;

  public Musician() {
  }

  public Musician(String name, String instrument) {
    super(name);
    this.instrument = instrument;
  }

  public String getInstrument() {
    return instrument;
  }

  public void setInstrument(String instrument) {
    this.instrument = instrument;
  }

  public void playMusic() {
    System.out.println(getName() + " is palying " + instrument + ".");
  }

  @Override
  public void sayHello() {
    System.out.println(getName() + " says hey-hey la-la-la!");
  }
}
