import java.util.Scanner;

public class DogApplication {

    public static void main(String[] args) {
        int select;

        //allow us to get user input
        Scanner input = new Scanner(System.in); //creates a scanner object
        System.out.println("Who is the goodest boy ever? (Enter your dogs name)");
        String dogName = input.nextLine();

        //create a new dog with needs object
        DogNeeds dog = new DogNeeds(dogName);

        //instructions
        needsMenu(dogName);

        do {
            System.out.println("What do you want to do today?");
            System.out.println(">> [0] Take " + dogName + " for a walk.");
            System.out.println(">> [1] Feed " + dogName + " their favorite treats.");
            System.out.println(">> [2] Refill " + dogName + "'s water bowl.");
            System.out.println(">> [3] Groom " + dogName + "'s coat.");
            System.out.println(">> [4] Take " + dogName + " out to potty.");
            System.out.println(">> [5] Play with " + dogName + ".");
            System.out.println(">> [6] Let " + dogName + " get some sleep.");
            System.out.println(">> [7] Quit.");

            //will select the int[0-7] that user chose
            select = input.nextInt();

            //exit the console, hence quitting the game
            if (select == 7) {
                continue;
            }

            //Take dog for walk
            else if (select == 0) {
                //if the attention is full, the dog won't want to walk
                if (dog.getAttention() < 5) {
                    System.out.println(">> Mmh, it doesn't seem like " + dogName + " wants to go for a walk right now. Try again later.");
                    continue;
                }

                System.out.println(">> " + dogName + " really enjoyed that walk!");
                //alter needs
                dog.changeAttention(+1);
                dog.changeEnergy(-1);
                dog.changeHygiene(-1);
                showDogCurrentNeeds(dog);
            }

            //Feed the dog their favorite treats
            else if (select == 1) {
                if (dog.getHunger() > 5) {
                    System.out.println(">> Mmh, it seems like " + dogName + " is too full to eat right now. Try again later.");
                    continue;
                }

                System.out.println(">> " + dogName + " really enjoyed that treat!");
                //alter needs
                dog.changeHunger(+1);
                dog.changeEnergy(+1);
                dog.changeThirst(-1);
                dog.changeAttention(+1);
                showDogCurrentNeeds(dog);
            }

            //Refill the dogs' water bowl
            else if (select == 2) {

                if (dog.getThirst() > 5) {
                    System.out.println(">> Mmh, it seems like " + dogName + " is not really thirsty.");
                    continue;
                }

                System.out.println(">> " + dogName + " really enjoyed the clean water!");
                //alter needs
                dog.changeThirst(+1);
                dog.changeBladder(-1);
                showDogCurrentNeeds(dog);
            }

            //groom dog
            else if (select == 3) {
                if (dog.getHygiene() > 5) {
                    System.out.println(">> Mmh, it seems like " + dogName + " is not that dirty right now.");
                    continue;
                }

                System.out.println(">> " + dogName + " smells much better now!");
                //change needs
                dog.changeHygiene(+1);
                dog.changeEnergy(-1);
                showDogCurrentNeeds(dog);
            }

            //Take dog out to potty
            else if (select == 4) {

                if (dog.getBladder() > 5) {
                    System.out.println(">> Mmh, it seems like " + dogName + " does not need to potty right now.");
                    continue;
                }

                System.out.println(">> Phew, that was close. " + dogName + " really had to go!");
                //change needs
                dog.changeHygiene(-1);
                dog.changeBladder(+1);
                showDogCurrentNeeds(dog);
            }

            //Play with dog
            else if (select == 5) {

                if (dog.getAttention() > 5) {
                    System.out.println(">> Mmh, it seems like " + dogName + " is a little annoyed now. Maybe give them some space.");
                    continue;
                }

                System.out.println(">> " + dogName + " loved spending time with you!");
                //change needs
                dog.changeAttention(+1);
                dog.changeEnergy(-1);
                showDogCurrentNeeds(dog);
            }

            //Let dog sleep
            else if (select == 6) {

                if (dog.getEnergy() > 5) {
                    System.out.println(">> Mmh, it seems like " + dogName + " is not really tired.");
                    continue;
                }

                System.out.println(">> Zzzzzzzz");
                //change needs
                dog.changeEnergy(+1);
                dog.changeHunger(-1);
                dog.changeThirst(-1);
                dog.changeBladder(-1);
                showDogCurrentNeeds(dog);
            }

            //if nothing was chosen
            else {
                System.out.println(">> You need to choose something to do with " + dogName + " first!");
            }
            //enables dogs' needs change upon each selection
            dog.tick();
        } while (select != 7); //because 7 means quit

    }

    //displays current needs
    private static void showDogCurrentNeeds(DogNeeds dog) {
        //displays current needs
            System.out.println(">> Hunger: " + dog.getHunger());
            System.out.println(">> Thirst: " + dog.getThirst());
            System.out.println(">> Attention: " + dog.getAttention());
            System.out.println(">> Bladder: " + dog.getBladder());
            System.out.println(">> Hygiene: " + dog.getHygiene());
            System.out.println(">> Energy: " + dog.getEnergy());
    }

    //method needed to print out game instructions
    public static void needsMenu(String dogName)
    {
        System.out.println(
                "-----------------------------------------------------------------------------------------------" +
                        "\n>> Welcome to parenthood! You are now the proud new owner of "  + dogName + "!" +
                        "                                  \n" +
                        "                            |' \\ \n" +
                        "         _                  ; : ; \n" +
                        "        / `-.              /: : | \n" +
                        "       |  ,-.`-.          ,': : | \n" +
                        "       \\  :  `. `.       ,'-. : | \n" +
                        "        \\ ;    ;  `-.__,'    `-.| \n" +
                        "         \\ ;   ;  :::  ,::'`:.  `. \n" +
                        "          \\ `-. :  `    :.    `.  \\ \n" +
                        "           \\   \\    ,   ;   ,:    (\\ \n" +
                        "            \\   :., :.    ,'o)): ` `-. \n" +
                        "           ,/,' ;' ,::\"'`.`---'   `.  `-._ \n" +
                        "         ,/  :  ; '\"      `;'          ,--`. \n" +
                        "        ;/   :; ;             ,:'     (   ,:) \n" +
                        "          ,.,:.    ; ,:.,  ,-._ `.     \\\"\"'/ \n" +
                        "          '::'     `:'`  ,'(  \\`._____.-'\"' \n" +
                        "             ;,   ;  `.  `. `._`-.  \\\\ \n" +
                        "             ;:.  ;:       `-._`-.\\  \\`. \n" +
                        "              '`:. :        |' `. `\\  ) \\ \n" +
                        "                ` ;:       |    `--\\__,' \n" +
                        "                   '`      ,' \n" +
                        "                        ,-' " +
                        "\n>> Remember, " + dogName + " has needs! Being a pet owner is a lot of work." +
                        "\n>> " + dogName + " needs clean water, food, sleep, grooming, playtime, and lot's of attention." +
                        "\n>> Good luck!" +
                        "\n-----------------------------------------------------------------------------------------------"
        );
    }
}
