package com.lhaunsp.wguproject;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Universal Controller class that controls all the different menus and FXML files
 *
 * @author Lucas Haunsperger
 */
public class InventoryManagementController implements Initializable {

    // Current Menu tracker
    private String CurMenu = "Main";

    // Main Window
    @FXML
    private TextField txtFldSearchParts;

    @FXML
    private TableView<Part> tblViewParts;

    @FXML
    private TableColumn<Part, Integer> tblViewPartsID;

    @FXML
    private TableColumn<Part, String> tblViewPartsName;

    @FXML
    private TableColumn<Part, Integer> tblViewPartsStock;

    @FXML
    private TableColumn<Part, Double> tblViewPartsPrice;

    @FXML
    private TableView<Product> tblViewProducts;

    @FXML
    private TableColumn<Product, Integer> tblViewProductsID;

    @FXML
    private TableColumn<Product, String> tblViewProductsName;

    @FXML
    private TableColumn<Product, Integer> tblViewProductsStock;

    @FXML
    private TableColumn<Product, Double> tblViewProductsPrice;

    @FXML
    private TextField txtFldSearchProducts;

    // Add / Modify Parts

    private int SelectedPartIdx; // Selected Part Index for Modify

    @FXML
    private Text lblAddModifyPart;

    @FXML
    private RadioButton rbtnPartInHouse;

    @FXML
    private ToggleGroup partTypeGroup;

    @FXML
    private RadioButton rbtnPartOutsourced;

    @FXML
    private TextField txtFldPartID;

    @FXML
    private TextField txtFldPartName;

    @FXML
    private TextField txtFldPartInv;

    @FXML
    private TextField txtFldPartPrice;

    @FXML
    private TextField txtFldPartMax;

    @FXML
    private TextField txtFldPartMin;

    @FXML
    private Text lblPartMIDCoName;

    @FXML
    private TextField txtFldPartMIDCoName;

    @FXML
    private Label lblPartError;

    // Add / Modify Products

    private int SelectedProdIdx; // Selected Prod Index for modify
    private Product newProd; // New Product to store parts for add and modify product
    // Possible to do without the above by simply using a for loop to load table into Product part list

    @FXML
    private Text lblAddModifyProd;

    @FXML
    private TextField txtFldProdID;

    @FXML
    private TextField txtFldProdName;

    @FXML
    private TextField txtFldProdInv;

    @FXML
    private TextField txtFldProdPrice;

    @FXML
    private TextField txtFldProdMax;

    @FXML
    private TextField txtFldProdMin;

    @FXML
    private TextField txtFldProdSearchParts;

    @FXML
    private TableView<Part> tblViewProdMenuParts;

    @FXML
    private TableColumn<Part, Integer> tblViewProdMenuPartsID;

    @FXML
    private TableColumn<Part, String> tblViewProdMenuPartsName;

    @FXML
    private TableColumn<Part, Integer> tblViewProdMenuPartsStock;

    @FXML
    private TableColumn<Part, Double> tblViewProdMenuPartsPrice;

    @FXML
    private TableView<Part> tblViewProdAddedParts;

    @FXML
    private TableColumn<Part, Integer> tblViewProdAddedPartsID;

    @FXML
    private TableColumn<Part, String> tblViewProdAddedPartsName;

    @FXML
    private TableColumn<Part, Integer> tblViewProdAddedPartsStock;

    @FXML
    private TableColumn<Part, Double> tblViewProdAddedPartsPrice;

    @FXML
    private Label lblProdError;

