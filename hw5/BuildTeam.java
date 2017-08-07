import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Yashveer Singh
 * @version 1.0
 */
public class BuildTeam {
    private static ArrayList<ArrayList<Character>> regionList = new ArrayList<>();
    private static TeamWrapper roster;

    public static void main(String args[]) {
        loadCharacters();
        roster = new TeamWrapper();
        boolean running = true;
        Scanner scan = new Scanner(System.in);
        while(running) {
            boolean input = true;
            int choice = 0;
            while(input) {
                System.out.println("What do you want to do? Enter the corresonding number.\n");
                System.out.println("1: Travel to find more heroes.");
                System.out.println("2: Check team and reserve and make adjustments.");
                System.out.println("3: Fight the White Walkers with your team.");
                System.out.println("4: Quit");
                choice = scan.nextInt();
                input = false;
                if(choice < 1 || choice > 4) {
                    input = true;
                    System.out.println("Invalid selection");
                } else if (choice == 3 && roster.teamSize() == 0) {
                    System.out.println("There's no one on your team!");
                    input = true;
                }
            }

            switch(choice) {
                case 1:
                    travel();
                    break;
                case 2:
                    checkTeam();
                    break;
                case 3:
                    System.out.println("Unfortunately, the White Walkers killed your entire team. You, the Last Hero, are the only one left.");
                    break;
                case 4:
                    running = false;
                    break;
            }
        }
    }

    public static void travel() {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        boolean input = true;
        int choice = 0;
        while(input) {
            System.out.println("Where do you want to go? Enter the corresponding number.\n");
            System.out.println("0: The North.");
            System.out.println("1: Essos");
            System.out.println("2: King's Landing.");
            System.out.println("3: Storm's End");
            System.out.println("4: Dragonstone");
            System.out.println("5: Riverlands");
            System.out.println("6: Dorne");
            choice = scan.nextInt();
            input = false;
            if(choice < 0 || choice > 6) {
                input = true;
            }
        }
        ArrayList<Character> region = new ArrayList<>();
        region = regionList.get(choice);
        int random = rand.nextInt(region.size());
        Character c = region.get(random);
        characterAction(c);
    }

    public static void checkTeam() {
        System.out.println(roster.teamToString());
        System.out.println(roster.reserveToString());
        boolean input = true;
        int choice = 0;
        Scanner scan = new Scanner(System.in);
        while(input) {
            System.out.println("What do you want to do? Enter the corresponding number.\n");
            System.out.println("0: Remove a character from team.");
            System.out.println("1: Remove a character from reserve");
            System.out.println("2: Move a character from reserve to team.");
            System.out.println("3: Move a character from team to reserve.");
            System.out.println("4: Go back");
            choice = scan.nextInt();
            input = false;
            if(choice < 0 || choice > 4) {
                System.out.println("Not a valid selection");
                input = true;
            }
            if((choice ==  1 || choice == 2) && roster.reserveSize() == 0) {
                System.out.println("Your reserve is empty, nothing to move or remove");
                input = true;
            }
            if((choice == 0 || choice == 3) && roster.teamSize() == 0) {
                System.out.println("Your team is empty, nothing to move");
                input = true;
            }
        }

        switch(choice) {
            case 0:
                input = true;
                choice = 0;
                while(input) {
                    System.out.println("Which character do you want to remove? Enter the correspoding number.\n");
                    System.out.println(roster.teamToString());
                    choice = scan.nextInt();
                    input = false;
                    if(choice < 0 || choice >= roster.teamSize()) {
                        System.out.println("Not a valid selection");
                        input = true;
                    }
                }
                roster.removeFromTeam(roster.getFromTeam(choice));
                break;
            case 1:
                input = true;
                choice = 0;
                while(input) {
                    System.out.println("Which character do you want to remove? Enter the corresponding number.\n");
                    System.out.println(roster.reserveToString());
                    choice = scan.nextInt();
                    input = false;
                    if(choice < 0 || choice >= roster.reserveSize()) {
                        System.out.println("Not a valid selection");
                        input = true;
                    }
                }
                roster.removeFromReserve(roster.getFromReserve(choice));
                break;
            case 2:
                input = true;
                choice = 0;
                while(input) {
                    System.out.println("Which character do you want to move to the team?\n");
                    System.out.println(roster.reserveToString());
                    choice = scan.nextInt();
                    input = false;
                    if(choice < 0 || choice >= roster.reserveSize()) {
                        System.out.println("Not a valid selection");
                        input = true;
                    }
                }
                roster.promoteToTeam(roster.getFromReserve(choice));
                break;
            case 3:
                input = true;
                choice = 0;
                while(input) {
                    System.out.println("Which character do you want to move to the reserve?\n");
                    System.out.println(roster.teamToString());
                    choice = scan.nextInt();
                    input = false;
                    System.out.println(roster.teamSize());
                    if(choice < 0 || choice >= roster.teamSize()) {
                        System.out.println("Not a valid selection");
                        input = true;
                    }
                }
                roster.moveToReserve(roster.getFromTeam(choice));
                break;
        }

    }

