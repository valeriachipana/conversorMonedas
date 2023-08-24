import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Insets;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class Conversor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField valor;
	private JPanel contentPane;
	private JComboBox opciones;
	private JButton botonConvertir;
	private JLabel resultado;
	
	// equivalencias a soles
	public double dolar=3.7;
	public double euro=4.0;
	public double libra=4.67;
	public double yen=0.025;
	public double won=0.0028;
	
	double tipoCambio=0.00;
	double resulFinal=0.00;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor frame = new Conversor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Conversor() {
		setTitle("Conversor De Monedas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 358);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(0, 10, 0, 10));
		menuBar.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.setForeground(new Color(255, 255, 255));
		menuBar.setBackground(SystemColor.menu);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Modo");
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.setFont(new Font("Arial", Font.PLAIN, 12));
		mnNewMenu.setForeground(new Color(128, 128, 128));
		mnNewMenu.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Modo oscuro");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(new Color(181, 176, 154));

			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Modo claro");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(UIManager.getColor("Button.background"));
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmMulticolor = new JMenuItem("Multicolor");
		mntmMulticolor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(new Color(170, 152, 176));
			}
		});
		mnNewMenu.add(mntmMulticolor);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConversorDe = new JLabel("CONVERSOR DE");
		lblConversorDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblConversorDe.setForeground(Color.WHITE);
		lblConversorDe.setFont(new Font("Arial", Font.BOLD, 26));
		lblConversorDe.setBounds(303, 53, 210, 34);
		contentPane.add(lblConversorDe);
		
		JLabel lblMonedas = new JLabel("MONEDAS");
		lblMonedas.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonedas.setForeground(Color.WHITE);
		lblMonedas.setFont(new Font("Arial", Font.BOLD, 26));
		lblMonedas.setBounds(303, 83, 210, 34);
		contentPane.add(lblMonedas);
		
		opciones = new JComboBox();
		opciones.setFont(new Font("Arial", Font.PLAIN, 14));
		opciones.setModel(new DefaultComboBoxModel(new String[] {"De Soles a Dólares", "De Soles a Euros", "De Soles a Libras Esterlinas", "De Soles a Yen Japonés", "De Soles a Won Sur-coreano", "De Dólares a Soles", "De Euros a Soles", "De Libras Esterlinas a Soles", "De Yen Japonés a Soles", "De Won Sur-coreano a Soles"}));
		opciones.setBounds(27, 80, 217, 24);
		contentPane.add(opciones);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese un monto:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(27, 123, 148, 24);
		contentPane.add(lblNewLabel_1);
		
		valor = new JTextField();
		valor.setBounds(27, 147, 217, 20);
		contentPane.add(valor);
		valor.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Elija una opción:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(27, 53, 120, 24);
		contentPane.add(lblNewLabel_2);
		
		botonConvertir = new JButton("Convertir");
		botonConvertir.setForeground(Color.WHITE);
		botonConvertir.setBackground(new Color(27, 20, 67));
		botonConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String valor2=valor.getText();
				double valorNum = Double.parseDouble(valor2);
				
				if(opciones.getSelectedIndex()==0) {
					resulFinal = convertirDeSoles(valorNum, tipoCambio=dolar);
				} else if(opciones.getSelectedIndex()==1){
					resulFinal = convertirDeSoles(valorNum, tipoCambio=euro);
				} else if(opciones.getSelectedIndex()==2){
					resulFinal = convertirDeSoles(valorNum, tipoCambio=libra);
				} else if(opciones.getSelectedIndex()==3){
					resulFinal = convertirDeSoles(valorNum, tipoCambio=yen);
				} else if(opciones.getSelectedIndex()==4){
					resulFinal = convertirDeSoles(valorNum, tipoCambio=won);
				} else if(opciones.getSelectedIndex()==5){
					resulFinal = convertirASoles(valorNum, tipoCambio=dolar);
				} else if(opciones.getSelectedIndex()==6){
					resulFinal = convertirASoles(valorNum, tipoCambio=euro);
				} else if(opciones.getSelectedIndex()==7){
					resulFinal = convertirASoles(valorNum, tipoCambio=libra);
				} else if(opciones.getSelectedIndex()==8){
					resulFinal = convertirASoles(valorNum, tipoCambio=yen);
				} else if(opciones.getSelectedIndex()==9){
					resulFinal = convertirASoles(valorNum, tipoCambio=won);
				}
				DecimalFormat formatear = new DecimalFormat("0.00");
				resultado.setText("Resultado: " + formatear.format(resulFinal));
			}
		});
		botonConvertir.setFont(new Font("Arial", Font.BOLD, 14));
		botonConvertir.setBounds(75, 231, 120, 24);
		contentPane.add(botonConvertir);
		
		JButton botonSalir = new JButton("Salir");
		botonSalir.setBackground(new Color(255, 255, 255));
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		botonSalir.setFont(new Font("Arial", Font.PLAIN, 12));
		botonSalir.setBounds(364, 232, 89, 23);
		contentPane.add(botonSalir);
		
		resultado = new JLabel("Resultado:");
		resultado.setFont(new Font("Arial", Font.PLAIN, 14));
		resultado.setBounds(27, 185, 217, 24);
		contentPane.add(resultado);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setForeground(new Color(0, 51, 153));
		lblNewLabel_3.setIcon(new ImageIcon(Conversor.class.getResource("/com/images/sunset.jpg")));
		lblNewLabel_3.setBounds(263, 0, 300, 297);
		contentPane.add(lblNewLabel_3);
	}
	
	public double convertirDeSoles(double valorNum, double tipoCambio) {
		return (valorNum/tipoCambio);
	}
	
	public double convertirASoles(double valorNum, double tipoCambio) {
		return (valorNum*tipoCambio);
	}
}
