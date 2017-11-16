package pl.zwa.springsec.controllers;

import pl.zwa.springsec.models.Player;

public class PlayerController {

    //wywołanie Buildera - prostota!
    Player player = new Player.Builder("Osk")
            .setAttack(5)
            .setDefence(10)
            .setLvl(25)
            .build();

}
