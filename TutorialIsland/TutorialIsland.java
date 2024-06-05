package TutorialIsland;

import Home.BuyChocolate;
import org.dreambot.api.input.Mouse;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.container.impl.equipment.Equipment;
import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;
import org.dreambot.api.methods.dialogues.Dialogues;
import org.dreambot.api.methods.input.Camera;
import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.methods.settings.PlayerSettings;
import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.methods.tabs.Tabs;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.script.impl.TaskScript;
import org.dreambot.api.wrappers.interactive.GameObject;


public class TutorialIsland extends TaskScript {
    Tile too3 = new Tile(3125, 3124);
    Area accountmgmt = new Area(3124, 3124, 3124, 3124);

    String str = Widgets.getWidget(263).getChild(1).getChild(0).getText();
    Area shrimp = new Area(3097, 3088, 3106, 3100);
    Area Gate = new Area(3090, 3091, 3090, 3093);
    Area secondhouse = new Area(3079, 3082, 3079, 3085);
    Area thirdhouse = new Area(3087, 3126, 3085, 3126);
    Area miningsmithing = new Area(3075, 9498, 3088, 9506);
    Area combatdoor = new Area(3094, 9503, 3094, 9502);
    Area cbarea = new Area(3103, 9505, 3106, 9524);
    Area rat = new Area(3109, 9517, 3104, 9522);
    Area ladder = new Area(3109, 9525, 3112, 9524);
    Area bank = new Area(3118, 3119, 3124, 3125);
    Area nextdoor = new Area (3129, 3124, 3129, 3124);
    Area prayer = new Area (3128, 3103, 3121, 3109);
    Area magearea = new Area(3140, 3086, 3139, 3091);
    Tile cbtile = new Tile(3106, 9508);
    Tile bankdoor = new Tile(3124, 3124);
    Area tileareadoor = new Area(3125, 3123, 3129, 3125);
    Tile too8 = new Tile(3129, 3124);
    Tile too4 = new Tile(3130, 3124);
    Area bakerarea = new Area(3075, 3082, 3074, 3085);

