import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class Formulario extends JFrame {
	
	DataAcces data;
	private JTextField txtNombre;
	private JButton btnGuardar;
	
	public Formulario(){
		this.setSize(700, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Consulta Base de Datos");
		this.setLayout(null);
		data = new DataAcces("MYSQL");
		data.setServer("localhost");
		data.setDataBase("automotriz");
		data.setUser("root");
		data.setPassword("root");
		txtNombre = new JTextField();
	}

}
