/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.ui;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
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
import smarthome.central.FactoryEquipamento;
import smarthome.cliente.Cliente;
import smarthome.cliente.Divisao;
import smarthome.equipamentos.Equipamento;

/**
 *
 * @author
 */
public class PainelCriarEquipamentoFX extends StackPane {

    private Equipamento atuador;
    private Equipamento sensor;

    public PainelCriarEquipamentoFX(BorderPane root, ConsolaCentral consola, Cliente cliente, int divisaoId) {
        setAlignment(Pos.TOP_CENTER);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        formulario(root, grid, consola, cliente, divisaoId);
        root.setCenter(grid);
    }

    private void formulario(BorderPane root, GridPane grid, ConsolaCentral consola, Cliente cliente, int divisaoId) {

        Text titulo = new Text("Painel Criar Equipamento");
        titulo.setId("titulo-text");
        titulo.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(titulo, 0, 0, 4, 1);

        ToggleGroup groupAtuadores = new ToggleGroup();

        RadioButton rb1 = new RadioButton("Ar Condicionado");
        rb1.setToggleGroup(groupAtuadores);
        rb1.setUserData("Ar Condicionado");

        RadioButton rb2 = new RadioButton("Camara Fotografica");
        rb2.setToggleGroup(groupAtuadores);
        rb2.setUserData("Camara Fotografica");

        RadioButton rb3 = new RadioButton("Camara de Video");
        rb3.setToggleGroup(groupAtuadores);
        rb3.setUserData("Camara de Video");

        RadioButton rb4 = new RadioButton("Lampada");
        rb4.setToggleGroup(groupAtuadores);
        rb4.setUserData("Lampada");

        RadioButton rb5 = new RadioButton("Sirene");
        rb5.setToggleGroup(groupAtuadores);
        rb5.setUserData("Sirene");

        RadioButton rb6 = new RadioButton("Tomada");
        rb6.setToggleGroup(groupAtuadores);
        rb6.setUserData("Tomada");

        //obter apenas 1 nome do equipamento atuador
        groupAtuadores.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov,
                Toggle old_toggle, Toggle new_toggle) -> {
            if (groupAtuadores.getSelectedToggle() != null) {
                //obter o tipo de atuador
                String tipo = groupAtuadores.getSelectedToggle().getUserData().toString();
                atuador = FactoryEquipamento.criarEquipamentoAtuador(tipo);
                System.out.println(atuador.getNome());
            }
        });

        VBox vboxAtuadores = new VBox(10);
        vboxAtuadores.setAlignment(Pos.CENTER_LEFT);
        vboxAtuadores.getChildren().addAll(rb1, rb2, rb3, rb4, rb5, rb6);

        Pane painelAtuadores = new BorderComTitulo("Atuadores", vboxAtuadores);
        painelAtuadores.getStyleClass().add("titled-address");
        painelAtuadores.setPrefSize(300, 30);

        ToggleGroup groupSensores = new ToggleGroup();

        RadioButton rb7 = new RadioButton("Sensor Luminosidade");
        rb7.setToggleGroup(groupSensores);
        rb7.setUserData("Sensor Luminosidade");

        RadioButton rb8 = new RadioButton("Sensor Movimento");
        rb8.setToggleGroup(groupSensores);
        rb8.setUserData("Sensor Movimento");

        RadioButton rb9 = new RadioButton("Sensor Porta Aberta");
        rb9.setToggleGroup(groupSensores);
        rb9.setUserData("Sensor Porta Aberta");

        RadioButton rb10 = new RadioButton("Sensor Temperatura");
        rb10.setToggleGroup(groupSensores);
        rb10.setUserData("Sensor Temperatura");

        //obter apenas 1 nome do equipamento atuador
        groupSensores.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov,
                Toggle old_toggle, Toggle new_toggle) -> {
            if (groupSensores.getSelectedToggle() != null) {
                //obter o tipo de atuador
                String tipo = groupSensores.getSelectedToggle().getUserData().toString();
                sensor = FactoryEquipamento.criarEquipamentoSensor(tipo);
                System.out.println(sensor.getNome());
            }
        });

        VBox vboxSensores = new VBox(20);
        vboxSensores.setAlignment(Pos.CENTER_LEFT);
        vboxSensores.getChildren().addAll(rb7, rb8, rb9, rb10);

        Pane painelSensores = new BorderComTitulo("Sensores", vboxSensores);
        painelSensores.getStyleClass().add("titled-address");
        painelSensores.setPrefSize(300, 30);

        HBox hboxEquipamentos = new HBox(69);
        hboxEquipamentos.getChildren().addAll(painelAtuadores, painelSensores);

        Pane painelEquipamentos = new BorderComTitulo("Equipamentos", hboxEquipamentos);
        painelEquipamentos.getStyleClass().add("titled-address");
        grid.add(painelEquipamentos, 0, 3);

        rb1.setOnAction((ActionEvent e) -> {
            //desativa 
            rb2.setDisable(true);
            rb3.setDisable(true);
            rb4.setDisable(true);
            rb5.setDisable(true);
            rb6.setDisable(true);
            rb7.setDisable(true);
            rb8.setDisable(true);
            rb9.setDisable(true);
        });

        rb2.setOnAction((ActionEvent e) -> {
            //desativa 
            rb1.setDisable(true);
            rb3.setDisable(true);
            rb4.setDisable(true);
            rb5.setDisable(true);
            rb6.setDisable(true);
            rb7.setDisable(true);
            rb8.setDisable(true);
            rb9.setDisable(true);
            rb10.setDisable(true);
        });

        rb3.setOnAction((ActionEvent e) -> {
            //desativa 
            rb1.setDisable(true);
            rb2.setDisable(true);
            rb4.setDisable(true);
            rb5.setDisable(true);
            rb6.setDisable(true);
            rb7.setDisable(true);
            rb8.setDisable(true);
            rb9.setDisable(true);
            rb10.setDisable(true);
        });

        rb4.setOnAction((ActionEvent e) -> {
            //desativa 
            rb1.setDisable(true);
            rb2.setDisable(true);
            rb3.setDisable(true);
            rb5.setDisable(true);
            rb6.setDisable(true);
            rb8.setDisable(true);
            rb9.setDisable(true);
            rb10.setDisable(true);
        });

        rb5.setOnAction((ActionEvent e) -> {
            //desativa 
            rb1.setDisable(true);
            rb2.setDisable(true);
            rb3.setDisable(true);
            rb4.setDisable(true);
            rb6.setDisable(true);
            rb7.setDisable(true);
            rb8.setDisable(true);
            rb9.setDisable(true);
            rb10.setDisable(true);
        });

        rb6.setOnAction((ActionEvent e) -> {
            //desativa 
            rb1.setDisable(true);
            rb2.setDisable(true);
            rb3.setDisable(true);
            rb4.setDisable(true);
            rb5.setDisable(true);
            rb7.setDisable(true);
            rb8.setDisable(true);
            rb9.setDisable(true);
            rb10.setDisable(true);
        });

        Button btnLimpar = new Button("Limpar");
        btnLimpar.setPrefSize(200, 30);

        Button btnCriar = new Button("Inserir Equipamento");
        btnCriar.setPrefSize(210, 30);

        Button btnRetroceder = new Button("Retroceder");
        btnRetroceder.setPrefSize(200, 30);

        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(btnCriar, btnLimpar, btnRetroceder);

        Pane painel2 = new BorderComTitulo("Operações", hbBtn);
        painel2.getStyleClass().add("titled-address");
        grid.add(painel2, 0, 6);

        /**
         * Evento do botão para limpar os dados preenchidos
         */
        btnLimpar.setOnAction((ActionEvent e) -> {
            //limpa os dados preenchidos nas text field
            rb1.setDisable(false);
            rb1.setSelected(false);

            rb2.setDisable(false);
            rb2.setSelected(false);

            rb3.setDisable(false);
            rb3.setSelected(false);

            rb4.setDisable(false);
            rb4.setSelected(false);

            rb5.setDisable(false);
            rb5.setSelected(false);

            rb6.setDisable(false);
            rb6.setSelected(false);

            rb7.setDisable(false);
            rb7.setSelected(false);

            rb8.setDisable(false);
            rb8.setSelected(false);

            rb9.setDisable(false);
            rb9.setSelected(false);

            rb10.setDisable(false);
            rb10.setSelected(false);
        });

        /**
         * Evento do botao para criar utilizador
         */
        btnCriar.setOnAction((ActionEvent e) -> {
            if (atuador != null) {
                if (sensor != null) {
                    cliente.getHabitacao().getDivisaoPorID(divisaoId).adicionarEquipamento(atuador);
                    cliente.getHabitacao().getDivisaoPorID(divisaoId).adicionarEquipamento(sensor);
                    //cria o dialogo
                    Dialogo inf = new Dialogo(Alert.AlertType.INFORMATION);
                    //mostra o dialogo
                    inf.mostrarDialogo("INFORMAÇÃO", "Equipamentos foi adicionada na divisão do cliente " + cliente.getNome() + " com sucesso");
                    //volta ao painel divisao
                    painelDivisaoFX(root, consola, cliente, divisaoId);
                } else {
                    //cria o dialogo de erro
                    Dialogo erro = new Dialogo(Alert.AlertType.ERROR);
                    erro.mostrarDialogo("ERRO", "Falta selecionar o tipo de sensor");
                }
            } else {
                //cria o dialogo de erro
                Dialogo erro = new Dialogo(Alert.AlertType.ERROR);
                erro.mostrarDialogo("ERRO", "Falta selecionar o equipamento atuador");
            }
        });

        /**
         * Evento do botão para Retroceder ao painel cliente
         */
        btnRetroceder.setOnAction((ActionEvent e) -> {
            //volta ao painel divisao
            painelDivisaoFX(root, consola, cliente, divisaoId);
        });
    }

    private StackPane painelDivisaoFX(BorderPane root, ConsolaCentral consola, Cliente cliente, int divisaoId) {
        return new PainelDivisaoFX(root, consola, cliente, divisaoId);
    }

}
