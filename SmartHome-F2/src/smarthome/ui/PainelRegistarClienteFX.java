/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

/**
 *
 * @author
 */
public class PainelRegistarClienteFX extends StackPane {

    private String nome;
    private String genero;
    private String localidade;

    public PainelRegistarClienteFX(BorderPane root, ConsolaCentral consola) {
        setAlignment(Pos.TOP_CENTER);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        formulario(root, grid, consola);
        root.setCenter(grid);
    }

    private void formulario(BorderPane root, GridPane grid, ConsolaCentral consola) {

        Text titulo = new Text("Painel Registar Cliente");
        titulo.setId("titulo-text");
        titulo.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(titulo, 0, 0, 4, 1);

        Label labelNome = new Label("Nome");
        labelNome.setFont(Font.font("Cambria", FontWeight.NORMAL, 14));
        labelNome.setId("label");

        TextField nomeTextField = new TextField();
        nomeTextField.getStyleClass().add("textfield");
        nomeTextField.setPrefSize(400, 30);

        HBox hboxNome = new HBox(69);
        hboxNome.getChildren().addAll(labelNome, nomeTextField);

        Label labelLocalidade = new Label("Localidade");
        labelLocalidade.setFont(Font.font("Cambria", FontWeight.NORMAL, 14));
        labelLocalidade.setId("label");

        ObservableList<String> tipoLocalidade = FXCollections.observableArrayList(consola.obterLocalidade());
        ComboBox<String> comboBoxLidade = new ComboBox<>();
        comboBoxLidade.setPrefSize(400, 30);
        comboBoxLidade.setItems(tipoLocalidade);
        comboBoxLidade.getStyleClass().add("textfield");

        HBox hboxLocalidade = new HBox(32);
        hboxLocalidade.getChildren().addAll(labelLocalidade, comboBoxLidade);

        Label generoLabel = new Label("Género");
        generoLabel.setFont(Font.font("Cambria", FontWeight.NORMAL, 14));
        generoLabel.setId("label");

        ObservableList<String> tipoGenero = FXCollections.observableArrayList(consola.obterGenero());
        ComboBox<String> comboBoxGenero = new ComboBox<>();
        comboBoxGenero.setPrefSize(400, 30);
        comboBoxGenero.setItems(tipoGenero);
        comboBoxGenero.getStyleClass().add("textfield");

        HBox hboxGenero = new HBox(60);
        hboxGenero.getChildren().addAll(generoLabel, comboBoxGenero);

        VBox vboxFormulario = new VBox(20);
        vboxFormulario.getChildren().addAll(
                hboxNome,
                hboxLocalidade,
                hboxGenero);

        Pane painel1 = new BorderComTitulo("Formulário", vboxFormulario);
        painel1.getStyleClass().add("titled-address");
        grid.add(painel1, 0, 8);

        Button btnLimpar = new Button("Limpar");
        btnLimpar.setPrefSize(200, 30);

        Button btnCriar = new Button("Registar Cliente");
        btnCriar.setPrefSize(210, 30);

        Button btnRetroceder = new Button("Retroceder");
        btnRetroceder.setPrefSize(200, 30);

        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(btnCriar, btnLimpar, btnRetroceder);

        Pane painel2 = new BorderComTitulo("Operações", hbBtn);
        painel2.getStyleClass().add("titled-address");
        grid.add(painel2, 0, 10);

        /**
         * Evento do botão para limpar os dados preenchidos
         */
        btnLimpar.setOnAction((ActionEvent e) -> {
            //limpa os dados preenchidos nas text field
            nomeTextField.clear();
            comboBoxLidade.getSelectionModel().clearSelection();
            comboBoxGenero.getSelectionModel().clearSelection();
        });

        /**
         * Evento do botao para criar utilizador
         */
        btnCriar.setOnAction((ActionEvent e) -> {
            //apenas se estiver preenchida
            if (nomeTextField.getText().length() > 0) {
                nome = nomeTextField.getText();
            }//e se não estiver preenchida 
            else {
                //cria o dialogo de erro
                Dialogo erro = new Dialogo(Alert.AlertType.ERROR);
                erro.mostrarDialogo("ERRO", "Nome tem de estar preenchido");
                nome = null;
            }

            //apenas se for selecionado
            if (comboBoxLidade.getSelectionModel().isEmpty() != true) {
                //obter o item selecionado da comboBox
                localidade = comboBoxLidade.getSelectionModel().getSelectedItem();

            }//e se não for selecionada
            else {
                //cria o dialogo de erro
                Dialogo erro = new Dialogo(Alert.AlertType.ERROR);
                //mostra o dialogo
                erro.mostrarDialogo("ERRO", "Falta selecionar tipo de localidade");
                //genero fica a nulo
                localidade = null;
            }

            //apenas se for selecionado
            if (comboBoxGenero.getSelectionModel().isEmpty() != true) {
                //obter o item selecionado da comboBox
                genero = comboBoxGenero.getSelectionModel().getSelectedItem();

            }//e se não for selecionada
            else {
                //cria o dialogo de erro
                Dialogo erro = new Dialogo(Alert.AlertType.ERROR);
                //mostra o dialogo
                erro.mostrarDialogo("ERRO", "Falta selecionar tipo de genero");
                //genero fica a nulo
                genero = null;
            }

            //validação de dados
            if ((nome != null)
                    && (genero != null)
                    && (localidade != null)) {

                Cliente cliente = new Cliente(nome, localidade, genero);

                if (consola.adicionarNovoCliente(cliente) == true) {
                    Dialogo inf = new Dialogo(Alert.AlertType.INFORMATION);
                    //mostra o dialogo
                    inf.mostrarDialogo("INFORMAÇÃO", "Cliente foi registado com sucesso");
                } else {
                    //cria o dialogo de erro
                    Dialogo erro = new Dialogo(Alert.AlertType.ERROR);
                    //mostra o dialogo
                    erro.mostrarDialogo("ERRO", "Cliente não foi registado");
                }
                //volta a consola central
                consolaCentralFX(root, consola);
            }
        });

        /**
         * Evento do botão para Retroceder ao painel login
         */
        btnRetroceder.setOnAction((ActionEvent e) -> {
            consolaCentralFX(root, consola);
        });
    }

    private StackPane consolaCentralFX(BorderPane root, ConsolaCentral consola) {
        return new ConsolaCentralFX(root, consola);
    }

}
