package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class ViewController {

	@FXML
	private TextField txtPrecoNormal;

	@FXML
	private TextField txtValorParcelas;

	@FXML
	private Spinner<Integer> spnQuantidadeparcelas;

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
			double precoNormal = Double.parseDouble(txtPrecoNormal.getText());
			double valorParcela = Double.parseDouble(txtValorParcelas.getText());
			int totalParcelas = spnQuantidadeparcelas.getValue();
			double valorPrazo = totalParcelas * valorParcela;
			double juros = valorPrazo - precoNormal;
			double percentual = (juros / precoNormal) * 100.0;
			txtValorPrazo.setText(String.format("%.2f", valorPrazo));
			txtPercentual.setText(String.format("%.2f", percentual) + " %");

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

}