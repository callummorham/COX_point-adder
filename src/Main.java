import java.io.*;
import java.util.Scanner;

public class Main{

    public static void main(String []args) throws IOException {
        //String filename = "C::\\Users\\Callum Morham\\.runelite\\loots\\callum.morham@gmail.com\\cox\\raid_tracker_data.txt";
        //String filename2 = "C::/Users/Callum Morham /.runelite/loots/callum.morham@gmail.com/cox/raid_tracker_data.txt";
        String filename3 = "C:\\Users\\Callum Morham\\.runelite\\loots\\callum.morham@gmail.com\\cox\\raid_tracker_data.log";
        File file = new File(filename3);
        //File test = new File()
        //int a, b, pointsint,TotalsoloPoints;
        int Totalsolopoints = 0;
        int callumCount = 0;
        int Totalteampoints = 0;
        int purplecount = 0;
        float percent2 = 0;
        String arcane = "Arcane prayer scroll";
        String dex = "Dexterous prayer scroll";
        String buckler = "Twisted Buckler";
        String dhcb = "Dragon hunter crossbow";
        String dins = "Dins's bulwark";
        String anctop = "Ancestral robe top";
        String ancbot = "Ancestral robe bottom";
        String anchat = "Ancestral hat";
        String dclaws = "Dragon Claws";
        String kodai = "Kodai insignia";
        String elder = "Elder maul";
        String tbow = "Twisted bow";
        String callum = "macmaniac77";
        try {
            Scanner scanner = new Scanner(file);

            //now read the file line by line...
            int lineNum = 0;
            String string;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineNum++;
                int falsecheck = 35;
                int falsecheck2 = 36;
                String Falsecheck = line.substring(falsecheck, falsecheck2);
                if(Falsecheck.contains("f")){
                    continue;
                }
                else if(line.contains("personalPoints")){
                    String check = "personalPoints";
                    int a = line.indexOf(check);
                    a = a + 16;
                    int b = a+4;

                    int c = b+1;
                    String pointValueSolo = line.substring(a,b);
                    String teamValue2 = line.substring(b,c);

                    if(!teamValue2.contains(",")){
                        //then use 5
                        pointValueSolo = line.substring(a,c);
                    }
                    else{
                        //use 4
                        pointValueSolo = line.substring(a,b);
                    }

                    int pointsint = Integer.parseInt(pointValueSolo);
                    Totalsolopoints = Totalsolopoints + pointsint;

                    //add 16 for individual
                    //index + 16, also check points, should always be 5 but edgecase for team if 5 or 6
                    //could look at next piece and subtract the 3 from it
                    //or search for the point after and always subtract, then do from there to the original value
                    //minus the 3 or whatever
                }
                if(line.contains("totalPoints")){
                    String check2 = "totalPoints";
                    int d = line.indexOf(check2);
                    d = d + 13;
                    //if for c+6 or c+5
                    int e = d+5;
                    int f = e+1;
                    String teamValue = line.substring(e,f);
                    String pointValueSolo;
                    //char x = line.substring(d,e);
                    if(!teamValue.contains(",")){
                        //then use 6
                        pointValueSolo = line.substring(d,f);
                    }
                    else{
                        //use 5
                        pointValueSolo = line.substring(d,e);
                    }

                    int pointsint2 = Integer.parseInt(pointValueSolo);
                    Totalteampoints = Totalteampoints + pointsint2;
                }
                if(line.contains(arcane)||line.contains(dex)||line.contains(buckler)||line.contains(dhcb)
                        ||line.contains(dins)|| line.contains(tbow)||line.contains(elder)||line.contains(dclaws)
                        ||line.contains(kodai)||line.contains(anctop)||line.contains(ancbot)||line.contains(anchat)){
                    if(line.contains(callum)){
                        callumCount++;
                    }
                    purplecount++;
                }
            }
            //Missing line

            /* Literally no fucking idea why this one breaks it but the whole program stops upon reaching it regardless
            of the location
            *{"chestOpened":true,"raidComplete":true,"loggedIn":true,"challengeMode":false,"inRaidChambers":true,
            * "FreeForAll":false,"upperTime":636,"middleTime":-1,"lowerTime":1463,"raidTime":2140,"totalPoints":73902,
            * "personalPoints":33271,"teamSize":4,"percentage":45.020432464615304,"completionCount":154,
            * "specialLoot":"Ancestral hat","specialLootReceiver":"Leo Wong","specialLootValue":13028072,
            * "kitReceiver":"","dustReceiver":"","lootSplitReceived":3257018,"lootSplitPaid":-1,"lootList":
            * [{"name":"Grimy avantoe","id":211,"quantity":102,"price":1836},{"name":"Mahogany plank","id":8782,
            * "quantity":139,"price":208500}],"uniqueID":"8bf8bcf7-f2e2-4ed3-822a-3095ad86494f"}
             */

            //purplecount = purplecount-2; Purples with other team, lines have been removed
            //callumCount--;
            System.out.println("Total Solo Points: " + Totalsolopoints);
            float percent = (Totalsolopoints / 8675);
            System.out.println("Solo percent chance: " + percent);
            System.out.println("Number of purples solo: " + callumCount);//add
            float soloRate = callumCount*100;
            soloRate = percent - soloRate;
            System.out.println("Number of purples dry solo: " + (soloRate/100));
            System.out.println("Total Team Points: " + Totalteampoints);
            percent2 = (Totalteampoints / 8675);
            float Totalrate = purplecount*100;
            Totalrate = percent2 - Totalrate;
            System.out.println("Team percent Chance: " + percent2);
            System.out.println("Number of purples: "+ purplecount);
            System.out.println("Number of purples dry as a team: " + (Totalrate/100));
            System.out.println("Cox completions logged: " + lineNum);

        }catch(FileNotFoundException e) {
            //handle this
        }

        }
    }
