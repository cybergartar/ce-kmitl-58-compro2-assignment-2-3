package GetRich.controller;

import GetRich.models.Land;
import GetRich.models.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TakeOverController {
    @FXML Label landNameLabel, priceLabel;
    @FXML Button btnBuy, btnCancel;
    Long price;
    Player player;
    Land land;
    Stage dialog;

    public void initializer(Stage dialog, Player player, Land land, String landName) {
        this.land = land;
        this.player = player;
        this.dialog = dialog;
        price = land.getBuyPrice();
        String priceString = "";
        if (price > 1000000)
            priceString += (price / 100000) + "M ";
        if(price % 100000 != 0)
            priceString += ((price % 1000000) / 1000 ) + "K";

        GamePlayController.setLabel(landNameLabel, landName);
        GamePlayController.setLabel(priceLabel, priceString);
    }

    public void buttonHandler (ActionEvent event) {
        if (event.getSource() == btnBuy) {
            System.out.println("LEVEL TAKE: " + land.getLevel());
            land.takeOver(player);
        }
        dialog.close();
    }
}
