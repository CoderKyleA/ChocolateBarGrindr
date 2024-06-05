package Home;

import org.dreambot.api.input.Mouse;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.input.Camera;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.methods.tabs.Tabs;
import org.dreambot.api.script.TaskNode;

public class AntiBan extends TaskNode {
    public boolean accept() {
        return true;
    }

    public int execute() {
        this.Antiban();
        return 3000;
    }

    public boolean Antiban() {
        int rando = Calculations.random(1, 6);
        switch(rando) {
        case 1:
                break;
        case 2:
            if (!Tabs.isOpen(Tab.INVENTORY)) {
                Tabs.open(Tab.INVENTORY);
                this.sleep((long)Calculations.random(1500, 3300));
                this.log("AntiBan2 opened to Inventory, Idle for 1500 - 3300 ms");
                break;
            }
        case 3:
            Mouse.setMouseDragging(Mouse.moveOutsideScreen());
            this.sleep((long)Calculations.random(5000, 12000));
            this.log("AntiBan3 Moving mouse off screen, Idle for 5000-12000 ms");
            break;
        case 4:
            Camera.rotateToEntity(Players.getLocal());
            Mouse.setMouseDragging(Mouse.moveOutsideScreen());
            this.sleep((long)Calculations.random(8200, 11330));
            this.log("AntiBan4 Camera rotated to Player, Moving mouse off screen, Idle for 8200-11330 ms");
            break;
        case 5:
            Mouse.setMouseDragging(Mouse.moveOutsideScreen());
            this.sleep((long)Calculations.random(12200, 21560));
            this.log("AntiBan5 Moving mouse off screen, Idle for 12200 - 21560 ms");
            break;
        case 6:
            Mouse.setMouseDragging(Mouse.moveOutsideScreen());
            this.sleep((long)Calculations.random(65000, 85100));
            this.log("AntiBan5 Moving mouse off screen, Idle for 65000 - 85100 ms");
        }

        return !Players.getLocal().isAnimating();
    }
}
