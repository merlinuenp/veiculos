package app;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Motorista;
import util.Dao;

/**
 *
 * @author Usuário
 */
public class ListarMotoristaController {

    @FXML
    private TableView tabelaMotoristas;

    ObservableList<Motorista> lista;

    @FXML
    private void initialize() {
        Dao<Motorista> dao = new Dao(Motorista.class);
        List<Motorista> todos = dao.listarTodos();
        lista = FXCollections.observableArrayList(todos);

        TableColumn<Motorista, String> colunaNome = new TableColumn<>("Nome");
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<Motorista, String> colunaCategoria = new TableColumn<>("Categoria");
        colunaCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));

        tabelaMotoristas.getColumns().addAll(colunaNome, colunaCategoria);

        tabelaMotoristas.setItems(lista);
    } 

}
