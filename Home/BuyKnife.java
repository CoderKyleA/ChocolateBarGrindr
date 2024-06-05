package Home;

import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.grandexchange.GrandExchange;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.script.TaskNode;

public class BuyKnife extends TaskNode {


    public boolean accept() {
        return false;
    }

    public int execute() {
        log("Buy Knife Node");
        Area GE = new Area(3166, 3484, 3168, 3492);
        if (GE.contains(Players.getLocal())) {
            GrandExchange.open();
            this.sleep(2000L);
            GrandExchange.buyItem("Knife", 1, 105);
            this.sleep(6000L);
            GrandExchange.collect();
            this.sleep(2000L);
            if (Inventory.contains("Knife")) {
                (new BuyChocolate()).execute();
            }else {
                GrandExchange.open();
                if (GrandExchange.isReadyToCollect()){
                    GrandExchange.collect();
                }
            }
        }

        return 0;
    }
}
