package Home;
import TutorialIsland.GetCoins;

import TutorialIsland.TutorialIsland;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.quest.book.FreeQuest;
import org.dreambot.api.methods.settings.PlayerSettings;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;


@ScriptManifest(
        category = Category.MONEYMAKING,
        name = "Chocolate Grinder",
        author = "Kyle2016A",
        version = 1.0D)


public class Main extends AbstractScript {
    @Override
    public int onLoop() {
        Area GE = new Area(3166, 3484, 3168, 3492);

        if (Players.getLocal().isMoving()){
            sleep(Calculations.random(1000, 2500));
        }

        if (PlayerSettings.getConfig(281) < 1000) {
            new TutorialIsland().onLoop();
        } else {

                            new GrindChocolate().execute();

            }
        return 0;
    }
}
