public class Homework {
  public static void main(String[] args) {
    Person me = new Person();
    me.setName("John Doe");
    me.sayHello();
    
    Musician myFriend = new Musician();
    myFriend.setName("Jack Doe");
    myFriend.setInstrument("guitar");
    myFriend.sayHello();
    myFriend.playMusic();
  }
}
