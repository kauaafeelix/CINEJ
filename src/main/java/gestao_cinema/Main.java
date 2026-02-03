package gestao_cinema;

import gestao_cinema.infrastructure.controller.ControllerGeral;

public class Main {
    public static void main(String[] args) {

        var controller = new ControllerGeral();
        controller.aplicacaoGeral();
    }
}