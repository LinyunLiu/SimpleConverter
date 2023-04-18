/*
Name: Linyun Liu
Title: Simple Converter
 */
package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.PrintWriter;


public class Controller {

    @FXML
    private Button ButtonASCII;
    @FXML
    private Button ButtonBinary;
    @FXML
    private Button ButtonDecimal;
    @FXML
    private Button ButtonHexadecimal;
    @FXML
    private AnchorPane PaneBinary;
    @FXML
    private AnchorPane PaneDecimal;
    @FXML
    private AnchorPane PaneHexadecimal;
    @FXML
    private AnchorPane PaneASCII;

    /****************************************************************
     AnchorPane Binary
     ****************************************************************/
    @FXML
    private TextField PaneBinaryDecTF;
    @FXML
    private TextField PaneBinaryDecToBiTF;
    @FXML
    private TextField PaneBinaryHexTF;
    @FXML
    private TextField PaneBinaryHexToBiTF;
    @FXML
    private Button PaneBinaryButtonCopyDecToBi;
    @FXML
    private Button PaneBinaryButtonCopyHexToBi;

    /****************************************************************
     AnchorPane Decimal
     ****************************************************************/
    @FXML
    private TextField PaneDecimalBiTF;
    @FXML
    private TextField PaneDecimalBiToDecTF;
    @FXML
    private Button PaneDecimalButtonCopyBiToDec;
    @FXML
    private Button PaneDecimalButtonCopyHexToDec;
    @FXML
    private TextField PaneDecimalHexTF;
    @FXML
    private TextField PaneDecimalHexToDecTF;

    /****************************************************************
     AnchorPane Hexadecimal
     ****************************************************************/
    @FXML
    private TextField PaneHexBiTF;
    @FXML
    private TextField PaneHexBiToHexTF;
    @FXML
    private Button PaneHexButtonCopyBiToHex;
    @FXML
    private Button PaneHexButtonCopyDecToHex;
    @FXML
    private TextField PaneHexDecTF;
    @FXML
    private TextField PaneHexDecToHexTF;


    @FXML
    private Button ButtonPrintTable;
    @FXML
    private Button ButtonExport;
    @FXML
    private TextArea ASCIITextArea;



    public void initialize() {
        ButtonBinary.setStyle("-fx-background-color: #c8ffff; -fx-text-fill: black");
    }

    @FXML
    void processButtonBinaryClicked(ActionEvent event) {
        ResetAllButtonStyle();
        ButtonBinary.setStyle("-fx-background-color: #c8ffff; -fx-text-fill: black");
        PaneBinary.setVisible(true);
        PaneDecimal.setVisible(false);
        PaneHexadecimal.setVisible(false);
        PaneASCII.setVisible(false);
        ButtonBinary.getParent().getScene().getWindow().setHeight(255);

    }

    @FXML
    void processButtonDecimalClicked(ActionEvent event) {
        ResetAllButtonStyle();
        ButtonDecimal.setStyle("-fx-background-color: #dcffaf; -fx-text-fill: black");
        PaneBinary.setVisible(false);
        PaneDecimal.setVisible(true);
        PaneHexadecimal.setVisible(false);
        PaneASCII.setVisible(false);
        ButtonDecimal.getParent().getScene().getWindow().setHeight(255);

    }

    @FXML
    void processButtonHexadecimalClicked(ActionEvent event) {
        ResetAllButtonStyle();
        ButtonHexadecimal.setStyle("-fx-background-color: #ffacd3; -fx-text-fill: black");
        PaneBinary.setVisible(false);
        PaneDecimal.setVisible(false);
        PaneHexadecimal.setVisible(true);
        PaneASCII.setVisible(false);
        ButtonHexadecimal.getParent().getScene().getWindow().setHeight(255);

    }

    @FXML
    void processButtonASCIIClicked(ActionEvent event) {
        ResetAllButtonStyle();
        ButtonASCII.setStyle("-fx-background-color: #ffd479; -fx-text-fill: black");
        PaneBinary.setVisible(false);
        PaneDecimal.setVisible(false);
        PaneHexadecimal.setVisible(false);
        PaneASCII.setVisible(true);
        ButtonASCII.getParent().getScene().getWindow().setHeight(749);
    }


