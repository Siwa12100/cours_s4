package tests;

import models.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TelecommandeTest {

    @Test
    @DisplayName("Test de l'instanciation")
    void testInstanciation() {

        Telecommande telecommande = new Telecommande();
        assertNotNull(telecommande);
    }

    @Test
    @DisplayName("test du setCommande")
    public void testSetCommande() {

        Telecommande telecommande = new Telecommande();
        CommandeEteindreTV cmd1 = new CommandeEteindreTV(new TV("Cuisine"));
        CommandeAllumerJacuzzi cmd2 = new CommandeAllumerJacuzzi(new Jacuzzi());
        telecommande.setCommande(0, cmd1, cmd2);

        assertEquals(cmd1, telecommande.getCommandesMarche()[0]);
        assertEquals(cmd2, telecommande.getCommandesArret()[0]);
    }

    @Test
    @DisplayName("Test de boutonMarchePresse")
    public void testBoutonMarchePresse() {

        Telecommande telecommande = new Telecommande();
        CommandeEteindreTV cmd1 = new CommandeEteindreTV(new TV("Cuisine"));
        CommandeAllumerJacuzzi cmd2 = new CommandeAllumerJacuzzi(new Jacuzzi());
        telecommande.setCommande(0, cmd1, cmd2);

        telecommande.boutonMarchePresse(0);

        assertEquals(cmd1, telecommande.getCommandeAnnulation());
    }


}
