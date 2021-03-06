/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.ui;

import java.io.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;
import java.util.*;
import java.util.logging.*;
import javafx.application.*;
import javafx.scene.control.Alert.*;
import smarthome.*;
import smarthome.central.*;
import smarthome.cliente.*;

/**
 *
 * @author
 */
public class PainelConsolaCentralFX extends StackPane {

    public PainelConsolaCentralFX(BorderPane root, ConsolaCentral consola) {

        setAlignment(Pos.CENTER);

        VBox vbox3 = new VBox(10);
        vbox3.setAlignment(Pos.TOP_CENTER);
        //mostra a dashboard
        mostrarConsolaCentralFX(root, vbox3, consola);
        //posiciona a gridpane no centro da borderpane
        root.setCenter(vbox3);
    }

    private void mostrarConsolaCentralFX(BorderPane root, VBox vbox3, ConsolaCentral consola) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        Text titulo = new Text("Consola Central");
        titulo.setId("titulo-text");
        grid.add(titulo, 0, 0);

        //separator
        Separator separador1 = new Separator();
        separador1.setOrientation(Orientation.VERTICAL);
        separador1.setHalignment(HPos.CENTER);
        separador1.setStyle("-fx-background-color: #e79423;-fx-background-radius: 2;");

        Separator separador2 = new Separator();
        separador2.setOrientation(Orientation.VERTICAL);
        separador2.setHalignment(HPos.CENTER);
        separador2.setStyle("-fx-background-color: #e79423;-fx-background-radius: 2;");

        Separator separador3 = new Separator();
        separador3.setOrientation(Orientation.HORIZONTAL);
        separador3.setHalignment(HPos.CENTER);
        separador3.setStyle("-fx-background-color: #e79423;-fx-background-radius: 2;");

        Button btnNovo = new Button("Registar Cliente");
        btnNovo.setPrefSize(220, 30);

        Button btnVerCliente = new Button("Ver Cliente");
        btnVerCliente.setPrefSize(220, 30);

        Button btnRemover = new Button("Remover Cliente");
        btnRemover.setPrefSize(220, 30);

        VBox vboxBtn1 = new VBox(30);
        vboxBtn1.getChildren().addAll(
                btnNovo,
                btnVerCliente,
                btnRemover);

        Button btnImportar = new Button("Importar Ficheiro");
        btnImportar.setPrefSize(220, 30);

        Button btnSalvar = new Button("Salvar Ficheiro");
        btnSalvar.setPrefSize(220, 30);

        Button btnSair = new Button("Sair da Consola");
        btnSair.setPrefSize(220, 30);

        VBox vboxBtn2 = new VBox(30);
        vboxBtn2.getChildren().addAll(
                btnImportar,
                btnSalvar,
                btnSair);

        HBox hboxBtn = new HBox(90);
        hboxBtn.getChildren().addAll(vboxBtn1, vboxBtn2);

        Pane painelBtn = new BorderComTitulo("Operações", hboxBtn);
        painelBtn.getStyleClass().add("titled-address");
        painelBtn.setPrefSize(750, 240);

        GridPane grid1 = new GridPane();
        grid1.setAlignment(Pos.TOP_CENTER);
        grid1.setHgap(10);
        grid1.setVgap(10);

        //criar um painel
        Pane painelCliente = new BorderComTitulo("Perfil do Cliente", grid1);
        painelCliente.getStyleClass().add("titled-address");
        painelCliente.setPrefSize(400, 30);

        HBox hbox1 = new HBox(15);
        hbox1.getChildren().addAll(
                painelBtn,
                painelCliente);

        TableView<Cliente> tabela = new TableView();
        tabela.setPrefHeight(800);
        tabela.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tabela.setEditable(true);

        tabela.setOnMouseClicked(e -> {
            Cliente cliente = (Cliente) tabela.getSelectionModel().getSelectedItem();
            if (cliente != null) {
                VBox painel = obterCliente(cliente);
                grid1.getChildren().clear();
                grid1.add(painel, 0, 1);
            }
        });

