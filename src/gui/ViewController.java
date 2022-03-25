package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

public class ViewController implements Initializable {

	int totalParcelas;

	@FXML
	private TextField txtPrecoNormal;

	@FXML
	private TextField txtValorParcelas;

	@FXML
	private Spinner<Integer> mySpinner;

	@FXML
	private TextField txtValorPrazo;

	@FXML
	private TextField txtJuros;

	@FXML
	private TextField txtPercentual;

	@FXML
	private Button btnLimpar;

	@FXML
	private Button btnCalcular;

	@FXML
	void btnLimparAction() {
		txtPrecoNormal.clear();
		txtValorParcelas.clear();
		txtValorPrazo.clear();
		txtJuros.clear();
		txtPercentual.clear();
	}

	@FXML
	void btnCalcularAction() {
		try {
			double precoNormal = Double.parseDouble(txtPrecoNormal.getText().replace(',', '.'));
			double valorParcela = Double.parseDouble(txtValorParcelas.getText().replace(',', '.'));
			double valorPrazo = totalParcelas * valorParcela;
			double juros = valorPrazo - precoNormal;
			double percentual = (juros / precoNormal) * 100.0;
			txtValorPrazo.setText(String.format("%.2f", valorPrazo));
			txtJuros.setText(String.format("%.2f", juros));
			txtPercentual.setText(String.format("%.2f", percentual) + " %");

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 40);
		valueFactory.setValue(10);
		mySpinner.setValueFactory(valueFactory);
		totalParcelas = mySpinner.getValue();
		mySpinner.valueProperty().addListener(new ChangeListener<Integer>() {

			@Override
			public void changed(ObservableValue<? extends Integer> arg0, Integer arg1, Integer arg2) {
				totalParcelas = mySpinner.getValue();
			}

		});
	}
}