    public void ResetAllButtonStyle() {
        ButtonBinary.setStyle("-fx-background-color: #ebebeb50; -fx-text-fill:  #c8ffff; " +
                "-fx-border-color: #c8ffff; -fx-border-radius: 5");
        ButtonDecimal.setStyle("-fx-background-color: #ebebeb50; -fx-text-fill:   #dcffaf; " +
                "-fx-border-color: #dcffaf; -fx-border-radius: 5");
        ButtonHexadecimal.setStyle("-fx-background-color: #ebebeb50; -fx-text-fill:   #ffacd3; " +
                "-fx-border-color: #ffacd3; -fx-border-radius: 5");
        ButtonASCII.setStyle("-fx-background-color: #ebebeb50; -fx-text-fill:   #ffd479; " +
                "-fx-border-color: #ffd479; -fx-border-radius: 5");

    }


    //************************* AnchorPane Binary **************************//
    @FXML
    void processPaneBinaryDecTF(KeyEvent event) {
        if (!PaneBinaryDecTF.getText().isEmpty()){
            try {
                long number = Long.parseLong(PaneBinaryDecTF.getText());
                PaneBinaryDecToBiTF.setStyle("-fx-text-fill: white; -fx-border-color: #c8ffff; -fx-border-radius: 8");
                PaneBinaryDecToBiTF.setText(Long.toBinaryString(number));
            }catch (Exception e){
                PaneBinaryDecToBiTF.setText("Error");
                PaneBinaryDecToBiTF.setStyle("-fx-text-fill: #ff7e79; -fx-border-color: #c8ffff; -fx-border-radius: 8");
            }
        }
        else{
            PaneBinaryDecToBiTF.setStyle("-fx-text-fill: white; -fx-border-color: #c8ffff; -fx-border-radius: 8");
            PaneBinaryDecToBiTF.setText("");
        }
    }
    @FXML
    void processPaneBinaryButtonCopyDecToBi(ActionEvent event) {
        String str = PaneBinaryDecToBiTF.getText();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection strSel = new StringSelection(str);
        clipboard.setContents(strSel, null);
    }
    @FXML
    void processPaneBinaryHexTF(KeyEvent event) {
        if (!PaneBinaryHexTF.getText().isEmpty()){
            try {
                String number = PaneBinaryHexTF.getText().replace("0x","").replace("0X","");
                PaneBinaryHexToBiTF.setStyle("-fx-text-fill: white; -fx-border-color: #c8ffff; -fx-border-radius: 8");
                PaneBinaryHexToBiTF.setText(Long.toBinaryString(Long.parseLong(number,16)));
            }catch (Exception e){
                PaneBinaryHexToBiTF.setText("Error");
                PaneBinaryHexToBiTF.setStyle("-fx-text-fill: #ff7e79; -fx-border-color: #c8ffff; -fx-border-radius: 8");
            }
        }
        else{
            PaneBinaryHexToBiTF.setStyle("-fx-text-fill: white; -fx-border-color: #c8ffff; -fx-border-radius: 8");
            PaneBinaryHexToBiTF.setText("");
        }
    }
    @FXML
    void processPaneBinaryButtonCopyHexToBi(ActionEvent event) {
        String str = PaneBinaryHexToBiTF.getText();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection strSel = new StringSelection(str);
        clipboard.setContents(strSel, null);
    }
    //***************************** END ***********************************//


    //************************* AnchorPane Decimal **************************//
    @FXML
    void processPaneDecimalBiTF(KeyEvent event) {
        if (!PaneDecimalBiTF.getText().isEmpty()){
            try {
                long number = Long.parseLong(PaneDecimalBiTF.getText(),2);
                PaneDecimalBiToDecTF.setStyle("-fx-text-fill: white; -fx-border-color: #dcffaf; -fx-border-radius: 8");
                PaneDecimalBiToDecTF.setText(String.valueOf(number));
            }catch (Exception e){
                PaneDecimalBiToDecTF.setText("Error");
                PaneDecimalBiToDecTF.setStyle("-fx-text-fill: #ff7e79; -fx-border-color: #dcffaf; -fx-border-radius: 8");
            }
        }
        else{
            PaneDecimalBiToDecTF.setStyle("-fx-text-fill: white; -fx-border-color: #dcffaf; -fx-border-radius: 8");
            PaneDecimalBiToDecTF.setText("");
        }
    }
    @FXML
    void processPaneDecimalButtonCopyBiToDec(ActionEvent event) {
        String str = PaneDecimalBiToDecTF.getText();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection strSel = new StringSelection(str);
        clipboard.setContents(strSel, null);

    }
    @FXML
    void processPaneDecimalHexTF(KeyEvent event) {
        if (!PaneDecimalHexTF.getText().isEmpty()){
            try {
                String number = PaneDecimalHexTF.getText().replace("0x","").replace("0X","");
                PaneDecimalHexToDecTF.setStyle("-fx-text-fill: white; -fx-border-color: #dcffaf; -fx-border-radius: 8");
                PaneDecimalHexToDecTF.setText(String.valueOf(Long.parseLong(number,16)));
            }catch (Exception e){
                PaneDecimalHexToDecTF.setText("Error");
                PaneDecimalHexToDecTF.setStyle("-fx-text-fill: #ff7e79; -fx-border-color: #dcffaf; -fx-border-radius: 8");
            }
        }
        else{
            PaneDecimalHexToDecTF.setStyle("-fx-text-fill: white; -fx-border-color: #dcffaf; -fx-border-radius: 8");
            PaneDecimalHexToDecTF.setText("");
        }
    }
    @FXML
    void processPaneDecimalButtonCopyHexToDec(ActionEvent event) {
        String str = PaneDecimalHexToDecTF.getText();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection strSel = new StringSelection(str);
        clipboard.setContents(strSel, null);

    }
    //***************************** END ***********************************//