        TableColumn<Cliente, Integer> colunaNumero = new TableColumn("Número");
        TableColumn<Cliente, String> colunaNome = new TableColumn("Nome");
        TableColumn<Cliente, String> colunaGenero = new TableColumn("Genero");
        TableColumn<Cliente, String> colunaLocalidade = new TableColumn("localidade");
        TableColumn<Cliente, Integer> colunaNumeroDivisao = new TableColumn("Total divisao");

        colunaNumero.setCellValueFactory(new PropertyValueFactory<>("numeroCliente"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        colunaLocalidade.setCellValueFactory(new PropertyValueFactory<>("localidade"));
        colunaNumeroDivisao.setCellValueFactory(new PropertyValueFactory<>("numeroDivisao"));

        tabela.setItems(FXCollections.observableArrayList(consola.getClientes()));
        tabela.refresh();

        tabela.getColumns().addAll(colunaNumero,
                colunaNome,
                colunaGenero,
                colunaLocalidade,
                colunaNumeroDivisao);

        btnNovo.setOnAction((ActionEvent e) -> {
            painelRegistarCliente(root, consola);
        });

        btnVerCliente.setOnAction((ActionEvent e) -> {
            //obter cliente da tabela
            Cliente cliente = (Cliente) tabela.getSelectionModel().getSelectedItem();
            if (cliente != null) {
                painelClienteFX(root, consola, cliente);
            } else {
                Dialogo erro = new Dialogo(Alert.AlertType.ERROR);
                // mostra o dialogo
                erro.mostrarDialogo("ERRO", "Cliente não selecionado");
            }
        });

        btnRemover.setOnAction(
                (ActionEvent e) -> {
                    //obter cliente da tabela
                    Cliente cliente = (Cliente) tabela.getSelectionModel().getSelectedItem();
                    if (cliente != null) {
                        consola.removerCliente(cliente);
                        tabela.getItems().remove(cliente);
                        grid1.getChildren().clear();
                        Dialogo inf = new Dialogo(Alert.AlertType.INFORMATION);
                        //mostra o dialogo
                        inf.mostrarDialogo("INFORMAÇÃO", "Cliente removido com sucesso");
                    } else {
                        Dialogo erro = new Dialogo(Alert.AlertType.ERROR);
                        // mostra o dialogo
                        erro.mostrarDialogo("ERRO", "Cliente não selecionado");
                    }
                });

        btnImportar.setOnAction((ActionEvent e) -> {
            //cria uma instancia filechooser
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Importar Dados no Ficheiro");
            //cria um filtro de extensão "*.log" e adiciona no file chooser
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("DAT files (*.dat)", "*.dat"));
            //mostrar dialog abrir/carregar
            File file = fileChooser.showOpenDialog(App.stage);
            //se houver ficheiro
            if (file != null) {
                try {
                    //gravar dados o ficheiro cliente.dat
                    consola.lerFicheiro(file.getName());
                    //cria o dialogo de inf
                    Dialogo inf = new Dialogo(Alert.AlertType.INFORMATION);
                    //mostra o dialogo
                    inf.mostrarDialogo("INFORMAÇÃO", "Dados lidos no Ficheiro com sucesso");
                    //volta ao painel consola com dados atualizados
                    consolaCentralFX(root, consola);
                } catch (IOException ex) {
                    Logger.getLogger(PainelConsolaCentralFX.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Dialogo erro = new Dialogo(Alert.AlertType.ERROR);
                //mostra o dialogo
                erro.mostrarDialogo("ERRO", "Operação ler Dados no Ficheiro foi cancelada");
            }
        }
        );

        btnSalvar.setOnAction((ActionEvent e) -> {
            //cria uma instancia filechooser
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Salvar Dados no Ficheiro");
            //cria um filtro de extensão "*.log" e adiciona no file chooser
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("DAT files (*.dat)", "*.dat"));
            //mostra dialog salvar 
            File file = fileChooser.showSaveDialog(App.stage);
            //se não cria um novo
            if (file != null) {
                try {
                    //gravar dados o ficheiro cliente.dat
                    consola.gravarFicheiro(file.getName());
                    //cria o dialogo de inf
                    Dialogo inf = new Dialogo(Alert.AlertType.INFORMATION);
                    //mostra o dialogo
                    inf.mostrarDialogo("INFORMAÇÃO", "Dados Guardados no Ficheiro com sucesso");
                } catch (IOException ex) {
                    Logger.getLogger(PainelConsolaCentralFX.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Dialogo erro = new Dialogo(Alert.AlertType.ERROR);
                //mostra o dialogo
                erro.mostrarDialogo("ERRO", "Operação Salvar Dados no Ficheiro foi cancelada");
            }
        });

        btnSair.setOnAction((ActionEvent e) -> {

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmar salvar dados");
            alert.setContentText("Deseja salvar dados no ficheiro?");

            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Salvar Dados no Ficheiro");
                //cria um filtro de extensão "*.log" e adiciona no file chooser
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("DAT files (*.dat)", "*.dat"));
                //mostrar dialog abrir/carregar
                File file = fileChooser.showOpenDialog(App.stage);
                //se houver ficheiro
                if (file != null) {
                    try {
                        //gravar dados o ficheiro cliente.dat
                        consola.gravarFicheiro(file.getName());
                        //cria o dialogo de inf
                        Dialogo inf = new Dialogo(Alert.AlertType.INFORMATION);
                        //mostra o dialogo
                        inf.mostrarDialogo("INFORMAÇÃO", "Dados lidos no Ficheiro com sucesso");
                    } catch (IOException ex) {
                        Logger.getLogger(PainelConsolaCentralFX.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    Dialogo erro = new Dialogo(Alert.AlertType.ERROR);
                    //mostra o dialogo
                    erro.mostrarDialogo("ERRO", "Operação ler Dados no Ficheiro foi cancelada");
                }
            } else {
                Dialogo erro = new Dialogo(Alert.AlertType.ERROR);
                //mostra o dialogo
                erro.mostrarDialogo("ERRO", "Operação Salvar Dados no Ficheiro foi cancelada");
            }
            Platform.exit();
        });

        VBox vboxPainel2 = new VBox();
        vboxPainel2.setAlignment(Pos.TOP_CENTER);
        vboxPainel2.getChildren().addAll(tabela);

        //criar um painel
        Pane painel2 = new BorderComTitulo("Lista de Clientes", vboxPainel2);
        painel2.getStyleClass().add("titled-address");
        painel2.setPrefSize(1500, 564);

        VBox vbox2 = new VBox(10);
        vbox2.setAlignment(Pos.TOP_CENTER);
        vbox2.getChildren().addAll(hbox1, separador3, painel2);
        vbox3.getChildren().addAll(grid, vbox2);
    }

    private StackPane painelRegistarCliente(BorderPane root, ConsolaCentral consola) {
        return new PainelRegistarClienteFX(root, consola);
    }

    private VBox obterCliente(Cliente cliente) {

        //obter a imagem do perfil
        ImageView fotoCliente = null;

        switch (cliente.getGenero()) {
            case "F":
                //obter a imagem do perfil feminino
                fotoCliente = new ImageView(new Image("smarthome/styles/mulher.png"));
                fotoCliente.setFitHeight(60);
                fotoCliente.setFitWidth(60);
                break;
            case "M":
                //obter a imagem do perfil masculino
                fotoCliente = new ImageView(new Image("smarthome/styles/homem.png"));
                fotoCliente.setFitHeight(60);
                fotoCliente.setFitWidth(60);
                break;
        }

        Text clienteText = new Text(cliente.mostrarInfDashBoard());

        HBox hboxCliente = new HBox(5);
        hboxCliente.getChildren().addAll(fotoCliente, clienteText);

        VBox vboxCliente = new VBox(5);
        vboxCliente.setAlignment(Pos.TOP_CENTER);
        vboxCliente.getChildren().addAll(hboxCliente);

        return vboxCliente;

    }

    private StackPane painelClienteFX(BorderPane root, ConsolaCentral consola, Cliente cliente) {
        return new PainelClienteFX(root, consola, cliente);
    }

    private StackPane consolaCentralFX(BorderPane root, ConsolaCentral consola) {
        return new PainelConsolaCentralFX(root, consola);
    }

}
