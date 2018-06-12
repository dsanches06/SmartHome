/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.ui;

import java.util.Random;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import smarthome.Dialogo;
import smarthome.central.ConsolaCentral;
import smarthome.cliente.Cliente;
import smarthome.cliente.Divisao;

/**
 *
 * @author
 */
public class PainelClienteFX extends StackPane {

    TextArea texto;
    Label rotulo;
    Button buttonRetroceder;
    Button buttonLimpar;
    boolean botaoCor;

    public PainelClienteFX(BorderPane root, ConsolaCentral consola, Cliente cliente) {
        setAlignment(Pos.TOP_RIGHT);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        //mostra a dashboard
        mostrarEquipamento(root, grid, consola, cliente);
        //posiciona a grid no centro da borderpane
        root.setCenter(grid);
    }

    private void mostrarEquipamento(BorderPane root, GridPane grid, ConsolaCentral consola, Cliente cliente) {

        GridPane gridTitulo = new GridPane();
        gridTitulo.setAlignment(Pos.TOP_CENTER);

        Text titulo = new Text("Total Divisões: " + cliente.getHabitacao().getDivisoes().size());
        titulo.setId("titulo-text");
        titulo.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
        gridTitulo.add(titulo, 0, 0, 1, 1);

        GridPane grid1 = new GridPane();
        grid1.setAlignment(Pos.TOP_LEFT);
        grid1.setHgap(10);
        grid1.setVgap(10);

        //obter a imagem do perfil
        ImageView fotoPerfil = null;

        switch (cliente.getGenero()) {
            case "F":
                //obter a imagem do perfil feminino
                fotoPerfil = new ImageView(new Image("smarthome/styles/mulher.png"));
                fotoPerfil.setFitHeight(60);
                fotoPerfil.setFitWidth(60);
                break;
            case "M":
                //obter a imagem do perfil masculino
                fotoPerfil = new ImageView(new Image("smarthome/styles/homem.png"));
                fotoPerfil.setFitHeight(60);
                fotoPerfil.setFitWidth(60);
                break;
        }

        Separator sper = new Separator();
        sper.setOrientation(Orientation.HORIZONTAL);
        sper.setStyle("-fx-background-color: #e79423;-fx-background-radius: 2;");

        Text perfilText = new Text(cliente.mostrarInfDashBoard());

        HBox hboxPerfil = new HBox(5);
        hboxPerfil.getChildren().addAll(fotoPerfil, perfilText);

        Button btnAdicionar = new Button("Nova Divisão");
        btnAdicionar.setPrefSize(220, 30);
        btnAdicionar.setOnAction((ActionEvent e) -> {
            //verifica se já foi criada 6 divisoes
            if (cliente.getHabitacao().getDivisoes().size() < 6) {
                //mostra o painel criar divisao
                painelCriarDivisao(root, consola, cliente);
            } else {
                //cria o dialogo de erro
                Dialogo erro = new Dialogo(Alert.AlertType.ERROR);
                erro.mostrarDialogo("ERRO", "Só pode ser inserido 6 divisões");
            }
        });

        Button btnRemover = new Button("Remover Divisão");
        btnRemover.setPrefSize(220, 30);

        Button btnVoltar = new Button("Voltar a Consola");
        btnVoltar.setPrefSize(220, 30);
        btnVoltar.setOnAction((ActionEvent e) -> {
            //volta a consola central
            consolaCentralFX(root, consola);
        });

        VBox vboxBtnDivisao = new VBox(20);
        vboxBtnDivisao.getChildren().addAll(btnAdicionar, btnRemover, btnVoltar);

        VBox vboxCliente = new VBox(50);
        vboxCliente.setAlignment(Pos.CENTER);
        vboxCliente.getChildren().addAll(hboxPerfil, sper, vboxBtnDivisao);

        //criar um painel
        Pane painelCliente = new BorderComTitulo("Dados do Cliente", vboxCliente);
        painelCliente.getStyleClass().add("titled-address");
        painelCliente.setPrefSize(60, 470);

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setAlignment(Pos.TOP_CENTER);

        int coluna = 3;
        int contador = 0;
        int total = cliente.getHabitacao().getDivisoes().size();
        Button[][] btn = new Button[total][total];

        //atributo para vrificar se um botao for criado com cor ou nao
        botaoCor = false;
        System.out.println("Total: " + cliente.getHabitacao().getDivisoes().size());
        //loops para adicionar os buttons ao layout nas linhas do array
        for (int i = 0; i < 1; i++) {//linha
            //loops para adicionar os buttons ao layout nas colunas do array
            for (int j = 0; j < total; j++) {
                //obter a divisao pelo index
                Divisao divisao = cliente.getHabitacao().getDivisaoPorIndex(j);
                //se existir
                if (divisao != null) {
                    //cria um novo botão
                    btn[i][j] = new Button(divisao.mostrarInfDashBoard());
                    //verifica a cor
                    if (botaoCor == false) {
                        //preenche com a cor lightgrey
                        btn[i][j].getStyleClass().add("btn_color_red");
                    } else {//se  a cor preenchida for lightgrey
                        //preenche com a cor grey
                        btn[i][j].getStyleClass().add("btn_color_marron");
                    }  //representa o tamanho de altura e largura de cada botao
                    btn[i][j].setPrefSize(200, 200);

                    VBox vbox = new VBox(20);
                    vbox.setAlignment(Pos.CENTER);
                    vbox.getChildren().addAll(btn[i][j]);
                    contador++;

                    if (contador <= coluna) {
                        GridPane.setConstraints(vbox, j, i + 4);
                    } else {
                        GridPane.setConstraints(vbox, j - 3, i + 5);
                    }
                    //adiciona a gridpane
                    gridpane.getChildren().add(vbox);

                    //adiciona a divisão como dados referente ao botão
                    btn[i][j].setUserData(divisao);
                    //cria o evento para click de mouse
                    btn[i][j].setOnMouseClicked((MouseEvent e) -> {
                        //obter o objecto divisao atraves do node getUserData
                        Object object = ((Node) e.getSource()).getUserData();
                        //verificar se é uma instancia de divisão
                        if (object instanceof Divisao) {
                            //nostra os resultados
                            System.out.println(((Divisao) object).mostrarInfDashBoard());
                            //mostra o painel com equipamentos ou para inserir
                        }
                    });
                    //muda de cor
                    botaoCor = !botaoCor;
                }
            }
            //muda de cor
            botaoCor = !botaoCor;
        }

        //criar um painel
        Pane painelDivisao = new BorderComTitulo("Painel de Divisões do Cliente", gridpane);
        painelDivisao.getStyleClass().add("titled-address");
        painelDivisao.setPrefSize(700, 470);

        HBox hbox = new HBox(5);
        hbox.getChildren().addAll(painelCliente, painelDivisao);

        VBox vbox = new VBox(5);
        vbox.getChildren().addAll(gridTitulo, hbox);

        grid.getChildren().addAll(vbox);
    }

    private StackPane consolaCentralFX(BorderPane root, ConsolaCentral consola) {
        return new ConsolaCentralFX(root, consola);
    }

    private StackPane painelCriarDivisao(BorderPane root, ConsolaCentral consola, Cliente cliente) {
        return new PainelCriarDivisaoFX(root, consola, cliente);
    }
}
