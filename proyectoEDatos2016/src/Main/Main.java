/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import controller.controllerMenu;
import view.ViewMenu;

/**
 *
 * @author Marco
 */
public class Main {
    public static void main(String[] args) {
        ViewMenu viewMenu = new ViewMenu();
        viewMenu.setTitle("Ordenamiento");
        viewMenu.setVisible(true);
        controllerMenu control = new controllerMenu(viewMenu);
    }
}
