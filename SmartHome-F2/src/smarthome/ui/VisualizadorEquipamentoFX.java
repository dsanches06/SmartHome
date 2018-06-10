/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.ui;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import smarthome.central.ConsolaCentral;
import smarthome.cliente.Cliente;

/**
 *
 * @author
 */
public class VisualizadorEquipamentoFX extends StackPane {

    public VisualizadorEquipamentoFX(BorderPane root, ConsolaCentral consola, Cliente cliente) {
        setAlignment(Pos.TOP_RIGHT);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        //mostra a dashboard
        mostrarEquipamento(root, grid, consola, cliente);
        //posiciona a gridpane no centro da borderpane
        root.setCenter(grid);
    }

    private void mostrarEquipamento(BorderPane root, GridPane grid, ConsolaCentral consola, Cliente cliente) {

        GridPane gridTitulo = new GridPane();
        gridTitulo.setAlignment(Pos.TOP_CENTER);

        Text titulo = new Text("Visualizar Equipamentos");
        titulo.setId("titulo-text");
        titulo.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        gridTitulo.add(titulo, 0, 0, 1, 1);

        GridPane grid1 = new GridPane();
        grid1.setAlignment(Pos.TOP_LEFT);

        //obter a imagem do perfil
        ImageView fotoPerfil = null;

        switch (cliente.getGenero()) {
            case 'F':
                //obter a imagem do perfil feminino
                fotoPerfil = new ImageView(new Image("smarthome/styles/mulher.png"));
                fotoPerfil.setFitHeight(60);
                fotoPerfil.setFitWidth(60);
                break;
            case 'M':
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

        Button btnVoltar = new Button("Voltar");
        btnVoltar.setPrefSize(220, 30);

        HBox hboxPerfil = new HBox(5);
        hboxPerfil.getChildren().addAll(fotoPerfil, perfilText);

        VBox vboxCliente = new VBox(100);
        vboxCliente.setAlignment(Pos.CENTER);
        vboxCliente.getChildren().addAll(hboxPerfil, sper, btnVoltar);

        //criar um painel
        Pane painelCliente = new BorderComTitulo("Dados do Cliente", vboxCliente);
        painelCliente.getStyleClass().add("titled-address");
        painelCliente.setPrefSize(60, 470);

        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.TOP_CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);

        int coluna = 3;
        int contador = 0;
        for (int i = 1; i <= 1; i++) {//linha
            for (int j = 0; j < cliente.getHabitacao().getDivisoes().size(); j++) {
                GridPane box = new GridPane();
                box.setPrefSize(200, 200);
                box.setAlignment(Pos.CENTER);
                box.setStyle("-fx-background-color: black, -fx-control-inner-background; -fx-background-insets: 0, 2; -fx-padding: 2;");

                VBox vbox = new VBox(10);
                Label label = new Label(cliente.getHabitacao().getDivisoes().get(j).getNome());
                Button btn = new Button("Button");
                btn.setPrefSize(100, 30);

                vbox.getChildren().addAll(label, btn);
                box.getChildren().add(vbox);
                contador++;

                if (contador <= coluna) {
                    GridPane.setConstraints(box, j, i + 4);
                } else {
                    GridPane.setConstraints(box, j - 3, i + 5);
                }
                grid2.getChildren().add(box);
            }
        }

        HBox hbox = new HBox(5);
        hbox.getChildren().addAll(painelCliente, grid2);
        grid.getChildren().addAll(gridTitulo, hbox);

    }
}
