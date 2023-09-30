public class Container {
  private static final int MIN_VOLUME = 500;
  private static final int MAX_VOLUME = 5000;

  private int containerVolume;
  private int contentsVolume = 0;

  public Container(int containerVolume) {
    this.containerVolume = Limiter.constrain(containerVolume, MIN_VOLUME, MAX_VOLUME);
  } 

  public void fill(int volume) {
    contentsVolume = Limiter.constrain(contentsVolume + volume, 0, containerVolume);
  }

  public void spend(int volume) {
    contentsVolume = Limiter.constrain(contentsVolume - volume, 0, containerVolume);
  }

  public int getContentsVolume() {
    return contentsVolume;
  }

  public int getContainerVolume() {
    return containerVolume;
  }
}