    //************************* AnchorPane Hexadecimal **************************//
    @FXML
    void processPaneHexBiTF(KeyEvent event) {
        if (!PaneHexBiTF.getText().isEmpty()){
            try {
                long number = Long.parseLong(PaneHexBiTF.getText(),2);
                PaneHexBiToHexTF.setStyle("-fx-text-fill: white; -fx-border-color: #ffacd3; -fx-border-radius: 8");
                PaneHexBiToHexTF.setText("0x"+Long.toHexString(number).toUpperCase());
            }catch (Exception e){
                PaneHexBiToHexTF.setText("Error");
                PaneHexBiToHexTF.setStyle("-fx-text-fill: #ff7e79; -fx-border-color: #ffacd3; -fx-border-radius: 8");
            }
        }
        else{
            PaneHexBiToHexTF.setStyle("-fx-text-fill: white; -fx-border-color: #ffacd3; -fx-border-radius: 8");
            PaneHexBiToHexTF.setText("");
        }
    }
    @FXML
    void processPaneHexButtonCopyBiToHex(ActionEvent event) {
        String str = PaneHexBiToHexTF.getText();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection strSel = new StringSelection(str);
        clipboard.setContents(strSel, null);
    }
    @FXML
    void processPaneHexDecTF(KeyEvent event) {
        if (!PaneHexDecTF.getText().isEmpty()){
            try {
                long number = Long.parseLong(PaneHexDecTF.getText());
                PaneHexDecToHexTF.setStyle("-fx-text-fill: white; -fx-border-color: #ffacd3; -fx-border-radius: 8");
                PaneHexDecToHexTF.setText("0x"+Long.toHexString(number).toUpperCase());
            }catch (Exception e){
                PaneHexDecToHexTF.setText("Error");
                PaneHexDecToHexTF.setStyle("-fx-text-fill: #ff7e79; -fx-border-color: #ffacd3; -fx-border-radius: 8");
            }
        }
        else{
            PaneHexDecToHexTF.setStyle("-fx-text-fill: white; -fx-border-color: #ffacd3; -fx-border-radius: 8");
            PaneHexDecToHexTF.setText("");
        }

    }
    @FXML
    void processPaneHexButtonCopyDecToHex(ActionEvent event) {
        String str = PaneHexDecToHexTF.getText();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection strSel = new StringSelection(str);
        clipboard.setContents(strSel, null);

    }
    //***************************** END ***********************************//


    @FXML
    void processButtonExport(ActionEvent event) {
        try {
            Stage window = new Stage();
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Export Destination");
            chooser.setInitialFileName("ASCII Table");
            FileChooser.ExtensionFilter extFilter1 = new FileChooser.ExtensionFilter("txt file (*.txt)", "*.txt");
            FileChooser.ExtensionFilter extFilter2 = new FileChooser.ExtensionFilter("csv file (*.csv)", "*.csv");
            chooser.getExtensionFilters().addAll(extFilter1,extFilter2);

            File file = chooser.showSaveDialog(window);
            String path = file.getAbsolutePath();
            // Write thr file with provided name and destination
            PrintWriter writer = new PrintWriter(path);
            ASCIIPrinter printer = new ASCIIPrinter();
            writer.write(printer.PrintASCIITable());
            writer.close();

        }catch (Exception ignored){}
    }
    @FXML
    void processButtonPrintTable(ActionEvent event) {
        if (ASCIITextArea.getText().isEmpty()){
            ASCIIPrinter printer = new ASCIIPrinter();
            ASCIITextArea.setText(printer.PrintASCIITable());
        }
    }





}
