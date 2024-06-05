package Home;

import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.container.impl.bank.BankMode;
import org.dreambot.api.methods.grandexchange.GrandExchange;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.script.TaskNode;
import org.dreambot.api.utilities.Sleep;

public class GrindChocolate extends TaskNode {


    public boolean accept() {
        return false;
    }

    public int execute() {
        log("Grind Chocolate Node");
        Area GE = new Area(3166, 3484, 3168, 3492);
    if (Players.getLocal().isAnimating()) {
    new AntiBan().execute();

    }else {

        if (Inventory.contains("Bronze axe")){
            if (GE.contains(Players.getLocal())){
                Bank.open();
                Bank.depositAll("Logs");
                Bank.depositAll("Bronze axe");
                Bank.close();
            }else {
                Walking.walk(GE.getRandomTile());
            }
        }else {

        if (Inventory.contains(1973)) {
            if (Inventory.contains("Knife")) {
                Inventory.interact("Knife");
                this.sleep(1000L);
                Inventory.interact(1973);
                sleep(Calculations.random(2500, 3000));
                new GrindChocolate().execute();
            } else {
            (new BuyKnife()).execute();
        }}else {
            if (Inventory.contains(1975)){
                Bank.open();
                Bank.depositAll(1975);
                if (Bank.contains(1973)){
                    Bank.withdrawAll(1973);
                    Bank.close();
                }
            }else {
                if (GE.contains(Players.getLocal())){
                    Bank.open();
            if (Bank.contains("Chocolate Bar")) {
                Bank.withdraw("Chocolate Bar", 27);
                Bank.close();
            } else {
                if (Inventory.contains(1974)){
                    Bank.depositAll(1974);
                    Bank.setWithdrawMode(BankMode.ITEM);
                    Bank.withdraw(1973, 28);
                    Bank.close();
                    sleep(Calculations.random(1000, 2000));
                }else {
                if (Bank.contains("Chocolate dust") && !Bank.contains("Chocolate Bar") && !Inventory.contains("Chocolate bar")){
                    Bank.setWithdrawMode(BankMode.NOTE);
                    Bank.withdrawAll("Chocolate dust");
                    Bank.close();
                    sleep(2000);
                    GrandExchange.open();
                    GrandExchange.sellItem("Chocolate dust", 2000, 145);
                    sleep(5000);
                    GrandExchange.collect();
                    GrandExchange.close();
                }else {
                    new BuyChocolate().execute();
                }

            }
                }
            }else{
                Walking.walk(GE.getRandomTile());
            }}}}}
        return 0;
    }
}

