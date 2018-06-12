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
import smarthome.cliente.Divisao;

/**
 *
 * @author
 */
public class PainelCriarDivisaoFX extends StackPane {

    private String nome;

    public PainelCriarDivisaoFX(BorderPane root, ConsolaCentral consola, Cliente cliente) {
        setAlignment(Pos.TOP_CENTER);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        formulario(root, grid, consola, cliente);
        root.setCenter(grid);
    }

    private void formulario(BorderPane root, GridPane grid, ConsolaCentral consola, Cliente cliente) {
        Text titulo = new Text("Painel Criar Divisão");
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

        Pane painel1 = new BorderComTitulo("Formulário", hboxNome);
        painel1.getStyleClass().add("titled-address");
        grid.add(painel1, 0, 8);

        Button btnLimpar = new Button("Limpar");
        btnLimpar.setPrefSize(200, 30);

        Button btnCriar = new Button("Inserir Divisão");
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

            //validação de dados
            if ((nome != null)) {
                //cria a divisao
                Divisao divisao = new Divisao(nome);
                //obter o cliente pelo id
                Cliente cliente_aux = consola.getClientePorID(cliente.getNumeroCliente());
                //se existir
                if (cliente_aux != null) {
                    //adiciona na habitação
                    cliente_aux.getHabitacao().adicionarDivisao(divisao);
                    //cria o dialogo
                    Dialogo inf = new Dialogo(Alert.AlertType.INFORMATION);
                    //mostra o dialogo
                    inf.mostrarDialogo("INFORMAÇÃO", "Divisão foi criada e adicionada na habitação do cliente " + cliente.getNome() + " com sucesso");
                    //volta ao painel cliente
                    painelClienteFX(root, consola, cliente);
                } //e se não existir 
                else {
                    //cria o dialogo de erro
                    Dialogo erro = new Dialogo(Alert.AlertType.ERROR);
                    erro.mostrarDialogo("ERRO", "Cliente não existe!");
                    nome = null;
                }

            }
        });

        /**
         * Evento do botão para Retroceder ao painel cliente
         */
        btnRetroceder.setOnAction((ActionEvent e) -> {
            //volta ao painel cliente
            painelClienteFX(root, consola, cliente);
        });
    }

    private StackPane painelClienteFX(BorderPane root, ConsolaCentral consola, Cliente cliente) {
        return new PainelClienteFX(root, consola, cliente);
    }

}
