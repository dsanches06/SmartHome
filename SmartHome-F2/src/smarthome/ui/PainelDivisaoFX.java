/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.ui;

import java.util.logging.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import smarthome.*;
import smarthome.atuadores.*;
import smarthome.central.*;
import smarthome.cliente.*;
import smarthome.equipamentos.*;
import smarthome.sensores.*;

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
            //verifica se já foi criada 6 divisoes
            if (divisao.getEquipamentos().size() < 6) {
                //mostra o painel criar e adicionar equipamento
                painelCriarEquipamentoFX(root, consola, cliente, divisao.getDivisaoID());
            } else {
                //cria o dialogo de erro
                Dialogo erro = new Dialogo(Alert.AlertType.ERROR);
                erro.mostrarDialogo("ERRO", "Só pode ser inserido 6 equipamentos em cada divisão");
            }
        });

        Button btnRemover = new Button("Remover Equipamento");
        btnRemover.setPrefSize(220, 30);

        Button btnVoltar = new Button("Voltar ao painel cliente");
        btnVoltar.setPrefSize(220, 30);
        btnVoltar.setOnAction((ActionEvent e) -> {
            //volta ao painel consola
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
                //array de imagens[13]
                if (equipamento instanceof Lampada) {
                    if (((Lampada) equipamento).isLigado() != true) {//estado desligado
                        //cria a nova imagem da lampada desligada
                        ImageView imgView = new ImageView(consola.obterImagem(0));
                        imgView.setFitHeight(80);
                        imgView.setFitWidth(40);
                        //adiciona a imagem ao botao
                        btn[i][j] = new Button(((Lampada) equipamento).toString(), imgView);
                    } else {
                        //cria a nova imagem da lampada ligada
                        ImageView imgView = new ImageView(consola.obterImagem(1));
                        imgView.setFitHeight(80);
                        imgView.setFitWidth(40);
                        //adiciona a imagem ao botao
                        btn[i][j] = new Button(((Lampada) equipamento).toString(), imgView);
                    }
                } else if (equipamento instanceof ArCondicionado) {
                    if (((ArCondicionado) equipamento).isLigado() != true) {//estado ligado
                        //cria a nova imagem da ac desligada
                        ImageView imgView = new ImageView(consola.obterImagem(2));
                        imgView.setFitHeight(80);
                        imgView.setFitWidth(80);
                        //adiciona a imagem ao botao
                        btn[i][j] = new Button(((ArCondicionado) equipamento).toString(), imgView);
                    } else {
                        //cria a nova imagem da lampada ligada
                        ImageView imgView = new ImageView(consola.obterImagem(3));
                        imgView.setFitHeight(80);
                        imgView.setFitWidth(80);
                        //adiciona a imagem ao botao
                        btn[i][j] = new Button(((ArCondicionado) equipamento).toString(), imgView);
                    }
                } else if (equipamento instanceof CamaraFotografica) {
                    //cria a nova imagem da lampada desligada
                    ImageView imgView = new ImageView(consola.obterImagem(4));
                    imgView.setFitHeight(80);
                    imgView.setFitWidth(40);
                    //adiciona a imagem ao botao
                    btn[i][j] = new Button(((CamaraFotografica) equipamento).toString(), imgView);
                } else if (equipamento instanceof CamaraVideo) {
                    //cria a nova imagem da lampada desligada
                    ImageView imgView = new ImageView(consola.obterImagem(5));
                    imgView.setFitHeight(80);
                    imgView.setFitWidth(40);
                    //adiciona a imagem ao botao
                    btn[i][j] = new Button(((CamaraVideo) equipamento).toString(), imgView);
                } else if (equipamento instanceof Sirene) {
                    //cria a nova imagem da lampada desligada
                    ImageView imgView = new ImageView(consola.obterImagem(6));
                    imgView.setFitHeight(80);
                    imgView.setFitWidth(40);
                    //adiciona a imagem ao botao
                    btn[i][j] = new Button(((Sirene) equipamento).toString(), imgView);
                } else if (equipamento instanceof Tomada) {
                    if (((Tomada) equipamento).isLigado() != true) {//estado desligado
                        //cria a nova imagem da lampada desligada
                        ImageView imgView = new ImageView(consola.obterImagem(7));
                        imgView.setFitHeight(80);
                        imgView.setFitWidth(40);
                        //adiciona a imagem ao botao
                        btn[i][j] = new Button(((Tomada) equipamento).toString(), imgView);
                    } else {
                        //cria a nova imagem da lampada ligada
                        ImageView imgView = new ImageView(consola.obterImagem(8));
                        imgView.setFitHeight(80);
                        imgView.setFitWidth(40);
                        //adiciona a imagem ao botao
                        btn[i][j] = new Button(((Tomada) equipamento).toString(), imgView);
                    }
                } else if (equipamento instanceof SensorLuminosidade) {
                    //cria a nova imagem da lampada desligada
                    ImageView imgView = new ImageView(consola.obterImagem(9));
                    imgView.setFitHeight(80);
                    imgView.setFitWidth(40);
                    //adiciona a imagem ao botao
                    btn[i][j] = new Button(((SensorLuminosidade) equipamento).toString(), imgView);
                } else if (equipamento instanceof SensorMovimento) {
                    if (((SensorMovimento) equipamento).isLigado() != true) {//estado desligado
                        //cria a nova imagem da lampada desligada
                        ImageView imgView = new ImageView(consola.obterImagem(10));
                        imgView.setFitHeight(80);
                        imgView.setFitWidth(40);
                        //adiciona a imagem ao botao
                        btn[i][j] = new Button(((SensorMovimento) equipamento).toString(), imgView);
                    } else {
                        //cria a nova imagem da lampada ligada
                        ImageView imgView = new ImageView(consola.obterImagem(11));
                        imgView.setFitHeight(80);
                        imgView.setFitWidth(40);
                        //adiciona a imagem ao botao
                        btn[i][j] = new Button(((SensorMovimento) equipamento).toString(), imgView);
                    }
                } else if (equipamento instanceof SensorPortaAberta) {
                    if (((SensorPortaAberta) equipamento).isLigado() != true) {//estado desligado
                        //cria a nova imagem da lampada desligada
                        ImageView imgView = new ImageView(consola.obterImagem(12));
                        imgView.setFitHeight(80);
                        imgView.setFitWidth(40);
                        //adiciona a imagem ao botao
                        btn[i][j] = new Button(((SensorPortaAberta) equipamento).toString(), imgView);
                    } else {
                        //cria a nova imagem da lampada ligada
                        ImageView imgView = new ImageView(consola.obterImagem(13));
                        imgView.setFitHeight(80);
                        imgView.setFitWidth(40);
                        //adiciona a imagem ao botao
                        btn[i][j] = new Button(((SensorPortaAberta) equipamento).toString(), imgView);
                    }
                } else if (equipamento instanceof SensorTemperatura) {
                    //cria a nova imagem da lampada desligada
                    ImageView imgView = new ImageView(consola.obterImagem(14));
                    imgView.setFitHeight(80);
                    imgView.setFitWidth(60);
                    //adiciona a imagem ao botao
                    btn[i][j] = new Button(((SensorTemperatura) equipamento).toString(), imgView);
                }

                //verifica a cor
                if (botaoCor == false) {
                    //preenche com a cor lightgrey
                    btn[i][j].getStyleClass().add("btn_color_red");
                } else {//se  a cor preenchida for lightgrey
                    //preenche com a cor grey
                    btn[i][j].getStyleClass().add("btn_color_marron");
                }  //representa o tamanho de altura e largura de cada botao
                btn[i][j].setPrefSize(300, 100);

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
                    /* if (object instanceof Lampada) {
                        //nostra os resultados
                        System.out.println(((Lampada) object).toString());
                        //mostra o painel com equipamentos ou para inserir
                    } else if (object instanceof ArCondicionado) {
                        //nostra os resultados
                        System.out.println(((ArCondicionado) object).toString());
                    } else if (object instanceof CamaraFotografica) {
                        //mostra os resultados
                        System.out.println(((CamaraFotografica) object).toString());
                    } else if (object instanceof CamaraVideo) {
                        //nostra os resultados
                        System.out.println(((CamaraVideo) object).toString());
                    } else if (object instanceof Sirene) {
                        //nostra os resultados
                        System.out.println(((Sirene) object).toString());
                    }*/
                    if (object instanceof Tomada) {
                        //nostra os resultados
                        System.out.println(((Tomada) object).toString());
                        try {
                            //chamar o modulo luminosidade
                            consola.getModuloControloLuminosidade().controlarEquipamento(cliente, divisaoId, "tomada");
                        } catch (ErroException ex) {
                            Logger.getLogger(PainelDivisaoFX.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (object instanceof SensorLuminosidade) {
                        //nostra os resultados
                        System.out.println(((SensorLuminosidade) object).toString());
                        //mostra o dailog com equipamentos ou para inserir
                        mostrarDialogo(((SensorLuminosidade) object));
                        try {
                            //chamar o modulo luminosidade
                            consola.getModuloControloLuminosidade().controlarEquipamento(cliente, divisaoId, "sensorLuminosidade");
                        } catch (ErroException ex) {
                            Logger.getLogger(PainelDivisaoFX.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (object instanceof SensorMovimento) {
                        //nostra os resultados
                        System.out.println(((SensorMovimento) object).toString());
                    } else if (object instanceof SensorPortaAberta) {
                        //nostra os resultados
                        System.out.println(((SensorPortaAberta) object).toString());
                    } else if (object instanceof SensorTemperatura) {
                        //nostra os resultados
                        System.out.println(((SensorTemperatura) object).toString());
                        //mostra o dailog com equipamentos ou para inserir
                        mostrarDialogo(((SensorTemperatura) object));
                        try {
                            //chamar o modulo temperatura
                            consola.getModuloControloTemperatura().controlarEquipamento(cliente, divisaoId);
                        } catch (ErroException ex) {
                            Logger.getLogger(PainelDivisaoFX.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    //retorna ao painel da mesma divisao com equipamentos atualizados
                    painelDivisaoFX(root, consola, cliente, divisaoId);
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

    private StackPane painelDivisaoFX(BorderPane root, ConsolaCentral consola, Cliente cliente, int divisaoId) {
        return new PainelDivisaoFX(root, consola, cliente, divisaoId);
    }

    private DialogFX mostrarDialogo(Equipamento equipamento) {
        return new DialogFX(equipamento);
    }
}
