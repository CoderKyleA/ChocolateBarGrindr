package Home;

import TutorialIsland.GetCoins;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.container.impl.bank.BankMode;
import org.dreambot.api.methods.grandexchange.GrandExchange;
import org.dreambot.api.methods.grandexchange.GrandExchangeItem;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.script.TaskNode;

public class BuyChocolate extends TaskNode {


    public boolean accept() {
        return false;
    }

    public int execute() {
        if (GrandExchange.isReadyToCollect()){
            GrandExchange.open();
            GrandExchange.collect();
            GrandExchange.close();
        }else {
            log("Buy Chocolate Node");
            Area GE = new Area(3166, 3484, 3168, 3492);
            int coins = Inventory.count("Coins");
            int amt = coins / 145;
            if (GE.contains(Players.getLocal())) {
                Inventory.count("Coins");
                GrandExchange.open();
                if (Inventory.count("Coins") >= 145) {
                    GrandExchange.buyItem("Chocolate Bar", amt, 145);
                    sleep(5000);
                    GrandExchange.collect();
                    GrandExchange.close();
                } else {
                    new GetCoins().execute();
                }
                if (Inventory.contains(1973)) {
                    (new GrindChocolate()).execute();
                } else {
                    if (Inventory.contains(1976)) {
                        Bank.open();
                        Bank.deposit(1976);
                        Bank.setWithdrawMode(BankMode.ITEM);
                        Bank.withdraw(1973, 28);
                        Bank.close();
                    }
                }
            } else {
                Walking.walk(GE.getRandomTile());
            }
        }
        return 0;
    }
}