package gestao_cinema.infrastructure.controller.filme;

import gestao_cinema.application.service.FilmeServiceImpl;
import gestao_cinema.application.service.contracts.FilmeService;
import gestao_cinema.view.ViewGeral;
import gestao_cinema.view.filme.FilmeView;

public class FilmeController {
    FilmeView filmeView = new FilmeView();
    FilmeServiceImpl filmeService = new FilmeServiceImpl();
    ViewGeral viewGeral = new ViewGeral();

    public void gerenciadorFilme(){
        do {
            switch (filmeView.menuFilme()){

                case 1 ->{
                    filmeService.cadastrarFilme();
                }
                case 2 ->{
                    filmeService.listarFilmes();
                }
                case 3->{
                    filmeService.buscarFilmePorGenero();
                }
                case 4 ->{
                    filmeService.deletarFilme();
                }
                case 0 ->{
                    viewGeral.menuPrincipal();
                    return;
                }
            }
        }while (filmeView.menuFilme()!=0);
    }
}
