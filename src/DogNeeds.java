public class DogNeeds {

    //main needs of our virtual dog (what we need to do to fulfill them alive!)
    private String dogName;
    private int hunger;
    private int thirst;
    private int attention;
    private int bladder;
    private int energy;
    private int hygiene;
    //dog Constructor
    public DogNeeds(String d){
        dogName = d;
        hunger = 1;
        thirst = 1;
        attention = 1;
        bladder = 1;
        energy = 1;
        hygiene = 1;
    }

    //methods needed to increase/decrease our dog's needs
    public void changeHunger(int h){
        hunger += h;
    }

    public void changeThirst(int t){
        thirst += t;
    }

    public void changeAttention(int a){
        attention += a;
    }

    public void changeEnergy(int e){
        hunger += e;
    }

    public void changeBladder(int b){
        hunger += b;
    }

    public void changeHygiene(int g)
    {
        hygiene += g;
    }

    //on-tick method that will generate randomized game loop
    public void tick(){
        //we add 1 each time a user does something (need max = 5)
        hunger += 1;
        thirst += 1;
        bladder += 1;
        energy += 1;
        attention += 1;
        hygiene += 1;
    }

    //mandatory getter methods
    public String getDogName() {
        return dogName;
    }

    public int getAttention() {
        return attention;
    }

    public int getBladder() {
        return bladder;
    }

    public int getEnergy() {
        return energy;
    }

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public int getHygiene() {
        return hygiene;
    }

    //mandatory setter methods
    public void setAttention(int attention) {
        this.attention = attention;
    }

    public void setBladder(int bladder) {
        this.bladder = bladder;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public void setHygiene(int hygiene) {
        this.hygiene = hygiene;
    }
}