    @Override
    public int onLoop() {

        log("Tutorial island");
        if (PlayerSettings.getConfig(261) <1000) {

            Widgets.getWidget(263).getChild(1).getChild(0).getText();
            if (Players.getLocal().isMoving()) {
                sleep(5000);
            }
            if (Dialogues.inDialogue()) {
                Dialogues.clickContinue();
            }
            if (Players.getLocal().isAnimating()) {
                sleep(5000);
            }
            if (Players.getLocal().isInCombat()) {
                sleep(5000);
            }
            if (Players.getLocal().isInteractedWith()) {
                Dialogues.clickContinue();
            }
            if (str.contains("display name")) {
                new TutorialIslandChar().execute();
            }
            if (str.contains("Setting your appearance")) {
                new TutorialIslandAppearance().execute();
            }
            if (str.contains("Getting started")) {
                log("It contains getting started");
                if (NPCs.closest(3308) != null) {
                    NPCs.closest(3308).interact("Talk-to");
                    sleep(5000);
                    Dialogues.clickContinue();
                    sleep(2000);
                    Dialogues.clickContinue();
                    sleep(2000);
                    Dialogues.clickContinue();
                    sleep(2000);
                    Dialogues.clickContinue();
                    sleep(2000);
                    Dialogues.clickContinue();
                    sleep(2000);
                    Dialogues.chooseFirstOptionContaining("I am an experienced player.");
                    sleep(2000);
                    Dialogues.clickContinue();
                    sleep(2000);
                    Dialogues.clickContinue();
                    sleep(2000);
                    Dialogues.clickContinue();
                }
            }

            if (str.contains("Settings menu")) {
                Mouse.setPosition(676, 483);
                sleep(500);
                Mouse.click();
                Mouse.click();
                sleep(8000);
                Widgets.getWidget(116).getChild(32).interact("All Settings");
                sleep(2000);
                Widgets.getWidget(134).getChild(24).getChild(69).interact();
                sleep(2000);
                Widgets.getWidget(134).getChild(18).getChild(8).interact("Select");
                sleep(5000);
                Widgets.getWidget(134).getChild(28).getChild(2).interact("Select");
                sleep(5000);
                Widgets.getWidget(134).getChild(4).interact("Close");
                sleep(500);
                if (NPCs.closest(3308) != null) {
                    NPCs.closest(3308).interact("Talk-to");
                    sleep(5000);
                    Dialogues.clickContinue();
                    sleep(2000);
                    Dialogues.clickContinue();
                    sleep(2000);
                    Dialogues.clickContinue();
                    sleep(2000);
                    Dialogues.clickContinue();
                    sleep(2000);
                }
            }

            if (str.contains("first instructor")) {
                log("first instruuctions true");
                if (shrimp.contains(Players.getLocal())) {
                    NPCs.closest(3308).interact("Talk-to");
                    sleep(5000);
                    Dialogues.clickContinue();
                    sleep(2000);
                    Dialogues.clickContinue();

                } else {
                    Walking.walk(shrimp);
                }
            }


            if (str.contains("survival expert")) {
                if (NPCs.closest(8503) != null) {
                    NPCs.closest(8503).interact("Talk-to");
                    Dialogues.clickContinue();
                    Dialogues.clickContinue();
                    sleep(5000);
                }
            }

            if (str.contains("You've been given an item")) {
                log("given an item");
                Mouse.setPosition(642, 187);
                sleep(200);
                Mouse.click();
            }
            Widgets.getWidget(263).getChild(1).getChild(0).getText();

            if (str.contains("This is your inventory")) {
                log("first instruuctions true");
                if (NPCs.closest("Fishing spot") != null) {
                    NPCs.closest("Fishing spot").interact("Net");
                }
            }
            if (str.contains("You've gained some experience")) {
                Mouse.setPosition(577, 182);
                sleep(200);
                Mouse.click();
            }

            if (str.contains("You skills can be leveled up")) {
                NPCs.closest(8503).interact("Talk-to");
                sleep(2000);
                Dialogues.clickContinue();
            }

            if (str.contains("Woodcutting skill")) {
                if (GameObjects.closest("Tree") != null) {
                    GameObjects.closest("Tree").interact("Chop down");
                    sleep(5000);
                    Dialogues.clickContinue();
                }
            }
            if (str.contains("Firemaking")) {
                if (Inventory.contains("Logs") && Inventory.contains("Tinderbox")) {
                    Inventory.interact("Tinderbox");
                    Inventory.interact("Logs");
                }
            }
            if (str.contains("get cooking")) {
                if (GameObjects.closest("Fire") != null) {
                    Inventory.interact("Raw shrimps", "Use");
                    sleep(2000);
                    GameObjects.closest("Fire").interact();
                    sleep(2000);
                    Dialogues.clickContinue();

                }
            }
            if (str.contains("Cooking shrimp")) {
                if (Inventory.contains("Logs")) {
                    Inventory.interact("Tinderbox");
                    Inventory.interact("Logs");
                    sleep(8000);
                    Inventory.interact("Raw shrimps");
                    sleep(2000);
                    GameObjects.closest("Fire").interact();
                } else {
                    if (GameObjects.closest("Tree") != null) {
                        GameObjects.closest("Tree").interact("Chop down");
                        Dialogues.clickContinue();
                    }
                }
            }

            if (str.contains("cooked your first")) {
                log("cooked your first shrimp. opening gate.");
                if (GameObjects.closest("Gate") != null) {
                    GameObjects.closest("Gate").interact("Open");
                    sleep(12000);
                }
            } else {
            Widgets.getWidget(263).getChild(1).getChild(0).getText();
            if (str.contains("yellow arrow")) {
            if (secondhouse.contains(Players.getLocal())) {

                if (GameObjects.closest("Door") != null) {
                    Camera.rotateToEntity(GameObjects.closest("Door"));
                    GameObjects.closest("Door").interact("Open");
                }
            } else {
                Walking.walk(secondhouse);
            }}

        if (str.contains("aspects of Cooking")) {
            if (NPCs.closest(3305) != null) {
                NPCs.closest(3305).interact("Talk-to");
                Dialogues.clickContinue();
                Dialogues.clickContinue();
                Dialogues.clickContinue();
                Dialogues.clickContinue();
                Dialogues.clickContinue();
                Dialogues.clickContinue();
                Dialogues.clickContinue();
                Dialogues.clickContinue();
                sleep(2000);
            }
            }

        if (str.contains("Making dough")) {
            if (Inventory.contains("Pot of flour") && Inventory.contains("Bucket of water")) {
                Inventory.interact("Bucket of water");
                Inventory.interact("Pot of flour");
                Dialogues.clickContinue();
                sleep(2000);
            }
        }

        if (str.contains("Cooking dough")) {
            if (Inventory.contains("Bread dough")) {
                if (GameObjects.closest("Range") != null) {
                    GameObjects.closest("Range").interact("Cook");
                    Dialogues.continueDialogue();
                    sleep(2000);
                }
            }
        }
        if (str.contains("first loaf of bread")) {
            log("first load log");
            Walking.walk(thirdhouse);
            }


        if (str.contains("you can either run or walk")) {
            if (thirdhouse.contains(Players.getLocal())) {
                Tile blah = new Tile(3086, 3126);
                    GameObject door1 = GameObjects.getTopObjectOnTile(blah);
                    door1.interact("Open");
                    sleep(2000);
                if (NPCs.closest(3312) != null) {
                    NPCs.closest(3312).interact("Talk-to");
                    sleep(2000);
                    Dialogues.clickContinue();
                    sleep(2000);

                }
            } else {
                Walking.walk(thirdhouse);
            }
        }

        if (str.contains("Quests")) {
            if (NPCs.closest(3312) != null) {
                NPCs.closest(3312).interact("Talk-to");
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
            }
        }
        if (str.contains("Quest journal")) {
            sleep(1000);
            Mouse.setPosition(613, 186);
            sleep(200);
            Mouse.click();
            sleep(2000);
            if (NPCs.closest(3312) != null) {
                NPCs.closest(3312).interact("Talk-to");
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                Tabs.open(Tab.INVENTORY);
            }
        }
        if (str.contains("It's time to enter")) {
            if (GameObjects.closest("Ladder") != null) {
                GameObjects.closest("Ladder").interact("Climb-down");
            }
        }
        if (str.contains("let's get you a weapon")) {

            if (miningsmithing.contains(Players.getLocal())) {
                log("getting instructor");
                if (NPCs.closest("Mining Instructor") != null) {
                    NPCs.closest("Mining Instructor").interact("Talk-to");
                    sleep(2000);
                    Dialogues.clickContinue();
                    sleep(2000);
                    Dialogues.clickContinue();
                    sleep(2000);
                    Dialogues.clickContinue();
                    sleep(2000);
                    Dialogues.clickContinue();
                }
            }else {
                Walking.walk(miningsmithing);
            }
        }

        if (str.contains("Mining") && Inventory.contains("Bronze pickaxe")) {
            if (GameObjects.closest("Copper rocks") != null) {
                GameObjects.closest("Copper rocks").interact("Mine");
                sleep(10000);
                if (GameObjects.closest("Tin rocks") != null) {
                    GameObjects.closest("Tin rocks").interact("Mine");
                    sleep(10000);
                }
            }

        }
        if (str.contains("Smelting")) {
            if (GameObjects.closest("Furnace") != null) {
                GameObjects.closest("Furnace").interact("Use");
            }
        }

        if (str.contains("You've made a bronze bar")) {
            if (NPCs.closest("Mining Instructor") != null) {
                NPCs.closest("Mining Instructor").interact("Talk-to");
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
            }
        }


        if (str.contains("anvil") && Inventory.contains("Bronze bar") && Inventory.contains("Hammer") && !Players.getLocal().isAnimating()) {
            GameObjects.closest("Anvil").interact("Smith");
            Mouse.setPosition(44, 69);
            sleep(2000);
            Mouse.click();
            sleep(5000);
        }
            if (str.contains("white text under it") && Inventory.contains("Bronze bar") && Inventory.contains("Hammer")) {
                GameObjects.closest("Anvil").interact("Smith");
                sleep(1000);
                Mouse.setPosition(44, 69);
                sleep(1000);
                Mouse.click();
            }

        if (str.contains("through the gates")) {
            log("This is what its getting");
            if (combatdoor.contains(Players.getLocal())) {
                Tile toogate = new Tile(3094, 9503);
               if (GameObjects.closest("Gate") != null){
                   GameObjects.closest("Gate").interact("Open");
                }} else {
                Walking.walk(combatdoor);
            }}

        if (str.contains("ranged combat")) {
                if (NPCs.closest(3307) != null) {
                    NPCs.closest(3307).interact("Talk-to");
                    Dialogues.clickContinue();
                    sleep(200);
                    Dialogues.clickContinue();
                    sleep(200);
                    Dialogues.clickContinue();
                    sleep(200);
                    Dialogues.clickContinue();
                    sleep(200);
                    Dialogues.clickContinue();
                    sleep(200);
                }
            }

        if (str.contains("icon of a man")) {
            log("Equipping Items Tab");
            sleep(200);
            Mouse.setPosition(675, 186);
            sleep(1000);
            Mouse.click();
            sleep(2000);
        }

        if (str.contains("Worn inventory")) {
            Mouse.setPosition(575, 430);
            sleep(1000);
            Mouse.click();
            sleep(2000);
            NPCs.closest(3307).interact("Talk-to");
            Dialogues.clickContinue();
            Dialogues.clickContinue();
            Dialogues.clickContinue();
            Dialogues.clickContinue();
        }
        if (str.contains("Click your dagger")) {
            Equipment.equip(EquipmentSlot.WEAPON, "Bronze dagger");
        }
        if (str.contains("You're now holding your dagger")) {
            NPCs.closest(3307).interact("Talk-to");
            Dialogues.clickContinue();
            Dialogues.clickContinue();
            Dialogues.clickContinue();
            Dialogues.clickContinue();
        }

        //equipswordandshield
        if (str.contains("Unequipping items")) {
            if (Inventory.contains("Bronze sword")) {
                Equipment.equip(EquipmentSlot.WEAPON, "Bronze sword");
                Equipment.equip(EquipmentSlot.SHIELD, "Wooden shield");
            }
        }
        //combatinterfacebutton
        if (str.contains("Click on the flashing crossed swords")) {
            log("opening combat");
            Mouse.setPosition(545, 187);
            sleep(2000);
            Mouse.click();
        }
        //killratswithsword
        if (str.contains("specific attack styles")) {
            if (rat.contains(Players.getLocal())) {
                if (NPCs.closest("Giant rat") != null) {
                    NPCs.closest("Giant rat").interact("Attack");
                }
            } else {
                Walking.walk(rat);
            }
        }
        if (str.contains("slay some rats")) {
            if (rat.contains(Players.getLocal())) {
                if (NPCs.closest("Giant rat") != null) {
                    NPCs.closest("Giant rat").interact("Attack");
                }
            } else {
                Walking.walk(rat);
            }
        }
        if (str.contains("rat until it's dead")) {
            if (!Players.getLocal().isInCombat()) {
                if (rat.contains(Players.getLocal())) {
                    if (NPCs.closest("Giant rat") != null) {
                        NPCs.closest("Giant rat").interact("Attack");
                    }
                } else {
                    Walking.walk(rat);
                }
            }
        }


        //killedfirstratwithwepons
        if (str.contains("you've made your first kill")) {
            if (cbtile.getArea(1).contains(Players.getLocal())) {
                if (NPCs.closest("Combat Instructor") != null) {
                    NPCs.closest("Combat Instructor").interact("Talk-to");
                    Dialogues.clickContinue();
                    sleep(2000);
                    Dialogues.clickContinue();
                    sleep(2000);
                    Dialogues.clickContinue();
                    sleep(2000);

                }
            } else {
                Walking.walk(cbtile);
            }
        }

        //bowandarrowkill

        if (str.contains("Rat ranging")) {
            log("Rat ranging");
            Equipment.equip(EquipmentSlot.WEAPON, "Shortbow");
            Equipment.equip(EquipmentSlot.ARROWS, "Bronze arrow");
            if (NPCs.closest("Giant rat") != null) {
                NPCs.closest("Giant rat").interact("Attack");
            }
        }

        //endcombat
        if (str.contains("You have completed the tasks here")) {
            if (ladder.contains(Players.getLocal())) {
                if (GameObjects.closest("Ladder") != null) {
                    GameObjects.closest("Ladder").interact("Climb-up");
                }
            } else {
                Walking.walk(ladder);

            }
        }

        //Banking1
        if (str.contains("To open your bank")) {
            if (bank.contains(Players.getLocal())) {
                GameObjects.closest("Bank booth").interact("Use");
                sleep(5000);
                Bank.close();
                sleep(2000);
            } else {
                Walking.walk(bank);
            }
        }

        //Banking2
        if (str.contains("poll booth")) {
            if (GameObjects.closest("Poll booth") != null) {
                GameObjects.closest("Poll booth").interact("Use");
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                sleep(5000);
            }
        }
        if (str.contains("When you're ready, move on through the door")) {
            Tile too3 = new Tile(3125, 3124);
            Walking.walk(too3);
            }

        //account mgmt
        if (str.contains("click on him to hear")) {
            if (GameObjects.getObjectsOnTile(too3) != null) {
                GameObject door3 = GameObjects.getTopObjectOnTile(too3);
                door3.interact("Open");
                GameObjects.closest("Door").interact("Open");
                sleep(5000);
            }
        }

        if (str.contains("Account Management")) {
            if (accountmgmt.contains(Players.getLocal())){
                if (GameObjects.getObjectsOnTile(too3) != null) {
                    GameObject door3 = GameObjects.getTopObjectOnTile(too3);
                    door3.interact("Open");
                    sleep(5000);
                    NPCs.closest(3310).interact("Talk-to");

                }}else {
            if (NPCs.closest(3310) != null) {
                NPCs.closest(3310).interact("Talk-to");
                sleep(8000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Mouse.setPosition(609, 486);
                sleep(500);
                Mouse.click();
                sleep(4000);
                NPCs.closest(3310).interact("Talk-to");
                Dialogues.clickContinue();
                sleep(2000);
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                Dialogues.clickContinue();
                sleep(2000);
                if (GameObjects.getObjectsOnTile(too4) != null) {
                    GameObject door4 = GameObjects.getTopObjectOnTile(too4);
                    door4.interact("Open");
                }
            }
        }}

        //prayer

        if (str.contains("Prayer skill")) {
            if (prayer.contains(Players.getLocal())) {
                if (NPCs.closest("Brother Brace") != null) {
                    NPCs.closest("Brother Brace").interact("Talk-to");
                    sleep(2000);
                    Dialogues.continueDialogue();
                    sleep(2000);
                    Mouse.setPosition(711, 192);
                    sleep(2000);
                    Mouse.click();
                    sleep(2000);
                    NPCs.closest("Brother Brace").interact("Talk-to");
                    sleep(2000);
                    Dialogues.clickContinue();
                    sleep(2000);
                    Dialogues.clickContinue();
                    sleep(2000);
                    Dialogues.clickContinue();
                    sleep(2000);
                    Dialogues.clickContinue();
                    sleep(2000);
                }
            } else {
                Walking.walk(prayer);
            }
        }

        if (str.contains("Prayer menu")) {
            Mouse.setPosition(707, 190);
            sleep(2000);
            Mouse.click();
            sleep(2000);
            NPCs.closest("Brother Brace").interact("Talk-to");
            sleep(2000);
            Dialogues.clickContinue();
            sleep(2000);
            Dialogues.clickContinue();
            sleep(2000);
            Dialogues.clickContinue();
            sleep(2000);
            Dialogues.clickContinue();
            sleep(2000);
        }

        if (str.contains("Friends and Ignore list")) {
            Mouse.setPosition(577, 486);
            sleep(2000);
            Mouse.click();
            sleep(2000);
            NPCs.closest("Brother Brace").interact("Talk-to");
            sleep(2000);
            Dialogues.clickContinue();
            sleep(2000);
            Dialogues.clickContinue();
            sleep(2000);
            Dialogues.clickContinue();
            sleep(2000);
            Dialogues.clickContinue();
            sleep(2000);
            if (GameObjects.closest("Door") != null) {
                GameObjects.closest("Door").interact("Open");
            }
        }


                if (str.contains("Your final instructor")) {
                    if (magearea.contains(Players.getLocal())) {
                        if (NPCs.closest("Magic Instructor") != null) {
                            NPCs.closest("Magic Instructor").interact("Talk-to");
                            Dialogues.clickContinue();
                            sleep(500);
                            Dialogues.clickContinue();
                            sleep(500);
                            Dialogues.clickContinue();
                            sleep(500);
                            Dialogues.clickContinue();
                            sleep(500);

                        }
                    } else {
                        Walking.walk(magearea);
                    }
                }

        if (str.contains("Open up the magic interface")) {
            Mouse.setPosition(742, 185);
            sleep(2000);
            Mouse.click();
            sleep(2000);
            NPCs.closest("Magic Instructor").interact("Talk-to");
            Dialogues.clickContinue();
            sleep(500);
            Dialogues.clickContinue();

        }
        if (str.contains("Wind Strike")){
            Mouse.setPosition(643, 325);
            sleep(2000);
            Mouse.click();
            sleep(2000);
            NPCs.closest("Chicken").interact("Cast");
            sleep(20000);
            NPCs.closest("Magic Instructor").interact("Talk-to");
            Dialogues.clickContinue();
            sleep(500);
            Dialogues.clickContinue();
        }

                if (str.contains("Lumbridge")) {
                    NPCs.closest(3309).interact("Talk-to");
                    sleep(2000);
                    Dialogues.clickContinue();
                    sleep(2000);
                    Dialogues.chooseFirstOption("Yes.");
                    sleep(2000);
                    Dialogues.clickContinue();
                    sleep(2000);
                    Dialogues.chooseFirstOption("No, I'm not planning to do that.");
                    sleep(2000);
                    Dialogues.clickContinue();
                    sleep(2000);
                    Dialogues.clickContinue();
                    sleep(2000);
                    Dialogues.clickContinue();
                    sleep(2000);
                    Dialogues.clickContinue();

                    new BuyChocolate().execute();

                    //friends chat

        }
        }}else {
            new BuyChocolate().execute();
        }

        return super.onLoop();
    }}
