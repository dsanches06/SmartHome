/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.ui;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
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
import smarthome.atuadores.ArCondicionado;
import smarthome.atuadores.Lampada;
import smarthome.central.ConsolaCentral;
import smarthome.cliente.Cliente;
import smarthome.cliente.Divisao;
import smarthome.equipamentos.Equipamento;

/**
 *
 * @author
 */
public class PainelDivisaoFX extends StackPane {

    private boolean botaoCor;

    public PainelDivisaoFX(BorderPane root, ConsolaCentral consola, Cliente cliente, int divisaoId) {
        setAlignment(Pos.TOP_RIGHT);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        //mostra a dashboard
        mostrarEquipamento(root, grid, consola, cliente, divisaoId);
        //posiciona a grid no centro da borderpane
        root.setCenter(grid);
    }

    private void mostrarEquipamento(BorderPane root, GridPane grid, ConsolaCentral consola, Cliente cliente, int divisaoId) {

        GridPane gridTitulo = new GridPane();
        gridTitulo.setAlignment(Pos.TOP_CENTER);

        Divisao divisao = cliente.getHabitacao().getDivisaoPorID(divisaoId);

        Text titulo = new Text("Total Equipamentos: " + divisao.getEquipamentos().size());
        titulo.setId("titulo-text");
        titulo.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
        gridTitulo.add(titulo, 0, 0, 1, 1);

        GridPane grid1 = new GridPane();
        grid1.setAlignment(Pos.TOP_LEFT);
        grid1.setHgap(10);
        grid1.setVgap(10);

        //obter a imagem do perfil
        Separator sper = new Separator();
        sper.setOrientation(Orientation.HORIZONTAL);
        sper.setStyle("-fx-background-color: #e79423;-fx-background-radius: 2;");

        Text textDivisao = new Text(divisao.mostrarInfDashBoard());

        Button btnAdicionar = new Button("Novo Equipamento");
        btnAdicionar.setPrefSize(220, 30);
        btnAdicionar.setOnAction((ActionEvent e) -> {
            //mostra o painel criar e adicionar equipamento
            painelCriarEquipamentoFX(root, consola, cliente, divisao.getDivisaoID());

        });

        Button btnRemover = new Button("Remover Equipamento");
        btnRemover.setPrefSize(220, 30);

        Button btnVoltar = new Button("Voltar ao painel cliente");
        btnVoltar.setPrefSize(220, 30);
        btnVoltar.setOnAction((ActionEvent e) -> {
            //volta ao painel cliente
            painelClienteFX(root, consola, cliente);
        });

        VBox vboxBtnDivisao = new VBox(20);
        vboxBtnDivisao.getChildren().addAll(btnAdicionar, btnRemover, btnVoltar);

        VBox vboxDivisao = new VBox(50);
        vboxDivisao.setAlignment(Pos.CENTER);
        vboxDivisao.getChildren().addAll(textDivisao, sper, vboxBtnDivisao);

        //criar um painel
        Pane painelDivisao = new BorderComTitulo("Dados da divisão", vboxDivisao);
        painelDivisao.getStyleClass().add("titled-address");
        painelDivisao.setPrefSize(200, 470);

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setAlignment(Pos.TOP_CENTER);

        int coluna = 3;
        int contador = 0;
        int total = divisao.getEquipamentos().size();
        Button[][] btn = new Button[total][total];

        //atributo para vrificar se um botao for criado com cor ou nao
        botaoCor = false;

        //loops para adicionar os buttons ao layout nas linhas do array
        for (int i = 0; i < 1; i++) {//linha
            //loops para adicionar os buttons ao layout nas colunas do array
            for (int j = 0; j < total; j++) {
                //obter a divisao pelo index
                Equipamento equipamento = divisao.getEquipamentoPorIndex(j);

                //array de imagens[3] para AC e lampada(desligada/ligada)
                Image[] imagem = new Image[3];
                imagem[0] = new Image(getClass().getResourceAsStream("/smarthome/styles/lampadaOff.png"));//lampada desligada
                imagem[1] = new Image(getClass().getResourceAsStream("/smarthome/styles/lampadaOn.png"));//lampada ligada
                imagem[2] = new Image(getClass().getResourceAsStream("/smarthome/styles/arCondicionado.png"));//AC

                if (equipamento instanceof Lampada) {
                    if (((Lampada) equipamento).isLigado() != true) {//estado desligado
                        //cria a nova imagem da lampada desligada
                        ImageView imgView = new ImageView(imagem[0]);
                        imgView.setFitHeight(80);
                        imgView.setFitWidth(40);
                        //adiciona a imagem ao botao
                        btn[i][j] = new Button(((Lampada) equipamento).toString(), imgView);
                    } else {
                        //cria a nova imagem da lampada ligada
                        ImageView imgView = new ImageView(imagem[1]);
                        imgView.setFitHeight(80);
                        imgView.setFitWidth(40);
                        //adiciona a imagem ao botao
                        btn[i][j] = new Button(((Lampada) equipamento).toString(), imgView);
                    }
                } else if (equipamento instanceof ArCondicionado) {
                    //cria a nova imagem da lampada desligada
                    ImageView imgView = new ImageView(imagem[2]);
                    // imgView.setFitHeight(50);
                    // imgView.setFitWidth(50);
                    //adiciona a imagem ao botao
                    btn[i][j] = new Button(((ArCondicionado) equipamento).toString(), imgView);
                }

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
                btn[i][j].setUserData(equipamento);
                //cria o evento para click de mouse
                btn[i][j].setOnMouseClicked((MouseEvent e) -> {
                    //obter o objecto divisao atraves do node getUserData
                    Object object = ((Node) e.getSource()).getUserData();
                    //verificar se é uma instancia de divisão
                    if (object instanceof Lampada) {
                        //nostra os resultados
                        System.out.println(((Lampada) object).toString());
                        //mostra o painel com equipamentos ou para inserir
                    } else if (object instanceof ArCondicionado) {
                        //nostra os resultados
                        System.out.println(((ArCondicionado) object).toString());
                    }
                });
                //muda de cor
                botaoCor = !botaoCor;
            }
            //muda de cor
            botaoCor = !botaoCor;
        }

        //criar um painel
        Pane painelEquipamento = new BorderComTitulo("Painel de Equipamentos da Divisão", gridpane);
        painelEquipamento.getStyleClass().add("titled-address");
        painelEquipamento.setPrefSize(700, 470);

        HBox hbox = new HBox(5);
        hbox.getChildren().addAll(painelDivisao, painelEquipamento);

        VBox vbox = new VBox(5);
        vbox.getChildren().addAll(gridTitulo, hbox);

        grid.getChildren().addAll(vbox);
    }

    private StackPane painelClienteFX(BorderPane root, ConsolaCentral consola, Cliente cliente) {
        return new PainelClienteFX(root, consola, cliente);
    }

    private StackPane painelCriarEquipamentoFX(BorderPane root, ConsolaCentral consola, Cliente cliente, int divisaoId) {
        return new PainelCriarEquipamentoFX(root, consola, cliente, divisaoId);
    }
}