    public static void characterAction(Character c) {
        System.out.println(c.getMessage());
        System.out.println(c.toString());
        Scanner scan = new Scanner(System.in);
        boolean input = true;
        int choice = 0;
        while(input) {
            System.out.println("What do you want to do with " + c.getName() + "?\n");
            System.out.println("0: Add to team.");
            System.out.println("1: Add to reserve");
            System.out.println("2: Nothing.");
            choice = scan.nextInt();
            input = false;
            if(choice < 0 || choice > 2) {
                input = true;
                System.out.println("Not a valid selection");
            }
        }
        switch(choice) {
            case 0:
                roster.addToTeam(c);
                break;
            case 1:
                roster.addToReserve(c);
                break;
            default:
                break;
        }

    }



    public static void loadCharacters() {
        ArrayList<Character> north = new ArrayList<>();
        ArrayList<Character> essos = new ArrayList<>();
        ArrayList<Character> landing = new ArrayList<>();
        ArrayList<Character> storm = new ArrayList<>();
        ArrayList<Character> dragonstone = new ArrayList<>();
        ArrayList<Character> riverlands = new ArrayList<>();
        ArrayList<Character> dorne = new ArrayList<>();

        north.add(new Character("Ned Stark", 55, 50, false, 0, "Eddard Stark approaches, mumbling 'winter is coming' under his breath."));
        north.add(new Character("Catelyn Stark", 15, 55, false, 0, "Lady Catelyn Stark approaches."));
        north.add(new Character("Robb Stark", 60, 70, false, 0, "The Young Wolf, Robb Stark, rides forth."));
        north.add(new Character("Jon Snow", 80, 0, false, 0, "You find Jon Snow trying to read, but sadly he knows nothing."));
        north.add(new Character("Bran Stark", 0, 90, true, 0, "Bran Stark has a special power, he can warg into other beings."));
        north.add(new Character("Sansa Stark", 10, 65, false, 0, "Sansa Stark approaches."));
        north.add(new Character("Arya Stark", 50, 70, true, 0, "Arya Stark has a special power, she can change faces."));
        north.add(new Character("Rickon Stark", 20, 20, false, 0, "You find Rickon Stark. Who?"));
        north.add(new Character("Ramsay Bolton", 70, 80, false, 0, "Ramsay Bolton approaches with a flaying knife. You want to run away."));
        north.add(new Character("Roose Bolton", 65, 85, false, 0, "Roose Bolton approaches."));
        north.add(new Character("Lyanna Mormont", 10000, 10000, false, 0, "The fierce Lyanna Mormont. You want her on your team."));
        north.add(new Character("Samwell Tarly", 10, 90, false, 0, "Samwell Tarly. He doesn't want to fight."));
        north.add(new Character("Hodor", 40, 0, false, 0, "Hodor"));
        north.add(new Character("Littlefinger", 40, 100, false, 0, "Littlefinger smiles deviously."));

        regionList.add(north);

        essos.add(new Character("Khal Drogo", 93, 60, false, 0, "Khal Drogo rides in on his stallion. He has never been defeated in single combat."));
        essos.add(new Character("Jorah Mormont", 75, 65, false, 0, "Jorah Mormont finds you. He was knight before being exiled."));
        essos.add(new Character("Daario Noharis", 87, 55, false, 0, "Daario Noharis swaggers in. He was an an excellent warrior who won his freedom by his skill in the fighting pits of Meereen"));
        regionList.add(essos);

        landing.add(new Character("Tywin Lannister", 50, 95, false, 0, "Tywin Lannister stares at you menacingly. An excellent war commander."));
        landing.add(new Character("Cersei Lannister", 5, 80, false, 0, "Cersei Lannister gives you a condescending look. She's cunning, but impulsive."));
        landing.add(new Character("Jaime Lannister", 70, 60, false, 0, "Jaime Lannister waves at you with a golden hand. He's still learning to fight with his left hand."));
        landing.add(new Character("Gregor Clegane", 95, 5, false, 0, "You come across Gregor Clegane slaying a large group of peasants. A beast of a human, known as the Mountain Who Rides."));
        landing.add(new Character("Bronn", 85, 60, false, 0, "Bronn swaggers across your path. He's a resourceful, practical warrior."));

        regionList.add(landing);

        storm.add(new Character("Robert Baratheon", 60, 30, false, 0, "Robert Baratheon is too fat for his armor. Lost much of skill as he aged, but was once a fearsome warrior."));
        storm.add(new Character("Stannis Baratheon", 65, 70, false, 0, "You find Stannis Baratheon. A good war commander, decent fighter."));
        storm.add(new Character("Renly Baratheon", 40, 40, false, 0, "You find Renly Baratheon. Meh"));

        regionList.add(storm);

        dragonstone.add(new Character("Daenerys Targaryen", 20, 65, false, 3, "Daenerys Targaryen has 3 dragons. You want her on your side."));
        dragonstone.add(new Character("Tyrion Lannister", 20, 90, false, 0, "Tyrion Lannister drinks and he knows things."));
        dragonstone.add(new Character("Grey Worm", 85, 40, false, 0, "Grey Worm is the head of an elite fighting force known as the Unsullied."));
        dragonstone.add(new Character("Barristan Selmy", 100, 70, false, 0, "The legendary knight, Barristan the Bold, one of the great fighters of all time, even in old age"));
        dragonstone.add(new Character("Melisandre", 40, 90, true, 0, "Melisandre, the Red Woman, has all kinds of powers, including reviving people from death."));
        dragonstone.add(new Character("Theon Greyjoy", 30, 40, false, 0, "Theon Greyjoy was tortured for a long time and lost much of his skill."));
        dragonstone.add(new Character("Yara Greyjoy", 60, 50, false, 0, "Yara Greyjoy has experience as a naval captain."));

        regionList.add(dragonstone);


        riverlands.add(new Character("Beric Dondarrion", 70, 50, true, 0, "Beric Dondarrion's sword can catch fire, and he's already died 6 times."));
        riverlands.add(new Character("Sandor Clegane", 90, 40, false, 0, "Sandor Clegane gives you a mean glare. He's a tank, and a physical beast."));
        riverlands.add(new Character("Thoros of Myr", 65, 60, true, 0, "Thoros of Myr can bring people back from the dead."));
        riverlands.add(new Character("Edmure Tully", 45, 40, false, 0, "Edmure Tully has a hard time shooting arrows"));
        riverlands.add(new Character("The Blackfish", 75, 70, false, 0, "The Blackfish is a legendary warrior, but is old."));

        regionList.add(riverlands);

        dorne.add(new Character("Oberyn Martell", 94, 70, false, 0, "Oberyn Martell, the Red Viper of Dorne. Knows much about poisons and is also a renowned warrior."));
        dorne.add(new Character("Ellaria Sand", 40, 40, true, 0, "You find Ellaria Sand. Staged a coup and assassinataed the leader of her country."));
        dorne.add(new Character("Tyene Sand", 60, 40, true, 0, "You find Tyene Sand, one of the Sand Snakes. Skilled with poison"));
        dorne.add(new Character("Obara Sand", 60, 40, true, 0, "You find Obara Sand, one of the Sand Snakes. Prefers a spear."));
        dorne.add(new Character("Nymeria Sand", 60, 40, true, 0, "You find Nymeria Sand, one of the Sand Snakes. Uses daggers to fight"));

        regionList.add(dorne);



    }
}
