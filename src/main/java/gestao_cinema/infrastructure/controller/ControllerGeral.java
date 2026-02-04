package gestao_cinema.infrastructure.controller;

import gestao_cinema.infrastructure.controller.filme.FilmeController;
import gestao_cinema.view.ViewGeral;

public class ControllerGeral {
    ViewGeral viewGeral = new ViewGeral();

    public void aplicacaoGeral(){
        do {
            switch (viewGeral.menuPrincipal()){

                case 1 ->{
                    FilmeController controllerFilme = new FilmeController();
                    controllerFilme.gerenciadorFilme();
                }
                case 0 ->{
                    viewGeral.encerrando();
                }
            }
        }while (viewGeral.menuPrincipal()!=0);
    }
}
