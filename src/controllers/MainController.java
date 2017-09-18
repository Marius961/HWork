package controllers;

import javafx.scene.input.MouseEvent;
import HomeWork.Main;
import content.Subject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import content.Subject;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

public class MainController {
	
	private ObservableList<Subject> subjectsList = FXCollections.observableArrayList();

    @FXML
    private Button add;
    
    @FXML
    private TableView<Subject> subjTable;
    
    @FXML
    private TableColumn<Subject,Integer> colN;
    
    @FXML
    private TableColumn<Subject,String> colSubject;
    @FXML
    private TableColumn<Subject,String> colLecture;
    
    private void initData() {
    	subjectsList.add(new Subject(1, "����������� ����'������� �����", "�������� �.�."));
    	subjectsList.add(new Subject(2, "������ �������������� �� �����������", "�.�.�. ���. ������� �.�."));
    	subjectsList.get(1).setHomework("Test Homework");
    }
 
    private void initialize() {
        initData();

        colN.setCellValueFactory(new PropertyValueFactory<Subject, Integer>("id"));
        
        colSubject.setCellValueFactory(new PropertyValueFactory<Subject, String>("name"));
        colLecture.setCellValueFactory(new PropertyValueFactory<Subject, String>("lect"));
        
        subjTable.setItems(subjectsList);
    }
    
    
    public void deleteClickMethod(){
        
    }
    
    public void editClickMethod(){
        
    }
    
    public void on1stClick(){
        
    }
    
    public void on2ndClick(){
        
    }
    
    public void addClickMethod() {
        
    }
    
    
    
    
}