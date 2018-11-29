package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    baseConnect bc = new baseConnect ();
    Parser parse = new Parser();

    @FXML
    private Button buttonPrice;
    @FXML
    private Button buttonPrice1;

    @FXML
    private TableView<pojoAI> tableBenz;
    @FXML
    private TableColumn<pojoAI, String> tableBenz_nameAzs;
    @FXML
    private TableColumn<pojoAI, String> tableBenz_ai_80;
    @FXML
    private TableColumn<pojoAI, String> tableBenz_ai_Propan;
    @FXML
    private TableColumn<pojoAI, String> tableBenz_ai_98;
    @FXML
    private TableColumn<pojoAI, String> tableBenz_ai_Metan;
    @FXML
    private TableColumn<pojoAI, String> tableBenz_ai_95;
    @FXML
    private TableColumn<pojoAI, String> tableBenz_ai_100;
    @FXML
    private TableColumn<pojoAI, String> tableBenz_ai_DT_plus;
    @FXML
    private TableColumn<pojoAI, String> tableBenz_ai_DT;
    @FXML
    private TableColumn<pojoAI, String> tableBenz_ai_92;
    @FXML
    private TableColumn<pojoAI, String> tableBenz_ai_92_plus;
    @FXML
    private TableColumn<pojoAI, String> tableBenz_ai_95_plus;
    @FXML
    private TableColumn<pojoAI, String> tableBenz_adress;

    @FXML
    private void initialize() {
        tableBenz_nameAzs.setCellValueFactory(new PropertyValueFactory<pojoAI, String>("tableBenz_nameAzs"));
        tableBenz_ai_80.setCellValueFactory(new PropertyValueFactory<pojoAI, String>("tableBenz_ai_80"));
        tableBenz_ai_92.setCellValueFactory(new PropertyValueFactory<pojoAI, String>("tableBenz_ai_92"));
        tableBenz_ai_92_plus.setCellValueFactory(new PropertyValueFactory<pojoAI, String>("tableBenz_ai_92_plus"));
        tableBenz_ai_95.setCellValueFactory(new PropertyValueFactory<pojoAI, String>("tableBenz_ai_95"));
        tableBenz_ai_95_plus.setCellValueFactory(new PropertyValueFactory<pojoAI, String>("tableBenz_ai_95_plus"));
        tableBenz_ai_98.setCellValueFactory(new PropertyValueFactory<pojoAI, String>("tableBenz_ai_98"));
        tableBenz_ai_100.setCellValueFactory(new PropertyValueFactory<pojoAI, String>("tableBenz_ai_100"));
        tableBenz_ai_DT.setCellValueFactory(new PropertyValueFactory<pojoAI, String>("tableBenz_ai_dt"));
        tableBenz_ai_DT_plus.setCellValueFactory(new PropertyValueFactory<pojoAI, String>("tableBenz_ai_dt_plus"));
        tableBenz_ai_Propan.setCellValueFactory(new PropertyValueFactory<pojoAI, String>("tableBenz_ai_propan"));
        tableBenz_ai_Metan.setCellValueFactory(new PropertyValueFactory<pojoAI, String>("tableBenz_ai_metan"));
        tableBenz_adress.setCellValueFactory(new PropertyValueFactory<pojoAI, String>("tableBenz_adress"));
        tableBenz.setItems(bc.list);
    }

    @FXML
    public void onClickBD ()
    {
        bc.Connection();
    }

    @FXML
    public void onClickParse ()
    {
        parse.pars();
    }

}
