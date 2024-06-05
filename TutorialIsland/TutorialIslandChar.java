package TutorialIsland;

import org.dreambot.api.input.Keyboard;
import org.dreambot.api.input.event.impl.keyboard.awt.Key;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.script.TaskNode;

import java.util.Random;

public class TutorialIslandChar extends TaskNode {
    String str = Widgets.getWidget(558).getChild(6).getText();


    @Override
    public boolean accept() {
        return false;
    }

    @Override
    public int execute() {
        log("Tutorial island display name");

            Widgets.getWidget(558).getChild(13).getText();
            if (Widgets.getWidget(558).getChild(13).getText().contains("Great!") && (Widgets.getWidget(558).getChild(19).getText().contains("Look up"))){
                Widgets.getWidget(558).getChild(19).interact("Set name");
                sleep(2000);
            }else {

                Widgets.getWidget(558).getChild(13).getText();
            if (Widgets.getWidget(558).getChild(13).getText().contains("Please enter")) {
                log("contains  please enter");
                Widgets.getWidget(558).getChild(7).getText();
                sleep(2000);
                Widgets.getWidget(558).getChild(7).interact("Enter name");
                sleep(2000);
                Keyboard.type(generateRandomChars());
                sleep(2000);
                Keyboard.typeKey(Key.ENTER);
                sleep(2000);

                Widgets.getWidget(558).getChild(13).getText();
                if (Widgets.getWidget(558).getChild(13).getText().contains("Great!")) {
                    Widgets.getWidget(558).getChild(19).interact("Set name");
                    Widgets.getWidget(558).getChild(19).interact("Set name");
                    Widgets.getWidget(558).getChild(19).interact("Set name");
                    sleep(2000);
                } else {
                    if (Widgets.getWidget(558).getChild(13).getText().contains("Sorry")) {
                        Widgets.getWidget(558).getChild(7).getText();
                        Widgets.getWidget(558).getChild(7).interact("Enter name");
                        Keyboard.type(Key.BACKSPACE);
                        Keyboard.type(generateRandomChars());
                        sleep(2000);
                        Keyboard.type(Key.ENTER);
                        sleep(2000);
                        new TutorialIslandChar().execute();
                    }
                }
            } else {
                if (Widgets.getWidget(558).getChild(13).getText().contains("Please look up")) {
                    log("contains  please look up");
                    Widgets.getWidget(558).getChild(7).getText();
                    Widgets.getWidget(558).getChild(7).interact("Enter name");
                    Keyboard.type(generateRandomChars());
                    Keyboard.type(Key.ENTER);
                    Widgets.getWidget(558).getChild(13).getText();
                    if (Widgets.getWidget(558).getChild(13).getText().contains("Great!")) {
                        log("contains great");
                        Widgets.getWidget(558).getChild(19).interact("Set name");
                        Widgets.getWidget(558).getChild(19).interact("Set name");
                        Widgets.getWidget(558).getChild(19).interact("Set name");

                        new TutorialIslandAppearance().execute();
                        sleep(2000);
                    } else {
                        if (Widgets.getWidget(558).getChild(13).getText().contains("Sorry")) {
                            Widgets.getWidget(558).getChild(7).getText();
                            Widgets.getWidget(558).getChild(7).interact("Enter name");
                            Keyboard.type(Key.BACKSPACE);
                            Keyboard.type(generateRandomChars());
                            sleep(2000);
                            Keyboard.type(Key.ENTER);
                            sleep(2000);
                            new TutorialIslandChar().execute();
                        }
                    }
                }
            }}


        return 0;
}
private String generateRandomChars() {
    String include = "StacyKillerRobocopGrowerShower";
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    StringBuilder sb = new StringBuilder();
    Random random = new Random();
    for (int i = 0; i < Calculations.random(6, 12); i++) {
        sb.append(random.nextInt(2) == 1 ? alphabet.toLowerCase().charAt(random.nextInt(alphabet.length())) : include.charAt(random.nextInt(include.length())));
    }
    return sb.toString();
}
}
