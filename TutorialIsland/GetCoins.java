package TutorialIsland;

import Home.AntiBan;
import Home.BuyChocolate;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.container.impl.bank.BankLocation;
import org.dreambot.api.methods.grandexchange.GrandExchange;
import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.script.TaskNode;

public class GetCoins extends TaskNode {

    @Override
    public boolean accept() {
        return false;
    }

    @Override
    public int execute() {
    log("Making a few coins before questing...");

        Area treeArea = new Area(3173, 3440, 3152, 3463);
        Area GE = new Area(3166, 3484, 3168, 3492);
        if (Players.getLocal().isAnimating()){
            new AntiBan().execute();
        }else {


        if (Inventory.contains(590)){
            log("Banking all of these items to make room for logs..");
            if (BankLocation.LUMBRIDGE.canReach()){
                Bank.open();
                if (Bank.isOpen()){
                Bank.depositAllExcept("Bronze axe");
                Bank.close();
            } else {
                log("Walking to Bank");
                Walking.walk(BankLocation.LUMBRIDGE);
            }}}else {
            if (!Inventory.isFull()){
                if (Inventory.contains("Bronze axe")) {
                    if (treeArea.contains(Players.getLocal())) {
                    if (GameObjects.closest("Tree") != null) {
                        GameObjects.closest("Tree").interact("Chop down");
                    } else {
                        log("Walking to trees outside of Grand Exchange...");
                        Walking.walk(treeArea.getRandomTile());
                    }
                }else {
                    log("Moving to tree area");
                    Walking.walk(treeArea);
                }} else {
                    log("Grabbing an axe");
                    if (GE.contains(Players.getLocal())) {
                        Bank.open();
                        if (Bank.contains("Bronze axe")) {
                            Bank.withdraw("Bronze axe");
                            Bank.close();
                            new GetCoins().execute();
                        }
            }else {
                        Walking.walk(GE.getRandomTile());
                    }
                }}else {
                    if (GE.contains(Players.getLocal())) {
                        GrandExchange.open();
                        GrandExchange.sellItem("Logs", 27, 25);
                        sleep(5000);
                        GrandExchange.collect();
                        GrandExchange.close();
                        if (Inventory.count("Coins") >= 100) {
                            new BuyChocolate().execute();
                        }else {
                            new GetCoins().execute();
                        }
                    } else {
                        Walking.walk(GE.getRandomTile());
                }
            }
        }}
        return 0;
    }
}