    /**
     * initializes the controller and sets up tables based on which FXML file is loaded
     * @param location  the location of the fxml file
     * @param resources the resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (Objects.equals(location, getClass().getResource("IMSMain.fxml"))) {

            tblViewParts.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            tblViewPartsID.setCellValueFactory(new PropertyValueFactory<>("id"));
            tblViewPartsName.setCellValueFactory(new PropertyValueFactory<>("name"));
            tblViewPartsStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
            tblViewPartsPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
            tblViewParts.getItems().setAll(Inventory.getAllParts());

            tblViewProducts.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            tblViewProductsID.setCellValueFactory(new PropertyValueFactory<>("id"));
            tblViewProductsName.setCellValueFactory(new PropertyValueFactory<>("name"));
            tblViewProductsStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
            tblViewProductsPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
            tblViewProducts.getItems().setAll(Inventory.getAllProducts());

        } else if (Objects.equals(location, getClass().getResource("AddModifyProductMenu.fxml"))) {

            tblViewProdMenuParts.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            tblViewProdMenuPartsID.setCellValueFactory(new PropertyValueFactory<>("id"));
            tblViewProdMenuPartsName.setCellValueFactory(new PropertyValueFactory<>("name"));
            tblViewProdMenuPartsStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
            tblViewProdMenuPartsPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
            tblViewProdMenuParts.getItems().setAll(Inventory.getAllParts());

            tblViewProdAddedParts.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            tblViewProdAddedPartsID.setCellValueFactory(new PropertyValueFactory<>("id"));
            tblViewProdAddedPartsName.setCellValueFactory(new PropertyValueFactory<>("name"));
            tblViewProdAddedPartsStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
            tblViewProdAddedPartsPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        }

    }


    //Switching menus

    /**
     * Switches to the main menu FXML file
     * @param scene, the current scene
     * @throws IOException Error loading file
     */
    private void switchToMainScene(Scene scene) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("IMSMain.fxml"));
        scene.setRoot(loader.load());
        scene.getWindow().sizeToScene();
    }

    /**
     * Switches to the AddModifyPart Menu FXML file
     * RUNTIME ERROR: *FIXED* Many errors trying to load menus in current controller instance after switching the menu
     * Fixed by finding the controller instance of the new menu and running a menu setup function in it as soon as the new FXML is loaded
     * @param scene,      the current scene
     * @param isAddScene, if true, starts add scene, if false starts modify scene
     * @throws IOException Error loading file
     */
    private void switchToAddModifyPartScene(Scene scene, boolean isAddScene, int partIdx) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddModifyPartMenu.fxml"));
        scene.setRoot(loader.load());
        scene.getWindow().setWidth(575);
        scene.getWindow().setHeight(550);
        InventoryManagementController controller = loader.getController();
        if (isAddScene) {
            controller.loadPartAddMenu();
        } else if (partIdx != -1) {
            controller.loadPartModifyMenu(partIdx);
        } else {
            //Error modify with no part
            System.out.println("Error no part selected!");
        }
    }

    /**
     * Just calls switchToAddModifyPartScene with correct params
     *
     * @param scene the current scene
     * @throws IOException Error loading file
     */
    private void switchToAddPartScene(Scene scene) throws IOException {
        switchToAddModifyPartScene(scene, true, -1);
    }

    /**
     * Just calls switchToAddModifyPartScene with correct params
     *
     * @param scene   the current scene
     * @param partIdx the index of the selected part
     * @throws IOException Error loading file
     */
    private void switchToModifyPartScene(Scene scene, int partIdx) throws IOException {
        switchToAddModifyPartScene(scene, false, partIdx);
    }

    /**
     * Loads the AddModifyPart FXML file
     * @param scene,      the current scene
     * @param isAddScene, if true, starts add scene, if false starts modify scene
     * @throws IOException Error loading file
     */
    private void switchToAddModifyProductScene(Scene scene, boolean isAddScene, int partIdx) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddModifyProductMenu.fxml"));
        scene.setRoot(loader.load());
        scene.getWindow().setWidth(830);
        scene.getWindow().setHeight(590);
        InventoryManagementController controller = loader.getController();
        if (isAddScene) {
            controller.loadProdAddMenu();
        } else if (partIdx != -1) {
            controller.loadProdModifyMenu(partIdx);
        } else {
            //Error modify with no part
            System.out.println("Error no part selected!");
        }
    }

    /**
     * Just calls switchToAddModifyProductScene with correct params
     *
     * @param scene the current scene
     * @throws IOException Error loading file
     */
    private void switchToAddProductScene(Scene scene) throws IOException {
        switchToAddModifyProductScene(scene, true, -1);
    }

    /**
     * Just calls switchToAddModifyProductScene with correct params
     *
     * @param scene   the current scene
     * @param prodIdx the index of the selected product
     * @throws IOException Error loading file
     */
    private void switchToModifyProductScene(Scene scene, int prodIdx) throws IOException {
        switchToAddModifyProductScene(scene, false, prodIdx);
    }


    // --------------------------- Main Window

    /**
     * Exits program
     *
     * @param event the triggering event
     */
    @FXML
    void btnExitClicked(ActionEvent event) {
        ButtonType exitButton = new ButtonType("Exit");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "All data will be lost.", exitButton, ButtonType.CANCEL);
        alert.setHeaderText("Are you sure you want to exit the Program?");
        alert.showAndWait();
        if (alert.getResult().getText().equals("Exit")) {
            Platform.exit();
        }

    }

    /**
     * Switches to Add Part menu
     *
     * @param event the triggering event
     */
    @FXML
    void btnPartsAddClicked(ActionEvent event) {
        Scene scene = ((Button) event.getSource()).getScene();
        try {
            switchToAddPartScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes part if user accepts prompt and updates menu
     * RUNTIME ERROR: *FIXED* Did not update table after delete allowing user to select deleted part to modify causing errors when trying to access deleted part.
     * Fixed by updating table after every delete
     *
     * @param event the triggering event
     */
    @FXML
    void btnPartsDeleteClicked(ActionEvent event) {
        if (tblViewParts.getSelectionModel().getSelectedItem() != null) {
            ButtonType delButton = new ButtonType("Delete");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "This action can not be undone.", delButton, ButtonType.CANCEL);
            alert.setHeaderText("Are you sure you want to delete this Part?");
            alert.showAndWait();
            if (alert.getResult().getText().equals("Delete")) {
                boolean success = Inventory.deletePart(tblViewParts.getSelectionModel().getSelectedItem());
                tblViewParts.getItems().setAll(Inventory.getAllParts());
                if (!success) {
                    System.out.println("Error deleting Part");
                }
            }
        }
    }

    /**
     * Switches to Modify Part menu with selected part
     *
     * @param event the triggering event
     */
    @FXML
    void btnPartsModifyClicked(ActionEvent event) {
        Scene scene = ((Button) event.getSource()).getScene();

        Part part = tblViewParts.getSelectionModel().getSelectedItem();
        if (part != null) {
            int partId = part.getId();

            try {
                switchToModifyPartScene(scene, partId);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Switches to Add Product menu
     *
     * @param event the triggering event
     */
    @FXML
    void btnProductsAddClicked(ActionEvent event) {
        Scene scene = ((Button) event.getSource()).getScene();
        try {
            switchToAddProductScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes product if user accepts prompt and updates menu
     *
     * @param event the triggering event
     */
    @FXML
    void btnProductsDeleteClicked(ActionEvent event) {
        Product selected = tblViewProducts.getSelectionModel().getSelectedItem();
        if (selected != null) {
            ButtonType delButton = new ButtonType("Delete");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "This action can not be undone.", delButton, ButtonType.CANCEL);
            alert.setHeaderText("Are you sure you want to delete this Product?");
            alert.showAndWait();
            if (alert.getResult().getText().equals("Delete")) {
                if (!selected.getAllAssociatedParts().isEmpty()) {
                    Alert alert2 = new Alert(Alert.AlertType.WARNING, "If you want to delete this Product remove all associated Parts first.");
                    alert2.setHeaderText("Warning: Product has associated Parts");
                    alert2.showAndWait();
                } else {
                    boolean success = Inventory.deleteProduct(selected);
                    tblViewProducts.getItems().setAll(Inventory.getAllProducts());
                    if (!success) {
                        System.out.println("Error deleting Product");
                    }
                }
            }
        }
    }

    /**
     * Switches to Modify Product menu with selected product
     *
     * @param event the triggering event
     */
    @FXML
    void btnProductsModifyClicked(ActionEvent event) {
        Scene scene = ((Button) event.getSource()).getScene();

        Product prod = tblViewProducts.getSelectionModel().getSelectedItem();
        if (prod != null) {
            int prodId = prod.getId();

            try {
                switchToModifyProductScene(scene, prodId);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Uses the input in the search box to filter the Parts and select one or display a limited selection
     *
     * @param event the triggering event
     */
    @FXML
    void txtFldSearchPartsSubmit(ActionEvent event) {
        String SearchText = txtFldSearchParts.getText();
        if (SearchText.isBlank()) {
            tblViewParts.getItems().setAll(Inventory.getAllParts());
        } else {
            ObservableList<Part> result = FXCollections.observableArrayList();
            result.addAll(Inventory.lookupPart(SearchText));
            int SearchNum = -1;
            boolean searchByID = true;
            try {
                SearchNum = Integer.parseInt(SearchText);
            } catch (NumberFormatException e) {
                // Search Text not an int
                searchByID = false;
            }
            if (searchByID) {
                Part idSearchResult = Inventory.lookupPart(SearchNum);
                if (idSearchResult != null) {
                    if (!result.contains(idSearchResult)) {
                        result.add(0, idSearchResult);
                    }
                }
            }

            if (result.size() == 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "No Results were found for your search.");
                alert.setHeaderText("No Results");
                alert.showAndWait();
                tblViewParts.getItems().setAll(Inventory.getAllParts());
            } else if (result.size() == 1) {
                tblViewParts.getItems().setAll(Inventory.getAllParts());
                tblViewParts.getSelectionModel().select(result.get(0));
                tblViewParts.scrollTo(result.get(0));
            } else {
                tblViewParts.getItems().setAll(result);
                tblViewParts.getSelectionModel().clearSelection();
            }
        }

    }

    /**
     * Uses the input in the search box to filter the Products and select one or display a limited selection
     *
     * @param event the triggering event
     */
    @FXML
    void txtFldSearchProductsSubmit(ActionEvent event) {
        String SearchText = txtFldSearchProducts.getText();
        if (SearchText.isBlank()) {
            tblViewProducts.getItems().setAll(Inventory.getAllProducts());
        } else {
            ObservableList<Product> result = FXCollections.observableArrayList();
            result.addAll(Inventory.lookupProduct(SearchText));
            int SearchNum = -1;
            boolean searchByID = true;
            try {
                SearchNum = Integer.parseInt(SearchText);
            } catch (NumberFormatException e) {
                // Search Text not an int
                searchByID = false;
            }
            if (searchByID) {
                Product idSearchResult = Inventory.lookupProduct(SearchNum);
                if (idSearchResult != null) {
                    if (!result.contains(idSearchResult)) {
                        result.add(0, idSearchResult);
                    }
                }
            }

            if (result.size() == 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "No Results were found for your search.");
                alert.setHeaderText("No Results");
                alert.showAndWait();
                tblViewProducts.getItems().setAll(Inventory.getAllProducts());
            } else if (result.size() == 1) {
                tblViewProducts.getItems().setAll(Inventory.getAllProducts());
                tblViewProducts.getSelectionModel().select(result.get(0));
                tblViewProducts.scrollTo(result.get(0));
            } else {
                tblViewProducts.getItems().setAll(result);
                tblViewProducts.getSelectionModel().clearSelection();
            }
        }
    }

    // --------------------------- Add/Modify Part Menu

    /**
     * Initializes the Part Add Menu
     */
    private void loadPartAddMenu() {
        this.CurMenu = "Add";
        lblAddModifyPart.setText("Add Part");
    }

    /**
     * Initializes the Part Modify menu with all the values from the part
     *
     * @param SelectedPartIndex the index of the part to load values from
     */
    private void loadPartModifyMenu(int SelectedPartIndex) {
        this.CurMenu = "Modify";
        this.SelectedPartIdx = SelectedPartIndex;
        Part SelectedPart = Inventory.getAllParts().get(SelectedPartIndex);

        lblAddModifyPart.setText("Modify Part");
        txtFldPartID.setText(String.valueOf(SelectedPart.getId()));
        txtFldPartName.setText(SelectedPart.getName());
        txtFldPartInv.setText(String.valueOf(SelectedPart.getStock()));
        txtFldPartPrice.setText(String.valueOf(SelectedPart.getPrice()));
        txtFldPartMax.setText(String.valueOf(SelectedPart.getMax()));
        txtFldPartMin.setText(String.valueOf(SelectedPart.getMin()));
        if (SelectedPart instanceof InHouse) {
            txtFldPartMIDCoName.setText(String.valueOf(((InHouse) SelectedPart).getMachineId()));
        } else {
            txtFldPartMIDCoName.setText(((Outsourced) SelectedPart).getCompanyName());
            lblPartMIDCoName.setText("Company Name");
            partTypeGroup.selectToggle(rbtnPartOutsourced);
        }

    }

    /**
     * Returns to Main Menu
     *
     * @param event the triggering event
     */
    @FXML
    void btnPartCancelClicked(ActionEvent event) {
        Scene scene = ((Button) event.getSource()).getScene();
        try {
            switchToMainScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Validates input and if valid saves new part and returns to menu. Otherwise, gives error.
     *
     * @param event the triggering event
     */
    @FXML
    void btnPartSaveClicked(ActionEvent event) {
        String ErrString = "";
        boolean isInHouse = (partTypeGroup.getSelectedToggle() == rbtnPartInHouse);
        String nameTxt = txtFldPartName.getText();
        String invTxt = txtFldPartInv.getText();
        String priceText = txtFldPartPrice.getText();
        String maxTxt = txtFldPartMax.getText();
        String minTxt = txtFldPartMin.getText();
        String MIDCoNameTxt = txtFldPartMIDCoName.getText();

        int max = -1;
        int min = -1;
        int inv = -1;
        double price = -1;
        int machineID = -1;
        if (nameTxt.isBlank()) {
            ErrString += "No data in Name field\n";
        }

        try {
            inv = Integer.parseInt(invTxt);
        } catch (NumberFormatException e) {
            ErrString += "Inventory is not an integer\n";
        }

        try {
            price = Double.parseDouble(priceText);
        } catch (NumberFormatException e) {
            ErrString += "Price is not a double\n";
        }

        try {
            max = Integer.parseInt(maxTxt);
        } catch (NumberFormatException e) {
            ErrString += "Max is not an integer\n";
        }

        try {
            min = Integer.parseInt(minTxt);
        } catch (NumberFormatException e) {
            ErrString += "Min is not an integer\n";
        }

        if (ErrString.isEmpty()) {
            if (min >= max) {
                ErrString += "Min must be less than Max\n";
            } else if (inv < min || inv > max) {
                ErrString += "Inventory must be between Min and Max\n";
            } else if (isInHouse) {
                try {
                    machineID = Integer.parseInt(MIDCoNameTxt);
                } catch (NumberFormatException e) {
                    ErrString += "Machine ID is not an integer\n";
                }
            } else {
                if (MIDCoNameTxt.isBlank()) {
                    ErrString += "No data in Company Name field\n";
                }
            }
        }


        if (ErrString.isEmpty()) {
            int id;
            if (Objects.equals(CurMenu, "Add")) {
                id = idTracker.getNextPartID();
            } else {
                id = Inventory.getAllParts().get(SelectedPartIdx).getId();
            }

            Part part;
            if (isInHouse) {
                part = new InHouse(id, nameTxt, price, inv, min, max, machineID);
            } else {
                part = new Outsourced(id, nameTxt, price, inv, min, max, MIDCoNameTxt);
            }
            if (Objects.equals(CurMenu, "Add")) {
                Inventory.addPart(part);
            } else {
                Inventory.updatePart(SelectedPartIdx, part);
            }

            Scene scene = ((Button) event.getSource()).getScene();
            try {
                switchToMainScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            ErrString = "Exception: " + ErrString;
            lblPartError.setText(ErrString);
        }

    }

    /**
     * Switches text box to Company Name
     *
     * @param event the triggering event
     */
    @FXML
    void rbtnPartOutsourcedSelected(ActionEvent event) {
        lblPartMIDCoName.setText("Company Name");
        txtFldPartMIDCoName.setText("");
    }

    /**
     * Switches text box to Machine ID
     *
     * @param event the triggering event
     */
    @FXML
    void rbtnPartInHouseSelected(ActionEvent event) {
        lblPartMIDCoName.setText("Machine ID");
        txtFldPartMIDCoName.setText("");
    }

    // ----------------- Add / Modify Products Menu

    /**
     * Initializes the Product Add Menu
     */
    private void loadProdAddMenu() {
        this.CurMenu = "Add";
        lblAddModifyProd.setText("Add Product");
        this.newProd = new Product(0, "", 0.0, 0, 0, 0);
    }

    /**
     * Initializes the Part Modify menu with all the values from the part
     *
     * @param SelectedProdIndex the index of the part to load values from
     */
    private void loadProdModifyMenu(int SelectedProdIndex) {
        this.CurMenu = "Modify";
        this.SelectedProdIdx = SelectedProdIndex;
        this.newProd = new Product(0, "", 0.0, 0, 0, 0);
        Product SelectedProd = Inventory.getAllProducts().get(SelectedProdIndex);

        lblAddModifyProd.setText("Modify Product");
        txtFldProdID.setText(String.valueOf(SelectedProd.getId()));
        txtFldProdName.setText(SelectedProd.getName());
        txtFldProdInv.setText(String.valueOf(SelectedProd.getStock()));
        txtFldProdPrice.setText(String.valueOf(SelectedProd.getPrice()));
        txtFldProdMax.setText(String.valueOf(SelectedProd.getMax()));
        txtFldProdMin.setText(String.valueOf(SelectedProd.getMin()));

        ObservableList<Part> prodParts = SelectedProd.getAllAssociatedParts();
        if (!prodParts.isEmpty()) {
            tblViewProdAddedParts.getItems().setAll(prodParts);
            for (Part part : prodParts) {
                newProd.addAssociatedPart(part);
            }
        }


    }

    /**
     * Adds part to the AddedParts table of the product
     *
     * @param event the triggering event
     */
    @FXML
    void btnProdAddPartClicked(ActionEvent event) {
        Part selectedPart = tblViewProdMenuParts.getSelectionModel().getSelectedItem();
        if (selectedPart != null) {
            ObservableList<Part> addedParts = FXCollections.observableArrayList();
            addedParts.addAll(tblViewProdAddedParts.getItems());
            addedParts.add(selectedPart);
            tblViewProdAddedParts.getItems().setAll(addedParts);
            newProd.addAssociatedPart(selectedPart);
        }

    }

    /**
     * Returns to Main Menu
     *
     * @param event the triggering event
     */
    @FXML
    void btnProdCancelClicked(ActionEvent event) {
        Scene scene = ((Button) event.getSource()).getScene();
        try {
            switchToMainScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Removes selected item from AddedParts table if user confirms
     *
     * @param event the triggering event
     */
    @FXML
    void btnProdRemovePartClicked(ActionEvent event) {
        if (tblViewProdAddedParts.getSelectionModel().getSelectedItem() != null) {
            ButtonType remButton = new ButtonType("Remove");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "This action can not be undone.", remButton, ButtonType.CANCEL);
            alert.setHeaderText("Are you sure you want to remove this Part?");
            alert.showAndWait();
            if (alert.getResult().getText().equals("Remove")) {
                boolean deleted = newProd.deleteAssociatedPart(tblViewProdAddedParts.getSelectionModel().getSelectedItem());
                if (deleted) {
                    tblViewProdAddedParts.getItems().remove(tblViewProdAddedParts.getSelectionModel().getSelectedIndex());
                } else {
                    System.out.println("Error deleting, skipped");
                }
            }
        }
    }

    /**
     * Validates input and if valid saves new Product and returns to menu. Otherwise, gives error.
     *
     * @param event the triggering event
     */
    @FXML
    void btnProdSaveClicked(ActionEvent event) {
        String ErrString = "";
        String nameTxt = txtFldProdName.getText();
        String invTxt = txtFldProdInv.getText();
        String priceText = txtFldProdPrice.getText();
        String maxTxt = txtFldProdMax.getText();
        String minTxt = txtFldProdMin.getText();

        int max = -1;
        int min = -1;
        int inv = -1;
        double price = -1;
        if (nameTxt.isBlank()) {
            ErrString += "No data in Name field\n";
        }

        try {
            inv = Integer.parseInt(invTxt);
        } catch (NumberFormatException e) {
            ErrString += "Inventory is not an integer\n";
        }

        try {
            price = Double.parseDouble(priceText);
        } catch (NumberFormatException e) {
            ErrString += "Price is not a double\n";
        }

        try {
            max = Integer.parseInt(maxTxt);
        } catch (NumberFormatException e) {
            ErrString += "Max is not an integer\n";
        }

        try {
            min = Integer.parseInt(minTxt);
        } catch (NumberFormatException e) {
            ErrString += "Min is not an integer\n";
        }

        if (ErrString.isEmpty()) {
            if (min >= max) {
                ErrString += "Min must be less than Max\n";
            } else if (inv < min || inv > max) {
                ErrString += "Inventory must be between Min and Max\n";
            }
        }


        if (ErrString.isEmpty()) {
            int id;
            if (Objects.equals(CurMenu, "Add")) {
                id = idTracker.getNextProdID();
            } else {
                id = Inventory.getAllProducts().get(SelectedProdIdx).getId();
            }

            newProd.setId(id);
            newProd.setName(nameTxt);
            newProd.setPrice(price);
            newProd.setStock(inv);
            newProd.setMin(min);
            newProd.setMax(max);

            if (Objects.equals(CurMenu, "Add")) {
                Inventory.addProduct(newProd);
            } else {
                Inventory.updateProduct(SelectedProdIdx, newProd);
            }

            Scene scene = ((Button) event.getSource()).getScene();
            try {
                switchToMainScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            ErrString = "Exception: " + ErrString;
            lblProdError.setText(ErrString);
        }

    }

    /**
     * Uses the input in the search box to filter the Parts and select one or display a limited selection
     *
     * @param event the triggering event
     */
    @FXML
    void txtFldProdSearchPartsSubmit(ActionEvent event) {
        String SearchText = txtFldProdSearchParts.getText();
        if (SearchText.isBlank()) {
            tblViewProdMenuParts.getItems().setAll(Inventory.getAllParts());
        } else {
            ObservableList<Part> result = FXCollections.observableArrayList();
            result.addAll(Inventory.lookupPart(SearchText));
            int SearchNum = -1;
            boolean searchByID = true;
            try {
                SearchNum = Integer.parseInt(SearchText);
            } catch (NumberFormatException e) {
                // Search Text not an int
                searchByID = false;
            }
            if (searchByID) {
                Part idSearchResult = Inventory.lookupPart(SearchNum);
                if (idSearchResult != null) {
                    if (!result.contains(idSearchResult)) {
                        result.add(0, idSearchResult);
                    }
                }
            }

            if (result.size() == 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "No Results were found for your search.");
                alert.setHeaderText("No Results");
                alert.showAndWait();
                tblViewProdMenuParts.getItems().setAll(Inventory.getAllParts());
            } else if (result.size() == 1) {
                tblViewProdMenuParts.getItems().setAll(Inventory.getAllParts());
                tblViewProdMenuParts.getSelectionModel().select(result.get(0));
                tblViewProdMenuParts.scrollTo(result.get(0));
            } else {
                tblViewProdMenuParts.getItems().setAll(result);
                tblViewProdMenuParts.getSelectionModel().clearSelection();
            }
        }
    }

}
