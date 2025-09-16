package com.dha.translateapp;

import com.dha.pojo.Word;
import com.dha.services.BaseServices;
import com.dha.services.UpdateWordServices;
import com.dha.services.WordServices;
import com.dha.utils.mode.En_VieTranslateFactory;
import com.dha.utils.mode.ITranslate;
import com.dha.utils.mode.Mode;
import com.dha.utils.mode.Vie_EnTranslateFactory;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Dictionary;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class PrimaryController implements Initializable {

    @FXML
    private TableView<Word> tbview;
    @FXML
    private ComboBox<Mode> cbMode;
    @FXML
    private TextField txtFill;
    @FXML
    private TextArea taView;
    @FXML
    TextField txtVie;
    @FXML
    TextField txtEn;

    BaseServices<Word> wServices = new WordServices();
    UpdateWordServices uWord = new UpdateWordServices();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadTableData();
        loadColum();
    }
    
    
    private void loadTableData(){
        try {
            this.tbview.setItems(FXCollections.observableList(wServices.list()));
            this.cbMode.setItems(FXCollections.observableArrayList(Mode.values()));

        } catch (SQLException ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadColum() {
        TableColumn id = new TableColumn("ID");
        id.setCellValueFactory(new PropertyValueFactory("id"));
        id.setPrefWidth(80);
        TableColumn vie = new TableColumn("vietnamese");
        vie.setCellValueFactory(new PropertyValueFactory("vietnamese"));
        vie.setPrefWidth(150);
        TableColumn en = new TableColumn("english");
        en.setCellValueFactory(new PropertyValueFactory("english"));
        en.setPrefWidth(150);

        TableColumn<Word, Void> colAction = new TableColumn<>("Xóa");
        colAction.setCellFactory(p -> {
            TableCell<Word, Void> cell = new TableCell<Word, Void>() {
                private final Button btn = new Button("Xóa");
                
                {
                    btn.setOnAction(event -> {
                        Word w = getTableView().getItems().get(getIndex());
                        try {
                            if (uWord.delWord(w.getId())) {
                                getTableView().getItems().remove(w);
                                System.out.println("Xóa từ thành công!");
                            } else {
                                System.out.println("Xóa từ thất bại!");
                            }
                        } catch (SQLException e) {
                            System.out.println("Lỗi cơ sở dữ liệu: " + e.getMessage());
                            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, e);
                        }
                    });
                }

                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(btn);
                    }
                }
            };
            return cell;
        });

        this.tbview.getColumns().clear();
        this.tbview.getColumns().addAll(id, vie, en,colAction);
    }

    public void handleAdd(ActionEvent e) throws SQLException {
        String vie = this.txtVie.getText();
        String en = this.txtEn.getText();

        if (vie.isEmpty() || en.isEmpty()) {
            System.out.println("Mời bạn nhập đủ dữ liệu");
            return;
        }

        Word w = new Word(vie, en);
        if (uWord.addWord(w)) {
            System.out.println("Thêm thành công");
            this.loadTableData();
            this.txtVie.clear();
            this.txtEn.clear();
        } else {
            System.out.println("Thêm thất bại!");
        }

    }
    public void handleChangeThemes(ActionEvent event) {
        this.cbMode.getSelectionModel().getSelectedItem().updateTheme(this.cbMode.getScene());
    }

    public void handleTrans(ActionEvent e) throws SQLException {
        String wordToTranslate = this.txtFill.getText();
        Mode selectedMode = this.cbMode.getSelectionModel().getSelectedItem();

        if (selectedMode == null || wordToTranslate.isEmpty()) {
            this.taView.setText("Vui lòng nhập từ và chọn chế độ dịch.");
            return;
        }

        ITranslate factory = null;
        if (selectedMode.equals(Mode.Anh_Viet)) {
            factory = new En_VieTranslateFactory();
        } else if (selectedMode.equals(Mode.Viet_Anh)) {
            factory = new Vie_EnTranslateFactory();
        }

        List<Word> dictionary = wServices.list();
        if (factory != null) {
            this.taView.setText(factory.translated(wordToTranslate, dictionary));

        }

    }
}
